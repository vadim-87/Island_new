package org.example;

public class Caterpillar extends PlantEeating{
    public Caterpillar(Cell cell) {
        super(cell);
        this.setWeight(00.1);
        this.setSpeed(0);

    }

    @Override
    public Position getNewPosition() {
        return null;
    }
}
