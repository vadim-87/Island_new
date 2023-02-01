package org.example.sergeyev.vadim.Island_Project.Engine;

import org.example.sergeyev.vadim.Island_Project.Engine.AnimalType;

import java.util.Arrays;
import java.util.List;

public final class Parameters {
    public Parameters() {
        throw new InstantiationError("You can not create an object of this type!");
    }

    public static final List<AnimalType> ANIMAL_TYPE_LIST = Arrays.asList(AnimalType.BOA, AnimalType.FOX, AnimalType.EAGLE, AnimalType.WOLF, AnimalType.BEAR, AnimalType.HORSE,
            AnimalType.CATERPILLAR, AnimalType.DEER, AnimalType.RABBIT, AnimalType.MOUSE, AnimalType.GOAT, AnimalType.SHEEP, AnimalType.BOAR, AnimalType.BULL, AnimalType.DUCK);
    public static final String[] ANIMAL_ICONS = {"🐺, 🐍, 🦊,🐻,🦅,🐎,DEER, 🐇,🐁,🐃, 🐻, 🐎, 🦌, 🐗, 🐑, 🐐, 🐺, 🐍, 🦊, 🦅, 🐇, 🦆, 🐁, 🐛"};
    public static final double INDEX_OF_ATE_UP = 0.2;
    public static final double STARVATION_HEALTH_IN_SEC = 10;
    public static final int ISLAND_HEIGHT = 3;
    public static final int ISLAND_LENGTH = 3;
    public static final int PROBABILITY_OF_REPRODUCTION = 70;
    public static final int[][] ANIMAL_COMPATIBILITY_MATRIX = {
            {1, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 1, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 1, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 1, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 1, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 100}
    };


}