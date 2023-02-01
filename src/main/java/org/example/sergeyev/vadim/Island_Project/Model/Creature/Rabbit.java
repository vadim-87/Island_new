package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Rabbit extends PlantEeating {
    public Rabbit(Cell cell) {
        super(cell);
        this.setWeight(2);
        this.setSpeed(2);

    }

    @Override
    protected Position getNewPosition() {
        return null;
    }
}
