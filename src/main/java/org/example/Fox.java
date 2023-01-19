package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Island;
import org.example.Position;

import java.util.Random;

public class Fox extends Animal {

    public Fox(Cell cell) {
        super(cell);
    }


    @Override
    Position getNewPosition() {
        Position p = getCurrentPosition();
        int currentLength = p.getLength();
        int currentHeight = p.getHeight();
        int newL = 0;
        int newHh = 0;
        Random r = new Random();
        boolean  rr = r.nextBoolean();
        if(rr){
            if(Island.length == currentLength) {
                newL = currentLength - 1;
            } else {
                newL = currentLength + 1;
            }
        } else {
            if(Island.height == currentHeight) {
                newHh = currentHeight - 1;
            } else {
                newHh = currentHeight + 1;
            }
        }

        Position newPosition = new Position(newL,newHh);
        return newPosition;
    }

    @Override
    public String toString() {
        return "🦊 x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength();
    }
}