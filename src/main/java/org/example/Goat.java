package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Goat extends PlantEeating {
    public Goat(Cell cell) {
        super(cell);
        this.setWeight(60);
    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}