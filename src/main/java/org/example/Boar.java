package org.example;

public class Boar extends PlantEeating{
    public Boar(Cell cell) {
        super(cell);
        this.setWeight(400);
        this.setSpeed(2);

    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
