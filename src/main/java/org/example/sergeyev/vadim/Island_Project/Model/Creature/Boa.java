package org.example.sergeyev.vadim.Island_Project.Model.Creature;


import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

public class Boa extends Predator implements Edible {
    public Boa(Cell cell) {
        super(cell);
        this.setWeight(15.0);
        this.setSpeed(1);


    }



    @Override
    public Position getNewPosition() {
        return null;
    }


}