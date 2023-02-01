package org.example.sergeyev.vadim.Island_Project.Engine;

import lombok.Getter;

import java.util.List;
@Getter
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
    CATERPILLAR(14, 100),
    PLANT(15, 200);

    private int index;
    private int maxCountInCell;
    List<AnimalType> animalTypeList;


    AnimalType(int index, int maxCountInCell) {
        this.index = index;
        this.maxCountInCell = maxCountInCell;

    }
}

