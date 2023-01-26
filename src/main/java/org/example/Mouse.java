package org.example;

import org.example.Cell;
import org.example.PlantEeating;
import org.example.Position;

public class Mouse extends PlantEeating {
    public Mouse(Cell cell) {
        super(cell);
        this.setWeight(0.05);
    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
