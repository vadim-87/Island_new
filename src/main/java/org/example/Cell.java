package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Position position;
    private List<Animal> animalsInCurrentCell = new ArrayList<>();
    private List<Plant> plantsInCurrentCell = new ArrayList<>();

    public Cell(Position position) {
        this.position = position;
    }

    public void actionsInCells(Report report, List<Animal> allAnimalsOnIsland) {
        List<Animal> animalsInCurrentCell = this.animalsInCurrentCell
                .stream()
                //.filter(Animal::isAlive)
                .toList();
        for (int i = 0; i < animalsInCurrentCell.size(); i++) {
            Animal animal_1 = animalsInCurrentCell.get(i);
            for (int j = i + 1; j < animalsInCurrentCell.size(); j++) {
                Animal animal_2 = animalsInCurrentCell.get(j);
                int codeOfAction = Parameters.ANIMAL_COMPATIBILITY_MATRIX[animal_1.getAnimalType().getIndex()][animal_2.getAnimalType().getIndex()];
                boolean swap = false;
                if (codeOfAction == 0) {
                    codeOfAction = Parameters.ANIMAL_COMPATIBILITY_MATRIX[animal_2.getAnimalType().getIndex()][animal_1.getAnimalType().getIndex()];
                    swap = true;
                }
                if (codeOfAction == 1) {
                    if (animal_1.tryingToReproductive(animal_2, allAnimalsOnIsland)) {
                        report.animalReproduce(animal_2);

                    }
                } else if (codeOfAction > 1) {
                    if (swap) {
                        if (animal_2.tryingToEat(animal_1, codeOfAction, allAnimalsOnIsland)) {
                            report.animalDeath(animal_1);

                        }
                    } else {
                        if (animal_1.tryingToEat(animal_2, codeOfAction, allAnimalsOnIsland)) {
                            report.animalDeath(animal_2);
                        }
                    }
                }
            }
            break;
        }
    }

    public void moveBetweenCell(List<Animal> allAnimalsOnIsland) {
        for (int i = 0; i < animalsInCurrentCell.size(); i++) {
            Animal a = animalsInCurrentCell.get(i);
            a.move();
        }
    }

    public boolean canMoveInThisCell(){
        return true;
    }

    public synchronized void removeFromCell(Animal animal) {
        animalsInCurrentCell.remove(animal);
    }

    public void addAnimalsToCurrentCell(Animal animal) {
        animalsInCurrentCell.add(animal);
    }

    public List<Plant> getPlantsInCurrentCell() {
        return plantsInCurrentCell;
    }

    public List<Animal> getAnimalsInCurrentCell() {
        return animalsInCurrentCell;
    }

    public Position getPosition() {
        return position;
    }


}
