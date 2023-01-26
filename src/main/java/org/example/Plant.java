package org.example;

import java.util.ArrayList;
import java.util.List;

public class Plant implements Edible {
    private Cell cell;
    private double weight;



    public Plant(Cell cell) {
        this.cell = cell;
        this.weight = 1;
    }

    @Override
    public void die(List<Animal> listAllAnimals) {
    }

}
