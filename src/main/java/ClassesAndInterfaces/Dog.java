package ClassesAndInterfaces;

import static ClassesAndInterfaces.Farm.createID;

public class Dog extends AbstractAnimal{

    public Dog(int id, Gender gender, int weight) {
        super(id, gender, weight);
    }

    @Override
    public void move() {
        System.out.println("The dog is moving\n");
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {

        if (partner.getGender() != this.gender) {
            return new Dog(createID(), generateRandomGender(), generateRandomWeight());
        }

        return null;
    }

    static Dog createRandom() {
        return new Dog(createID(), generateRandomGender(), generateRandomWeight());
    }

}
