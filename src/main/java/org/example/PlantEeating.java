package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PlantEeating extends Animal implements Eatable, Edible {

    public PlantEeating(Cell cell) {
        super(cell);
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public void eat(double food) {
        System.out.println("PLANTING EAT");
        this.setHealth(getHealth() + food * 0.1);
    }

    @Override
    public synchronized void die(List<Animal> listAllAnimals) {
        this.getCell().removeFromCell(this);
        this.setAlive(false);
        listAllAnimals.remove(this);
    }
}

