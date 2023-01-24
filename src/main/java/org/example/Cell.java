package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cell {

    private Position position;
    private List<Animal> allAnimalsInCurrentCell = new ArrayList<>();
    public Cell(Position position) {
        this.position = position;
    }



    public List<Animal> getAllAnimalsInCurrentCell() {
        return allAnimalsInCurrentCell;
    }


    public synchronized void removeFromCell(Animal animal){
        allAnimalsInCurrentCell.remove(animal);
    }




    public void addAnimalsToCurrentCell(Animal animal) {
        allAnimalsInCurrentCell.add(animal);
        //System.out.println(allAnimalsInCurrentCell);
    }


    public Position getPosition() {
        return position;
    }

    public void processCell() {//todo
        for (Animal ic : allAnimalsInCurrentCell) {
            if (ic.getClass() == Fox.class) {
                //todo
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
        for (Animal a : allAnimalsInCurrentCell) {
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

    void printCellStatistic() {
        List<Animal> collect = allAnimalsInCurrentCell.stream()
                .filter(type -> type.getAnimalType() == AnimalType.BEAR).toList();
    }
}
