package org.example;

import java.util.List;

public abstract class Predator extends Animal implements Eatable, Edible {
    private Cell cell;

    public Predator(Cell cell) {
        super(cell);
    }


    @Override
    public boolean eat(Edible foodstuff) {
        Animal animal = (Animal) foodstuff;
        double ateUp = animal.getWeight() * Parameters.INDEX_OF_ATE_UP;
        this.setHealth(this.getHealth() + ateUp);
        //System.out.println(this.getAnimalType() + " " + this.getHealth());
        return false;
    }

    @Override
    public void beEaten(List<Animal> listAllAnimals) {
        this.getCell().removeFromCell(this);
        this.setAlive(false);
        listAllAnimals.remove(this);
    }
}
