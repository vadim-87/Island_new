package org.example.sergeyev.vadim.Island_Project.Engine;

import org.example.sergeyev.vadim.Island_Project.Model.Creature.Animal;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private static int DAY = 1;
    public static int initOfAnimals = 0;
    List<Animal> listOfAnimalDie;
    List<Animal> listOfAnimalBorn;

    public Report() {
        listOfAnimalDie = new ArrayList<>();
        listOfAnimalBorn = new ArrayList<>();
    }


    public void printListAnimal(List<Animal> list) {
        for (int i = 0; i < list.size(); i++) {
            Animal a = list.get(i);
            System.out.println(i + " " + a);

        }


    }


    public void printAllIslandStatistic(List<Animal> allAnimalsOnIsland) {

        System.out.println("DAY " + DAY);
        System.out.println("Born on this day: " + listOfAnimalBorn.size() + " animals");
        System.out.println("Die on this day: " + listOfAnimalDie.size() + " animals");

        DAY++;

    }

    public void animalReproduce(Animal animal) {
        listOfAnimalBorn.add(animal);
    }

    public void animalDeath(Animal animal) {
        listOfAnimalDie.add(animal);
    }
}
