package org.example.sergeyev.vadim.Island_Project.Model.Creature;


import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Bear extends Predator {
    @Override
    protected Position getNewPosition() {
        return null;
    }

    public Bear(Cell cell) {
        super(cell);
        this.setWeight(500);
        this.setSpeed(2);

    }



}
