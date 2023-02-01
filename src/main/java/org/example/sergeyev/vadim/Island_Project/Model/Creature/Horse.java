package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

import java.util.List;

public class Horse extends PlantEeating {
    public Horse(Cell cell) {
        super(cell);
        this.setWeight(400);
        this.setSpeed(4);

    }

    @Override
    public Position getNewPosition() {
        return this.getCurrentPosition();
    }


    @Override
    public void die(List<Animal> listAllAnimals) {
    }
}
