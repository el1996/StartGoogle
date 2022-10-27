package ClassesAndInterfaces;

import java.util.Random;

import static ClassesAndInterfaces.Farm.createID;

public abstract class AbstractAnimal implements Animal {

    public enum Gender {
        MALE,
        FEMALE;
    }
    protected int id;
    protected Gender gender;
    protected int weight;

    private static Random random = new Random();

    public AbstractAnimal(int id, Gender gender, int weight) {
        this.id = id;
        this.gender = gender;
        this.weight = weight;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static Gender generateRandomGender() {

        int x = random.nextInt(2);
        if (x==0) {
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    public static int generateRandomWeight() {

        return random.nextInt(100);
    }
}
