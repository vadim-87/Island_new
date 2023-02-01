package org.example.sergeyev.vadim.Island_Project.Model.Creature;

import lombok.Getter;
import lombok.Setter;
import org.example.sergeyev.vadim.Island_Project.Engine.AnimalFactory;
import org.example.sergeyev.vadim.Island_Project.Engine.AnimalType;
import org.example.sergeyev.vadim.Island_Project.Engine.Parameters;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Cell;
import org.example.sergeyev.vadim.Island_Project.Model.Island.Position;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Animal {
    private Cell cell;
    private AnimalType animalType;
    private double weight;
    private volatile double health = 100;
    private boolean sex;
    private boolean isAlive;
    private int speed;

    protected abstract Position getNewPosition();


    public Animal(Cell cell) {
        this.cell = cell;
        cell.addAnimalsToCurrentCell(this);
        this.setSex(ThreadLocalRandom.current().nextBoolean());
        this.isAlive = true;
    }

    public boolean tryingToReproductive(Animal animal_2, List<Animal> allAnimalsOnIsland) {

        if (this.isSex() != animal_2.isSex() && (canAnimalGetInThisCell(animal_2))) {
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

    public boolean canAnimalGetInThisCell(Animal animal_2) {
        List<Animal> animalsInCurrentCell = this.cell.getAnimalsInCurrentCell();
        int countAnimalsInCurrentCell = 0;
        for (Animal a : animalsInCurrentCell) {
            if (a.getAnimalType() == this.getAnimalType()) {
                countAnimalsInCurrentCell++;
            }
        }
        return animal_2.animalType.getMaxCountInCell() > countAnimalsInCurrentCell;
    }

    public boolean tryingToEat(Animal prey, int chance, List<Animal> allAnimalsOnIsland) {
       // if (!((this.getHealth() + prey.weight * Parameters.INDEX_OF_ATE_UP) > 100)) {//настолько ли сыт, чтоб сожрать жертву
        int ran = ThreadLocalRandom.current().nextInt(0, 100);
        boolean eatOrNo = (chance > ran);
        if (eatOrNo) {
            Eatable eatingAnimal = (Eatable) this;
            Edible foodstuff = (Edible) prey;
            eatingAnimal.eat(prey.getWeight());
            foodstuff.die(allAnimalsOnIsland);
            return true;
        }
       //  }
        return false;
    }

    public Position getCurrentPosition() {
        return cell.getPosition();
    }

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
