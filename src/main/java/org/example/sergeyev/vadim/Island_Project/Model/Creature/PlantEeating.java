package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;

import java.util.List;

public abstract class PlantEeating extends Animal implements Eatable, Edible {

    public PlantEeating(Cell cell) {
        super(cell);
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

