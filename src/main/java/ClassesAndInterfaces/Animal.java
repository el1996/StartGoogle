package ClassesAndInterfaces;

public interface Animal {
    void move();
    AbstractAnimal mate(AbstractAnimal partner);

    void setGender(AbstractAnimal.Gender gender);

    AbstractAnimal.Gender getGender();

    int getId();

    void setId(int id);

    int getWeight();

    void setWeight(int weight);
}
