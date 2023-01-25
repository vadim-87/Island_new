package org.example;

import java.util.List;

public class Horse extends PlantEeating {
    public Horse(Cell cell) {
        super(cell);
        this.setWeight(400);
    }

    @Override
    Position getNewPosition() {
        return this.getCurrentPosition();
    }


    @Override
    public void beEaten(List<Animal> listAllAnimals) {
    }
}
