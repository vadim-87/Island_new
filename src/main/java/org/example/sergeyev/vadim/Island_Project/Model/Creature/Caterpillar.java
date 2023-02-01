package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Caterpillar extends PlantEeating {
    public Caterpillar(Cell cell) {
        super(cell);
        this.setWeight(00.1);
        this.setSpeed(0);

    }

    @Override
    public Position getNewPosition() {
        return null;
    }
}
