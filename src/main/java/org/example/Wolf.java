package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Position;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Animal {

    public Wolf(Cell cell) {
        super(cell);
        this.setWeight(50);

    }



    @Override
    public String toString() {
        return "🐺 x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength() + " health=" + this.getHealth();
    }


    @Override
    Position getNewPosition() {
        return null;
    }

}