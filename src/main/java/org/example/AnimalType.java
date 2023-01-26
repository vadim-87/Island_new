package org.example;

import java.util.List;

public enum AnimalType {

    WOLF(0, 30),
    BOA(1, 30),
    FOX(2, 30),
    BEAR(3, 5),
    EAGLE(4, 20),
    HORSE(5, 20),
    DEER(6, 20),
    RABBIT(7, 150),
    MOUSE(8, 500),
    GOAT(9, 140),
    SHEEP(10, 140),
    BOAR(11, 50),
    BULL(12, 10),
    DUCK(13, 200),
    CATERPILLAR(14, 1000),
    PLANT(15, 200);

    private int index;
    private int maxCountInCell;
    List<AnimalType> animalTypeList;


    public int getIndex() {
        return index;
    }

    public int getMaxCountInCell() {
        return maxCountInCell;
    }

    AnimalType(int index, int maxCountInCell) {
        this.index = index;
        this.maxCountInCell = maxCountInCell;

    }
}

