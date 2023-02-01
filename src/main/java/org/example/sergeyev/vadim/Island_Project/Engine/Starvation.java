package org.example.sergeyev.vadim.Island_Project.Engine;


import org.example.sergeyev.vadim.Island_Project.Model.Creature.Animal;

import java.util.List;

public class Starvation extends Thread {
    private List<Animal> animals;

    public Starvation(List<Animal> allAnimalsOnIsland) {
        this.animals = allAnimalsOnIsland;
    }


    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                animal.setHealth(animal.getHealth() - 10);

            }try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
