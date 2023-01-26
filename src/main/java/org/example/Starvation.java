package org.example;

import java.util.concurrent.Callable;

public class Starvation extends Thread {
    Animal animal;

    public Starvation(Animal animal) {
        this.animal = animal;
    }


    @Override
    public void run() {
        while (animal.isAlive()){
            animal.setHealth(animal.getHealth()-10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
