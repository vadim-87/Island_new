package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.example.Parameters.*;

public class Island {
    private Map<Position, Cell> islandMap;
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
        allAnimalsOnIsland = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        islandMap.forEach((key, value) -> {
            Animal newAnimal = null;
            for (AnimalType type : animalTypesList) {
                int maxAnimalCount = initialCount.get(type);
                int currentAnimalCount = ThreadLocalRandom.current().nextInt(1, maxAnimalCount);
                for (int i = 0; i < currentAnimalCount; i++) {
                    newAnimal = animalFactory.createAnimal(type, value);
                    newAnimal.setAnimalType(type);
                    allAnimalsOnIsland.add(newAnimal);
                }
            }
            value.addAnimalsToCurrentCell(newAnimal);
        });
        ReportClass.initOfAnimals = allAnimalsOnIsland.size();
    }

    public void newDayStart() {
        ReportClass report = new ReportClass();
        report.printAllIslandStatistic(allAnimalsOnIsland);
        islandMap.forEach((key, currentCell) -> {
            List<Animal> animalsInCurrentCell = currentCell.getAllAnimalsInCurrentCell().stream().toList();
            for (int i = 0; i < animalsInCurrentCell.size(); i++) {
                Animal animal_1 = animalsInCurrentCell.get(i);
                if (animal_1.isAlive) {
                    for (int j = i + 1; j < animalsInCurrentCell.size(); j++) {
                        Animal animal_2 = animalsInCurrentCell.get(j);
                        if (animal_2.isAlive) {
                            int codeOfAction = animal_1.actionBetweenAnimals(animal_2);
                            boolean test = false;
                            if (codeOfAction == 0) {
                                codeOfAction = animal_2.actionBetweenAnimals(animal_1);
                                test = true;
                            }
                            if (codeOfAction == 1) {
                                if (animal_1.tryingToReproductive(animal_2, allAnimalsOnIsland)) {
                                    report.animalReproduce(animal_2);
                                }
                            } else if (codeOfAction > 1) {
                                if (test) {
                                    if (animal_2.tryingToEat(animal_1, codeOfAction, allAnimalsOnIsland)) {
                                        report.animalDeath(animal_1);
                                    }
                                } else {
                                    if (animal_1.tryingToEat(animal_2, codeOfAction, allAnimalsOnIsland)) {
                                        report.animalDeath(animal_2);
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        });
        report.printAllIslandStatistic(allAnimalsOnIsland);
    }
}