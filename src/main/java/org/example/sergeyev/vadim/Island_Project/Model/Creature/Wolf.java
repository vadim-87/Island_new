package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Wolf extends Predator {

    public Wolf(Cell cell) {
        super(cell);
        this.setWeight(50);
        this.setSpeed(3);



    }



    @Override
    public Position getNewPosition() {
        return null;
    }

}