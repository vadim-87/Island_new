package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Position;

public class Boa extends Animal {
    public Boa(Cell cell) {
        super(cell);
    }

    @Override
    int getMaxNumberOfPopulation() {
        return 8;
    }

    @Override
    Position getNewPosition() {
        return null;
    }

    @Override
    public String toString() {
        return "Boa, координаты высота: " + this.getCurrentPosition().getHeight()
                + " ширина " + this.getCurrentPosition().getLength();
    }
}
