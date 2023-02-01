package org.example;


public class Bear extends Predator{
    @Override
    protected Position getNewPosition() {
        return null;
    }

    public Bear(Cell cell) {
        super(cell);
        this.setWeight(500);
        this.setSpeed(2);

    }



}
