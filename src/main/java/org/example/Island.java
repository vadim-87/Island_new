package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.example.AnimalTypes.*;
import static org.example.Parameters.*;

public class Island {
    private Map<Position, Cell> islandMap;
    private final Map<AnimalTypes, Integer> initialCount = Map.of(BOA, 30, WOLF, 30, EAGLE, 20, FOX, 30);
    private final List<AnimalTypes> animalTypesList = Arrays.asList(WOLF, BOA, FOX, EAGLE);
    private List<Animal> allAnimalsOnIsland;
    public static int height = ISLAND_HEIGHT;
    public static int length = ISLAND_LENGTH;

    public Island() {
        init();
    }

    private void init() {
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
            for (AnimalTypes type : animalTypesList) {
                int maxAnimalCount = initialCount.get(type);
                int currentAnimalCount = ThreadLocalRandom.current().nextInt(1, maxAnimalCount);
                for (int i = 0; i < currentAnimalCount; i++) {
                    newAnimal = animalFactory.createAnimal(type, currentCell);
                    allAnimalsOnIsland.add(newAnimal);
                }
            }
            currentCell.addAnimalsToCurrentCell(newAnimal);

        }

    }


    public void start() {

        for (Animal animal : allAnimalsOnIsland) {
        }

//        }
//        for (Animal animal:allAnimalsOnIsland) {
//            System.out.println(animal);
//        }
//
//        while (allAnimalsOnIsland.size() > 0) {//TODO
//            for (Animal it : allAnimalsOnIsland) {
//                Cell newCell = islandMap.get(it.getNewPosition());
//                it.move(newCell);
//            }
//
//            for (Cell cell : islandMap.values()) {
//                cell.processCell();
//
//            }
    }

    void printNumberAnimals() {
//        islandMap.forEach((key, value) -> {
//            System.out.println(value.toString());
//        });
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
        System.out.printf("Fox %s, Boa %s, Eagle %s, Wolf %s", fox, boa, eagle, wolf);
    }

    void printAllCells() {
        for (Map.Entry<Position, Cell> entry : islandMap.entrySet()) {
            Cell currentCell = entry.getValue();
            System.out.println(currentCell);
        }
    }

}