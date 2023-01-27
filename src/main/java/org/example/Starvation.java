package org.example;

import java.util.List;

public class Starvation extends Thread {
    private List<Animal> animals;
    Report report;

    public Starvation(List<Animal> animals, Report report) {
        this.animals = animals;
        this.report = report;
    }


    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < animals.size(); i++) {
                Animal a = animals.get(i);

                    //System.out.println(a.getAnimalType()  + " die OT GOLODA");

                a.setHealth(a.getHealth() - Parameters.STARVATION_HEALTH_IN_SEC);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
