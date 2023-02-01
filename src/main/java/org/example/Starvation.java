package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Starvation extends Thread {
    private List<Animal> animals;
    Report report;

    //
//    public Starvation(List<Animal> animals, Report report) {
//        this.animals = animals;
//        this.report = report;
//    }
    public Starvation(List<Animal> allAnimalsOnIsland) {
        this.animals = allAnimalsOnIsland;
    }


    //    @Override
//    public void run() {
//
//        while (true) {
//            for (int i = 0; i < animals.size(); i++) {
//                try {
//                    animals.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                Animal a = animals.get(i);
//                if (a.getHealth() < 10) {
//                    a.setAlive(false);
//                }
//
//
//                a.setHealth(a.getHealth() - Parameters.STARVATION_HEALTH_IN_SEC);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        }
//    }
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
