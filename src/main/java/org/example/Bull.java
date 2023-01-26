package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Bull extends PlantEeating {
    public Bull(Cell cell) {
        super(cell);
        this.setWeight(700);
    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
