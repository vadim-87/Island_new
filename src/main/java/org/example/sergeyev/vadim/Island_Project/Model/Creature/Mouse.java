package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Mouse extends PlantEeating {
    public Mouse(Cell cell) {
        super(cell);
        this.setWeight(0.05);
        this.setSpeed(1);


    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
