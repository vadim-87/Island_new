package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Main {
//        List<Class<? extends Animal>> list = new ArrayList<>();
//        List<Type> list2 = new ArrayList<>();
//        list2.add(Cat.class);
//        list.add(Cat.class);
//        list.add(Lion.class);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//
//        }
//Animal fff =  catClass.newInstance();
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list.get(i));
//
////        }
//        List<Class<? extends Animal>> listAllTypesOfAnimal = new ArrayList<>();
//
//        Class<Cat> catClass = Cat.class;
//        Class<Lion> lionClass = Lion.class;
//        listAllTypesOfAnimal.add(catClass);
//        listAllTypesOfAnimal.add(lionClass);
//
//        List<Animal> animalList = new ArrayList<>();
//
//        for (int i = 0; i < listAllTypesOfAnimal.size(); i++) {
//            Random r = new Random();
//            int l = r.nextInt(25);
//            Animal animal = listAllTypesOfAnimal.get(i).getDeclaredConstructor(int.class).newInstance(l);
//            animalList.add(animal);
//
//        }
//
//
//        for (int i = 0; i < animalList.size(); i++) {
//            System.out.println(animalList.get(i).toString());
//        }


    public static void main(String[] arg) throws InterruptedException {
        Island island = new Island();
        //island.start();
        //island.printAllCells();
        island.printAllCells();
//        Animal l = new Eagle(new Cell(new Position(5, 6)));
//        l.getCurrentPosition();
//        Animal cat = new Fox(new Cell(new Position(65, 98)));
//        System.out.println(cat.getMaxNumberOfPopulation());

        Animal fox = new Fox(new Cell(new Position(54, 69)));


    }

}