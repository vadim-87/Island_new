package org.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

abstract class Animal implements Move {
    private Cell cell;
    private AnimalType animalType;
    private double weight;
    private volatile double health = 100;
    private boolean sex;
    private boolean isAlive;
    private int speed;



    public Animal(Cell cell) {
        this.cell = cell;
        cell.addAnimalsToCurrentCell(this);
        this.setSex(ThreadLocalRandom.current().nextBoolean());
        this.isAlive = true;
    }

    public boolean tryingToReproductive(Animal animal_2, List<Animal> allAnimalsOnIsland) {

        if (this.getSex() != animal_2.getSex() && (canAnimalGetInThisCell(animal_2))) {
            int ran = ThreadLocalRandom.current().nextInt(0, 100);
            boolean happily = (ran > (100 - Parameters.PROBABILITY_OF_REPRODUCTION));
            if (happily) {
                AnimalFactory animalFactory = new AnimalFactory();
                Animal newAnimal = animalFactory.createAnimal(this.getAnimalType(), this.getCell());
                newAnimal.setAnimalType(this.getAnimalType());
                newAnimal.setSex(ThreadLocalRandom.current().nextBoolean());
                allAnimalsOnIsland.add(newAnimal);
                return true;
            }
        }
        return false;
    }

    private boolean canAnimalGetInThisCell(Animal animal_2) {
        List<Animal> animalsInCurrentCell = this.cell.getAnimalsInCurrentCell();
        int countAnimalsInCurrentCell = 0;
        for (Animal a:animalsInCurrentCell) {
            if(a.getAnimalType() == this.getAnimalType()){
                countAnimalsInCurrentCell++;
            }
        }
        return animal_2.animalType.getMaxCountInCell() > countAnimalsInCurrentCell;
    }

    public boolean tryingToEat(Animal prey, int chance, List<Animal> allAnimalsOnIsland) {
          //if (!((this.getHealth() + prey.weight * Parameters.INDEX_OF_ATE_UP) > 100)) {//настолько ли сыт, чтоб сожрать жертву
            int ran = ThreadLocalRandom.current().nextInt(0, 100);
            boolean eatOrNo = (chance > ran);
            if (eatOrNo) {
                Eatable eatingAnimal = (Eatable) this;
                Edible foodstuff = (Edible) prey;
                eatingAnimal.eat(prey.getWeight());
                foodstuff.die(allAnimalsOnIsland);
                return true;
            }
       // }
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected abstract Position getNewPosition();

    @Override
    public String toString() {
        return animalType +
                ", weight=" + weight +
                ", health=" + health +
                ", sex=" + sex +
                ", isAlive=" + isAlive +
                '}';
    }
}
