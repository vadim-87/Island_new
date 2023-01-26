package org.example;

import java.util.List;

public class Starvation extends Thread {
    private List<Animal> animals;
    ReportClass report;

    public Starvation(List<Animal> animals, ReportClass report) {
        this.animals = animals;
        this.report = report;
    }


    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getHealth() <= 10 || !animals.get(i).isAlive()) {
                    animals.get(i).setAlive(false);
                    report.animalDeath(animals.get(i));
                    continue;
                }
                    Animal a = animals.get(i);
                    a.setHealth(a.getHealth() - 10);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

            }
        }
    }
}
