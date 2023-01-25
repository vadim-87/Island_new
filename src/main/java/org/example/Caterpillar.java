package org.example;

public class Caterpillar extends PlantEeating{
    public Caterpillar(Cell cell) {
        super(cell);
        this.setWeight(00.1);
    }

    @Override
    Position getNewPosition() {
        return null;
    }
}
