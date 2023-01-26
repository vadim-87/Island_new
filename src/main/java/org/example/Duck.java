package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Duck extends PlantEeating {
    public Duck(Cell cell) {
        super(cell);
        this.setWeight(1);
    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
