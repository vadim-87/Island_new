package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Rabbit extends PlantEeating {
    public Rabbit(Cell cell) {
        super(cell);
        this.setWeight(2);
        this.setSpeed(2);

    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
