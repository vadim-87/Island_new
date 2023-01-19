package org.example;

abstract class Animal extends Thread {
    private Cell cell;
    private AnimalType animalType;

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType type) {
        this.animalType = type;
    }


    volatile int health = 100;

    public Animal(Cell cell) {

        this.cell = cell;
        cell.addAnimalsToCurrentCell(this);

    }


    private void setCell(Cell newCell) {
        cell = newCell;
    }


    public Position getCurrentPosition() {
        return cell.getPosition();
    }

    abstract Position getNewPosition();

    void move(Cell newCell) {
        cell.removeFromCurrentCell(this);
        newCell.addAnimalsToCurrentCell(this);
        setCell(newCell);
    }

    public int interactions(Animal type) {
        int[][] matrixOfAnimalInterplay = {
                {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0},
                {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0},
                {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40},
                {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0},
                {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        //
        return matrixOfAnimalInterplay[this.getAnimalType().ordinal()][type.getAnimalType().ordinal()];
    }

}