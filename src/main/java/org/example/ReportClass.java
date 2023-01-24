package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Parameters.*;

public class ReportClass {
    public static int initOfAnimals = 0;
    List<Animal> listOfAnimalDie;
    List<Animal> listOfAnimalBorn;

    public ReportClass() {
       listOfAnimalDie = new ArrayList<>();
       listOfAnimalBorn = new ArrayList<>();
    }


    public void printListAnimal (List<Animal> list){
        for (int i = 0; i < list.size(); i++) {
            Animal a = list.get(i);
            System.out.println(i + " " + a);

        }



    }


    public void printAllIslandStatistic (List<Animal> list){
        int x = initOfAnimals + listOfAnimalBorn.size() - listOfAnimalDie.size();
        for (int i = 0; i < animalTypesList.size(); i++) {
            AnimalType type = animalTypesList.get(i);
            List<Animal> collect = list.stream().filter(animal -> animal.getAnimalType() == type).toList();
            System.out.println(type + "S=" + collect.size());
        }
        System.out.println("all animals " + list.size());
        System.out.println("Born on this day: " + listOfAnimalBorn.size() + " animals");
        System.out.println("Die on this day: " + listOfAnimalDie.size() + " animals");
        System.out.println(x);

    }

    public void animalReproduce(Animal animal) {
        listOfAnimalBorn.add(animal);
    }

    public void animalDeath(Animal animal) {
        listOfAnimalDie.add(animal);
    }
}
