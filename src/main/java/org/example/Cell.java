package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Position position;

    private List<Animal> allAnimalsInCurrentCell = new ArrayList<>();

    public Cell(Position position) {
        this.position = position;
    }

    public void addAnimalsToCurrentCell(Animal animal) {
        allAnimalsInCurrentCell.add(animal);
        //System.out.println("to "+  this + " added animal: " + animal.toString());

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
        return "Cell{" +
                "x=" + position.getHeight() + ", y=" + position.getLength() +
                '}' + allAnimalsInCurrentCell;
    }

}