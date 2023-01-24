package org.example;

public class Wolf extends Predator {

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