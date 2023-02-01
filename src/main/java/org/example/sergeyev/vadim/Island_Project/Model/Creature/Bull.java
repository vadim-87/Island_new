package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Bull extends PlantEeating {
    public Bull(Cell cell) {
        super(cell);
        this.setWeight(700);
        this.setSpeed(3);

    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
