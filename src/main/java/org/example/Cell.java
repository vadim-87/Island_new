package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    @Override
    public String toString() {
        return "Cell{" +
                "position=" + position +
                '}';
    }

    private Position position;
    private List<Animal> allAnimalsInCurrentCell = new ArrayList<>();
    private List<Class<? extends Animal>> listOfAnimalTypes;

    public Cell(Position position) {
        this.position = position;
    }

    public void addAnimalsToIsland(Animal animal){
        for (int i = 0; i < 10; i++) {
            allAnimalsInCurrentCell.add(animal);
        }
    }

    public void removeFromItems(Animal animal){
        allAnimalsInCurrentCell.remove(animal);
    }

    public Position getPosition() {
        return position;
    }

    public void processCell() {//todo
        for(Animal ic : allAnimalsInCurrentCell){
            if(ic.getClass() == Fox.class) {
                //todo
            }
        }
    }

}
