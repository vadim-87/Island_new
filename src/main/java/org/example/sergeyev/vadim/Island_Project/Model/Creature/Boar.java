package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Boar extends PlantEeating {
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
