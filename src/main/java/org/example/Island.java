package org.example;

import java.util.*;

import static org.example.AnimalTypes.*;
import static org.example.Parameters.*;

public class Island {
    public static int height = ISLAND_HEIGHT;
    public static int length = ISLAND_LENGTH;
    private Map<Position, Cell> islandMap; //мапа, хранит позицию (х, у) и объект самой ячейки согласно каждой позиции (Cell)
    private final Map<AnimalTypes, Integer> numberAnimalPopulationOnCell = Map.of(BOA, 30, WOLF, 30, EAGLE, 20, FOX, 30);
    private List<Animal> allAnimalsOnIsland;//список всех животных на острове
    //private final List<AnimalTypes> animalTypesList = Arrays.asList(HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BULL, DUCK, CATERPILLAR, WOLF, BOA, FOX, BEAR, EAGLE);
    private final List<AnimalTypes> animalTypesList = Arrays.asList(WOLF, BOA, FOX, EAGLE);

    public Island() {
        init();
    }

    //метод инициализирует карту острова
    private void init() {
        islandMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                //создал позицию с координатами, создал объект ячейки с этими координатами
                Position position = new Position(i, j);
                Cell cell = new Cell(position);
                islandMap.put(position, cell);

                //вызываю метод для добавления животных в данную ячейку + добавление в лист со всеми животными
                addAllAnimalsToIsland();

            }

        }
    }

    //создал лист животных с одинаковыми стартовыми позициями
    public void addAllAnimalsToIsland() {
        allAnimalsOnIsland = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        for (Map.Entry<Position, Cell> entry : islandMap.entrySet()) {
            Cell currentCell = entry.getValue();
            Position currentPosition = entry.getKey();
            for (AnimalTypes type : animalTypesList) {
                int numberOfPopulation = numberAnimalPopulationOnCell.get(type);
                for (int i = 0; i < numberOfPopulation; i++) {
                    Animal newAnimal = animalFactory.createAnimal(type, currentCell);
                    allAnimalsOnIsland.add(newAnimal);
                }
            }

        }

    }


    public void start() {

        for (Animal animal : allAnimalsOnIsland) {
        }

//        }
//        for (Animal animal:allAnimalsOnIsland) {
//            System.out.println(animal);
//        }
//
//        while (allAnimalsOnIsland.size() > 0) {//TODO
//            for (Animal it : allAnimalsOnIsland) {
//                Cell newCell = islandMap.get(it.getNewPosition());
//                it.move(newCell);
//            }
//
//            for (Cell cell : islandMap.values()) {
//                cell.processCell();
//
//            }
    }

    void printAllCells() {
//        islandMap.forEach((key, value) -> {
//            System.out.println(value.toString());
//        });
        int fox = 0;
        int boa = 0;
        int eagle = 0;
        int wolf = 0;
        for (Animal a : allAnimalsOnIsland) {
            if (a instanceof Fox) fox++;
            if (a instanceof Boa) boa++;
            if (a instanceof Eagle) eagle++;
            if (a instanceof Wolf) wolf++;
        }
        System.out.printf("Fox %s, Boa %s, Eagle %s, Wolf %s", fox, boa, eagle, wolf);
    }

}