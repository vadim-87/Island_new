package org.example;

import java.util.Arrays;
import java.util.List;

public abstract class Parameters {
    public static final int ISLAND_HEIGHT = 5;
    public static final int ISLAND_LENGTH = 10;
    public static final List<Class<? extends Animal>> LIST_OF_ANIMAL_TYPES = Arrays.asList(Fox.class, Eagle.class, Wolf.class, Boa.class);
    public static double  HUNGER = 1000;


}