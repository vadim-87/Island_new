package org.example.sergeyev.vadim.Island_Project.Engine;

import org.example.sergeyev.vadim.Island_Project.Model.Creature.*;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;

public class AnimalFactory {


    public Animal createAnimal (AnimalType animal, Cell cell){
        return switch (animal) {
            case BOA -> new Boa(cell);
            case FOX -> new Fox(cell);
            case EAGLE -> new Eagle(cell);
            case WOLF -> new Wolf(cell);
            case BEAR -> new Bear(cell);
            case HORSE -> new Horse(cell);
            case CATERPILLAR -> new Caterpillar(cell);
            case DEER -> new Deer(cell);
            case RABBIT -> new Rabbit(cell);
            case MOUSE -> new Mouse(cell);
            case GOAT -> new Goat(cell);
            case SHEEP -> new Sheep(cell);
            case BOAR -> new Boar(cell);
            case BULL -> new Bull(cell);
            case DUCK -> new Duck(cell);
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + animal);
        };
    }
}
