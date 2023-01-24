package org.example;

public enum AnimalType {

    WOLF(0),
    BOA(1),
    FOX(2),
    BEAR(3),
    EAGLE(4),
    HORSE(5),
    DEER(6),
    RABBIT(7),
    MOUSE(8),
    GOAT(9),
    SHEEP(100),
    BOAR(11),
    BULL(12),
    DUCK(13),
    CATERPILLAR(14),
    HERB(15);

    public int getIndex() {
        return index;
    }

    private int index;

    AnimalType(int index) {
        this.index = index;
    }
}

