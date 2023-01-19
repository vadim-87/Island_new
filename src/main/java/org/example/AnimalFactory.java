package org.example;

public class AnimalFactory {
    public Animal createAnimal (AnimalType animal, Cell cell){
        return switch (animal) {
            case BOA -> new Boa(cell);
            case FOX -> new Fox(cell);
            case EAGLE -> new Eagle(cell);
            case WOLF -> new Wolf(cell);
            default -> throw new IllegalArgumentException("Wrong doughnut type:" + animal);
        };
    }
}
/**
 * HORSE,
 *     DEER,
 *     RABBIT,
 *     MOUSE,
 *     GOAT,
 *     SHEEP,
 *     BOAR,
 *     BULL,
 *     DUCK,
 *     CATERPILLAR,
 *     WOLF,
 *     BOA,
 *     FOX,
 *     BEAR,
 *     EAGLE
 */
