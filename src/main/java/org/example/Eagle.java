package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Position;

public class Eagle extends Animal {
    public int getWeight() {
        return weight;
    }

    public int weight = 6;

    @Override
    public String toString() {
        return "Eagle, координаты высота: " + this.getCurrentPosition().getHeight()
                + " ширина " + this.getCurrentPosition().getLength();
    }

    public Eagle(Cell cell) {
        super(cell);
    }

    @Override
    int getMaxNumberOfPopulation() {
        return 15;
    }

    @Override
    Position getNewPosition() {
        return null;
    }

}
