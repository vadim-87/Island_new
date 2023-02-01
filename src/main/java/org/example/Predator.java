package org.example;

import java.util.List;

public abstract class Predator extends Animal implements Eatable, Edible {

    public Predator(Cell cell) {
        super(cell);
    }


    @Override
    public void eat(double food) {
        this.setHealth(food * 0.1);
        //System.out.println(this.getAnimalType() + " " + this.getHealth());
    }

    @Override
    public void die(List<Animal> allAnimalsOnIsland) {
        this.getCell().removeFromCell(this);
        this.setAlive(false);
        allAnimalsOnIsland.remove(this);
    }
}
