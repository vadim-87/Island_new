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
        return "🐺 x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength();
    }


    @Override
    Position getNewPosition() {
        return null;
    }

}