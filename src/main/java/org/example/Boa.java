package org.example;

import org.example.Animal;
import org.example.Cell;
import org.example.Position;

public class Boa extends Animal {
    public Boa(Cell cell) {
        super(cell);
    }



    @Override
    Position getNewPosition() {
        return null;
    }


    @Override
    public String toString() {
        return "🐍 x=" + this.getCurrentPosition().getHeight()
                + " y=" + this.getCurrentPosition().getLength();
    }

    @Override
    public void run() {
       while (health > 0){
           try {
               Thread.sleep((long) Parameters.HUNGER);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           health--;
       }
        System.out.println(health);
    }
}