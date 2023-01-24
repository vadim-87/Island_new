package org.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

abstract class Animal implements Runnable {

    private Cell cell;
    public boolean isAlive = true;
    private AnimalType animalType;
    private int weight;
    private volatile int health = 100;
    private boolean sex;

    public Animal(Cell cell) {
        this.cell = cell;
        cell.addAnimalsToCurrentCell(this);
        this.setSex(ThreadLocalRandom.current().nextBoolean());

    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType type) {
        this.animalType = type;
    }


    private void setCell(Cell newCell) {
        cell = newCell;
    }

    public Cell getCell() {
        return cell;
    }


    public Position getCurrentPosition() {
        return cell.getPosition();
    }

    abstract Position getNewPosition();


    public int actionBetweenAnimals(Animal animal) {
        return Parameters.animalCompatibilityMatrix[this.getAnimalType().getIndex()][animal.getAnimalType().getIndex()];
    }


    public boolean tryingToEat(Animal animal_2, int chance, List<Animal> listAllAnimals) {
        int ran = ThreadLocalRandom.current().nextInt(0, 100);
        boolean eatOrNo = (chance > ran);
        if (eatOrNo) {
            cell.removeFromCell(animal_2);
            listAllAnimals.remove(animal_2);
            animal_2.isAlive = false;
            return true;
        }
        return false;
    }


    public boolean tryingToReproductive(Animal animal_2, List<Animal> listAllAnimals) {

        if (this.getSex() != animal_2.getSex()) {
            int ran = ThreadLocalRandom.current().nextInt(0, 100);
            boolean happily = (ran > (100 - Parameters.PROBABILITY_OF_REPRODUCTION));
            if (happily) {
                AnimalFactory animalFactory = new AnimalFactory();
                Animal newAnimal = animalFactory.createAnimal(this.getAnimalType(), this.getCell());
                newAnimal.setAnimalType(this.getAnimalType());
                newAnimal.setSex(ThreadLocalRandom.current().nextBoolean());
                listAllAnimals.add(newAnimal);
                return true;
            }
        }
        return false;
    }


    @Override
    public void run() {
        int health = this.getHealth();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            health = health - 10;
            this.setHealth(health);
        }

    }
}