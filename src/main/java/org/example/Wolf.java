package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Position;

public class Wolf extends Animal {
    public Wolf(Cell cell) {
        super(cell);
    }

    @Override
    public String toString() {
        return "Wolf, координаты высота: " + this.getCurrentPosition().getHeight()
                + " ширина " + this.getCurrentPosition().getLength();
    }

    @Override
    int getMaxNumberOfPopulation() {
        return 10;
    }

    @Override
    Position getNewPosition() {
        return null;
    }

}
