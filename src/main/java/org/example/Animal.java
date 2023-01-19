package org.example;

abstract class Animal {

    private Cell cell;

    public Animal(Cell cell) {

        this.cell = cell;
        cell.addAnimalsToCurrentCell(this);

    }


    private void setCell(Cell newCell){
        cell = newCell;
    }



    public Position getCurrentPosition(){
        return cell.getPosition();
    }

    abstract Position getNewPosition();

    void move(Cell newCell) {
        cell.removeFromCurrentCell(this);
        newCell.addAnimalsToCurrentCell(this);
        setCell(newCell);
    }

}