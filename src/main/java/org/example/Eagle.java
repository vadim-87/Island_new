package org.example;



public class Eagle extends Animal {


    @Override
    public String toString() {
        return "🦅 x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength() + " health=" + this.getHealth();
    }

    public Eagle(Cell cell) {
        super(cell);
        this.setWeight(6);

    }


    @Override
    Position getNewPosition() {
        return null;
    }

}