package org.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

abstract class Animal implements Move {
    private Cell cell;
    private AnimalType animalType;
    private double weight;
    private volatile double health = 100;
    private boolean sex;
    private boolean isAlive = true;

    public Animal(Cell cell) {
        this.cell = cell;
        cell.addAnimalsToCurrentCell(this);
        this.setSex(ThreadLocalRandom.current().nextBoolean());
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

    public boolean tryingToEat(Animal prey, int chance, List<Animal> listAllAnimals) {
            if (!((this.getHealth() + prey.weight * Parameters.INDEX_OF_ATE_UP) > 100)) {//настолько ли сыт, чтоб сожрать жертву
            int ran = ThreadLocalRandom.current().nextInt(0, 100);
            boolean eatOrNo = (chance > ran);
            if (eatOrNo) {
                Eatable eatingAnimal = (Eatable) this;
                Edible foodstuff = (Edible) prey;
                eatingAnimal.eat(prey.getWeight());
                foodstuff.die(listAllAnimals);
                return true;
            }
        }
        return false;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public synchronized double getHealth() {
        return health;
    }

    public synchronized void setHealth(double health) {
        this.health = health;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
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

    protected abstract Position getNewPosition();
}
