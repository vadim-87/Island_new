package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Position;

public class Boa extends Animal {
    public Boa(Cell cell) {
        super(cell);
    }


    @Override
    Position getNewPosition() {
        return null;
    }


    @Override
    public String toString() {
        return "Boa x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength();
    }
}