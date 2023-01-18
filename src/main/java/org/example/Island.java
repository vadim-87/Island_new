package org.example;

import java.util.*;

import static org.example.AnimalTypes.*;
import static org.example.Parameters.*;

public class Island {
    public static int height = ISLAND_HEIGHT;
    public static int length = ISLAND_LENGTH;


    private Map<Position, Cell> islandMap; //мапа, хранит позицию (х, у) и объект самой ячейки согласно каждой позиции (Cell)
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
                //добавил в карту острова пару "позиция + ячейка"
                islandMap.put(position, cell);
                //добавил в эту ячейку новых животных
               // addAnimasToCell(cell);

            }

        }
    }

//    public void addAnimasToCell(Cell cell) {
//        AnimalFactory animalFactory = new AnimalFactory();
//        for (Map.Entry<Position, Cell> pair : islandMap.entrySet()) {
//            Position p = pair.getKey();
//            Cell c = islandMap.get(p);
//        }
//    }

    public void start() {
        allAnimalsOnIsland = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        //бегу по карте, заглядываю в каждую ячейку
        for (Map.Entry<Position, Cell> pair : islandMap.entrySet()) {
            Position positionTemp = pair.getKey();
            Cell cellTemp = islandMap.get(positionTemp);
            for (AnimalTypes type : animalTypesList) {
                Animal factoryAnimal = animalFactory.createAnimal(type, cellTemp);
                for (int i = 0; i < factoryAnimal.getMaxNumberOfPopulation(); i++) {
                    Animal animal = animalFactory.createAnimal(type, cellTemp);
                    allAnimalsOnIsland.add(animal);
                }
            }

        }
        for (Animal animal:allAnimalsOnIsland) {
            System.out.println(animal);
        }

        while (allAnimalsOnIsland.size() > 0) {//TODO
            for (Animal it : allAnimalsOnIsland) {
                Cell newCell = islandMap.get(it.getNewPosition());
                it.move(newCell);
            }

            for (Cell cell : islandMap.values()) {
                cell.processCell();

            }
        }
    }
}
