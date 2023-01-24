package org.example;



public class Boa extends Animal {
    public Boa(Cell cell) {
        super(cell);
        this.setWeight(15);

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