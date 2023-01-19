package org.example;

public class ControlAnimalNumberInCell {
    public int getNumberAnimalInCell(AnimalTypes type){
        return switch (type) {
            case BOA, FOX -> 3;
            case EAGLE -> 4;
            case WOLF -> 5;
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + type);
        };
    }
}