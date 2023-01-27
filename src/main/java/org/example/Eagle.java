package org.example;



public class Eagle extends Predator {


//    @Override
//    public String toString() {
//        return "🦅 x=" + this.getCurrentPosition().getHeight()
//                + " y=" + this.getCurrentPosition().getLength() + " health=" + this.getHealth();
//    }

    public Eagle(Cell cell) {
        super(cell);
        this.setWeight(6);
        this.setSpeed(3);


    }


    @Override
    public Position getNewPosition() {
        return null;
    }

}