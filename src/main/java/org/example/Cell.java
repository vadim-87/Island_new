package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Position position;
    private List<Animal> animalsInCurrentCell = new ArrayList<>();
    private List<Plant> plantsInCurrentCell = new ArrayList<>();

    public List<Plant> getPlantsInCurrentCell() {
        return plantsInCurrentCell;
    }


    public Cell(Position position) {
        this.position = position;
    }



    public List<Animal> getAnimalsInCurrentCell() {
        return animalsInCurrentCell;
    }

    public synchronized void removeFromCell(Animal animal){
        animalsInCurrentCell.remove(animal);
    }

    public void addAnimalsToCurrentCell(Animal animal) {
        animalsInCurrentCell.add(animal);
    }


    public Position getPosition() {
        return position;
    }

    public void processCell(ReportClass report, List<Animal> allAnimalsOnIsland) {
        List<Animal> animalsInCurrentCell = getAnimalsInCurrentCell().stream().toList();
        for (int i = 0; i < animalsInCurrentCell.size(); i++) {
            Animal animal_1 = animalsInCurrentCell.get(i);
            if (animal_1.isAlive()) {
                for (int j = i + 1; j < animalsInCurrentCell.size(); j++) {
                    Animal animal_2 = animalsInCurrentCell.get(j);
                    if (animal_2.isAlive()) {
                        int codeOfAction = Parameters.animalCompatibilityMatrix[animal_1.getAnimalType().getIndex()][animal_2.getAnimalType().getIndex()];
                        boolean round = false;
                        if (codeOfAction == 0) {
                            codeOfAction = Parameters.animalCompatibilityMatrix[animal_2.getAnimalType().getIndex()][animal_1.getAnimalType().getIndex()];
                            round = true;
                        }
                        if (codeOfAction == 1) {
                            if (animal_1.tryingToReproductive(animal_2, allAnimalsOnIsland)) {
                                report.animalReproduce(animal_2);
                            }
                        } else if (codeOfAction > 1) {
                            if (round) {
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
    }


    @Override
    public String toString() {
        int fox = 0;
        int boa = 0;
        int eagle = 0;
        int wolf = 0;
        int bear = 0;
        for (Animal a : animalsInCurrentCell) {
            if (a instanceof Fox) fox++;
            if (a instanceof Boa) boa++;
            if (a instanceof Eagle) eagle++;
            if (a instanceof Wolf) wolf++;
            if (a instanceof Bear) bear++;
        }
        return " In cell{" +
                "x=" + position.getHeight() + ", y=" + position.getLength() +
                '}' + " are: " + " \uD83E\uDD8A=" + fox + ", \uD83D\uDC0D=" + boa + ", \uD83E\uDD85=" + eagle + ", \uD83D\uDC3A=" + wolf + "\uD83D\uDC3B=" + bear;
    }
}
