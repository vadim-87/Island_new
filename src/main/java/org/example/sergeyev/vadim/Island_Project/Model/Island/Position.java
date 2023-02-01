package org.example.sergeyev.vadim.Island_Project.Model.Island;

import org.example.sergeyev.vadim.Island_Project.Engine.Parameters;
import org.example.sergeyev.vadim.Island_Project.Model.Creature.Animal;

import java.util.Objects;
import java.util.Random;

public class Position {
    private int length;
    private int height;

    public Position(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Cell getNewCell(Animal a) {
        int speed = a.getSpeed();
        int newLength = newCoordinates(length, speed, Parameters.ISLAND_LENGTH);
        int newHeight = newCoordinates(height, speed, Parameters.ISLAND_HEIGHT);

        //Position newPosition = new Position(newLength, newHeight);
        Cell newCell = new Island().getIslandMap().get(new Position(newLength, newHeight));
        if (a.canAnimalGetInThisCell(a)) {
            return newCell;

        }

        return null;

    }


    public int newCoordinates(int currentLength, int speed, int sideLength) {
        int newLength;
        if (currentLength == 0) {
            newLength = currentLength + speed;
        } else if (currentLength == sideLength) {
            newLength = currentLength - speed;
        } else {
            newLength = goToSide(currentLength, speed, sideLength);
        }
        return newLength;
    }

    private int goToSide(int currentCoordinate, int speed, int sideLength) {
        int newLength = 0;
        Random r = new Random();
        boolean b = r.nextBoolean();
        if (b) {
            for (int i = 0; (i < speed || (currentCoordinate + i == sideLength)); i++) {
                newLength = currentCoordinate + 1;
            }
        }else {
            for (int i = 0; (i < speed || (currentCoordinate - i == 0)); i++) {
                newLength = currentCoordinate - 1;
            }
        }
        return newLength;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return length == position.length && height == position.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height);
    }

}
