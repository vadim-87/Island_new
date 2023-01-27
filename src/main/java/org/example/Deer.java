package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Deer extends PlantEeating {
    public Deer(Cell cell) {
        super(cell);
        this.setWeight(300);
        this.setSpeed(4);

    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
