package org.example;

import java.util.*;
import java.util.concurrent.*;


public class Island {

    private Map<Position, Cell> islandMap;
    private List<Animal> allAnimalsOnIsland;
    public static final int height = Parameters.ISLAND_HEIGHT;
    public static final int length = Parameters.ISLAND_LENGTH;

    public Island() {
        initializeIsland();
        plantsGrowOnIsland();//?????? ??????
        addAnimalsToIsland();//??????? ??????
    }

    private void initializeIsland() {//?????? ??????
        islandMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                Position position = new Position(i, j);
                Cell cell = new Cell(position);
                islandMap.put(position, cell);
            }
        }
    }

    private void plantsGrowOnIsland() {
        islandMap.forEach((position, cell) -> {
            List<Plant> plantsOnCurrentCell = cell.getPlantsInCurrentCell();
            int count = ThreadLocalRandom.current().nextInt(1, 200);
            for (int i = 0; i < count; i++) {
                plantsOnCurrentCell.add(new Plant(cell));
            }
        });

//        Runnable growPlantsTask = new GrowPlants();
//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(growPlantsTask, 1, 2, TimeUnit.SECONDS);


    }

    private void addAnimalsToIsland() {
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

    }



    public void newDayStart() {
        System.out.println("ALLLLLL  on NACHALO DAY " + allAnimalsOnIsland.size());

        Report report = new Report();
        Starvation st = new Starvation(allAnimalsOnIsland, report);
        st.start();//запустил голодуху
        actionsInsideCells(report);
        movementBetweenCells();
        //graveyard(allAnimalsOnIsland);
        report.printAllIslandStatistic(allAnimalsOnIsland);

        System.out.println("ALLLLLL  on END DAY " + allAnimalsOnIsland.size());


    }

    private void graveyard(List<Animal> allAnimalsOnIsland) {
        for (int i = 0; i < allAnimalsOnIsland.size(); i++) {
            System.out.println(allAnimalsOnIsland.get(i));
        }
    }


    private void actionsInsideCells(Report report) {
        islandMap.forEach((position, cell) -> {
            cell.actionsInCells(report, allAnimalsOnIsland);
        });
        System.out.println(allAnimalsOnIsland.get(2).getAnimalType() + " " +allAnimalsOnIsland.get(2).getHealth());
    }

    private void movementBetweenCells() {
        islandMap.forEach((position, cell) -> {
            cell.moveBetweenCell(allAnimalsOnIsland);
        });
    }

}
