package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.example.AnimalType.*;
import static org.example.Parameters.*;

public class Island {
    private Map<Position, Cell> islandMap;
    private final Map<AnimalType, Integer> initialCount = Map.of(BOA, 30, WOLF, 30, EAGLE, 20, FOX, 30);
   // private final List<AnimalType> animalTypesList = Arrays.asList(WOLF, BOA, FOX, EAGLE);
    private final List<AnimalType> animalTypesList = Arrays.asList(BOA, FOX);
    private List<Animal> allAnimalsOnIsland;
    public static int height = ISLAND_HEIGHT;
    public static int length = ISLAND_LENGTH;

    public Island() {
        initializeIsland();
    }

    private void initializeIsland() {
        islandMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                Position position = new Position(i, j);
                Cell cell = new Cell(position);
                islandMap.put(position, cell);
            }
        }
        addAnimalsToIsland();
    }

    public void addAnimalsToIsland() {
        Animal newAnimal = null;
        allAnimalsOnIsland = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        for (Map.Entry<Position, Cell> entry : islandMap.entrySet()) {
            Cell currentCell = entry.getValue();
            for (AnimalType type : animalTypesList) {
                int maxAnimalCount = initialCount.get(type);
                int currentAnimalCount = ThreadLocalRandom.current().nextInt(1, maxAnimalCount);
                for (int i = 0; i < currentAnimalCount; i++) {
                    newAnimal = animalFactory.createAnimal(type, currentCell);
                    newAnimal.setAnimalType(type);
                    allAnimalsOnIsland.add(newAnimal);
                }
            }
            currentCell.addAnimalsToCurrentCell(newAnimal);

        }

    }


    public void start() {
        islandMap.forEach((key, value) -> {
           List<Animal> list = value.getAllAnimalsInCurrentCell();
            for (int i = 0; i < list.size(); i++) {

            }
        });
    }

    void printAnimalCount() {
        int fox = 0;
        int boa = 0;
        int eagle = 0;
        int wolf = 0;
        for (Animal a : allAnimalsOnIsland) {
            if (a instanceof Fox) fox++;
            if (a instanceof Boa) boa++;
            if (a instanceof Eagle) eagle++;
            if (a instanceof Wolf) wolf++;
        }
        System.out.printf("Fox=%s, Boa=%s, Eagle=%s, Wolf=%s, all count=%s\n", fox, boa, eagle, wolf, allAnimalsOnIsland.size());
        Animal one = allAnimalsOnIsland.get(15);
        Animal two = allAnimalsOnIsland.get(45);
        int x = one.interactions(two);
        System.out.println(x);

    }

    void printAllCells() {
        for (Map.Entry<Position, Cell> entry : islandMap.entrySet()) {
            Cell currentCell = entry.getValue();
            System.out.println(currentCell);
        }
    }

}