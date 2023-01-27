package org.example;


public class Bear extends Predator{
    public Bear(Cell cell) {
        super(cell);
        this.setWeight(500);
        this.setSpeed(2);

    }

    @Override
    public Position getNewPosition() {
        return this.getCurrentPosition();
    }


}
