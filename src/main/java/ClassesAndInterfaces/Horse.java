package ClassesAndInterfaces;

import static ClassesAndInterfaces.Farm.createID;

public class Horse extends AbstractAnimal{

    public Horse(int id, Gender gender, int weight) {
        super(id, gender, weight);
    }

    @Override
    public void move() {
        System.out.println("The dog is moving\n");
    }

    @Override
    public Animal mate(Animal partner) {
        Horse horse = (Horse) partner;
        if (horse.getGender() != this.getGender()) {
            return new Horse(createID(), generateRandomGender(), generateRandomWeight());
        }

        return null;
    }

    static Horse createRandom() {
        return new Horse(createID(), generateRandomGender(), generateRandomWeight());
    }
}
