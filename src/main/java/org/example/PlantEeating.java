package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PlantEeating extends Animal implements Eatable, Edible {

    public PlantEeating(Cell cell) {
        super(cell);

    }

    @Override
    public boolean eat(Edible food) {
        return false;
    }

    @Override
    public void beEaten(List<Animal> listAllAnimals) {
        Set<Plant> set = new HashSet<>();
        this.getCell().removeFromCell(this);
        this.setAlive(false);
        listAllAnimals.remove(this);
    }
}

