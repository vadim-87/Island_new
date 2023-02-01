package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Duck extends PlantEeating {
    public Duck(Cell cell) {
        super(cell);
        this.setWeight(1);
        this.setSpeed(4);


    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
