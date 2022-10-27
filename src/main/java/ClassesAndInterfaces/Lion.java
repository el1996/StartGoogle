package ClassesAndInterfaces;

import static ClassesAndInterfaces.Farm.createID;

public class Lion extends AbstractAnimal{

    public Lion(int id, Gender gender, int weight) {
        super(id, gender, weight);
    }

    @Override
    public void move() {
        System.out.println("The dog is moving\n");
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {

        if (partner.getGender() != this.getGender()) {
            return new Lion(createID(), generateRandomGender(), generateRandomWeight());
        }

        return null;
    }

    static Lion createRandom() {
        return new Lion(createID(), generateRandomGender(), generateRandomWeight());
    }
}
