package org.example;

abstract class Animal {

    private Cell cell;

    public Animal(Cell cell) {

        this.cell = cell;
        cell.addAnimalsToIsland(this);

    }

    private void setCell(Cell newCell){
        cell = newCell;
    }


    abstract int getMaxNumberOfPopulation();

    public Position getCurrentPosition(){
        return cell.getPosition();
    }

    abstract Position getNewPosition();

    void move(Cell newCell) {
        cell.removeFromItems(this);
        newCell.addAnimalsToIsland(this);
        setCell(newCell);
    }

}
