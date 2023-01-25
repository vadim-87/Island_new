package org.example;



public class Boa extends Predator implements Edible {
    public Boa(Cell cell) {
        super(cell);
        this.setWeight(15.0);

    }



    @Override
    Position getNewPosition() {
        return null;
    }


    @Override
    public String toString() {
        return "🐍 x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength() + " health=" + this.getHealth();
    }

}