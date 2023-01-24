package org.example;

import java.util.List;

public abstract class PlantEeating extends Animal implements Eatable, Edible {

    public PlantEeating(Cell cell) {
        super(cell);

    }

    @Override
    public boolean eat(Edible food) {
        System.out.println("I AM PLANT EATING");
        return false;
    }

    @Override
    public void beEaten(List<Animal> listAllAnimals) {
        this.getCell().removeFromCell(this);
        this.setAlive(false);
        listAllAnimals.remove(this);
    }
}

