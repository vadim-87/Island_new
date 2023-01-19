package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Position position;

    public List<Animal> getAllAnimalsInCurrentCell() {
        return allAnimalsInCurrentCell;
    }

    private List<Animal> allAnimalsInCurrentCell = new ArrayList<>();

    public Cell(Position position) {
        this.position = position;
    }

    public void addAnimalsToCurrentCell(Animal animal) {
        allAnimalsInCurrentCell.add(animal);
        //System.out.println(allAnimalsInCurrentCell);
    }

    public void removeFromCurrentCell(Animal animal) {
        allAnimalsInCurrentCell.remove(animal);
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
        for (Animal a : allAnimalsInCurrentCell) {
            if (a instanceof Fox) fox++;
            if (a instanceof Boa) boa++;
            if (a instanceof Eagle) eagle++;
            if (a instanceof Wolf) wolf++;
        }
        return " In cell{" +
                "x=" + position.getHeight() + ", y=" + position.getLength() +
                '}' + " are: " + " \uD83E\uDD8A=" + fox + ", \uD83D\uDC0D=" + boa + ", \uD83E\uDD85=" + eagle + ", \uD83D\uDC3A=" + wolf;
    }
}