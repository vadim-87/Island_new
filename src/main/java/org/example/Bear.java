package org.example;


public class Bear extends Predator{
    public Bear(Cell cell) {
        super(cell);
        this.setWeight(500);

    }

    @Override
    public Position getNewPosition() {
        return this.getCurrentPosition();
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength() + " health=" + this.getHealth();
    }
}
