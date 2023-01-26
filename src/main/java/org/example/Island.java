package org.example;

import java.util.*;
import java.util.concurrent.*;


public class Island implements Callable<Runnable> {

    private Map<Position, Cell> islandMap;
    private List<Animal> allAnimalsOnIsland;
    public static int height = Parameters.ISLAND_HEIGHT;
    public static int length = Parameters.ISLAND_LENGTH;

    public Island()  {
        initializeIsland();
    }

    private void initializeIsland()  {//создал остров
        System.out.println("Island initialization");
        islandMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                Position position = new Position(i, j);
                Cell cell = new Cell(position);
                islandMap.put(position, cell);
            }
        }
        plantsGrow();//засеял травой
        addAnimalsToIsland();//заселил зверей
    }

    private void plantsGrow() {

        System.out.println("ADD Plants");
        islandMap.forEach((position, cell) -> {
            List<Plant> plantsOnCurrentCell = cell.getPlantsInCurrentCell();
            int count = ThreadLocalRandom.current().nextInt(1, 200);
            for (int i = 0; i < count; i++) {
                plantsOnCurrentCell.add(new Plant(cell));
            }
            //System.out.println("in Cell" + cell.getPosition().getLength() + ", " + cell.getPosition().getHeight() + " add " + count + "plants");
        });

//        Runnable growPlantsTask = new GrowPlants();
//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(growPlantsTask, 1, 2, TimeUnit.SECONDS);


    }

    public void addAnimalsToIsland() {
        System.out.println("ADD Animals on island");
        allAnimalsOnIsland = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        islandMap.forEach((key, cell) -> {
            Animal newAnimal = null;

            for (AnimalType type : Parameters.ANIMAL_TYPE_LIST) {
                int maxAnimalCount = type.getMaxCountInCell();
                int currentAnimalCount = ThreadLocalRandom.current().nextInt(1, maxAnimalCount);
                for (int i = 0; i < currentAnimalCount; i++) {
                    newAnimal = animalFactory.createAnimal(type, cell);
                    newAnimal.setAnimalType(type);
                    allAnimalsOnIsland.add(newAnimal);
                }
            }
            cell.addAnimalsToCurrentCell(newAnimal);

        });
        ReportClass.initOfAnimals = allAnimalsOnIsland.size();

    }


    public void newDayStart() {

        actionsInsideCells();
        movementBetweenCells();
        nightSleep();
    }


    private void actionsInsideCells() {
        ReportClass report = new ReportClass();
        islandMap.forEach((position, cell) -> {
            cell.processInCell(report, allAnimalsOnIsland);
        });
        report.printAllIslandStatistic(allAnimalsOnIsland);
    }

    private void movementBetweenCells() {


    }

    private void nightSleep() {
    }




    @Override
    public Runnable call() throws Exception {
        newDayStart();
        return null;
    }
}
