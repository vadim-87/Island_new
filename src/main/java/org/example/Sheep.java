package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Sheep extends PlantEeating {
    public Sheep(Cell cell) {
        super(cell);
        this.setWeight(70);
        this.setSpeed(3);

    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
