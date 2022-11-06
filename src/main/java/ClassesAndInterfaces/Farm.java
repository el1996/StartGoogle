package ClassesAndInterfaces;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Farm {

    private ArrayList<AbstractAnimal> animalList = new ArrayList<>();

    public static AtomicLong idCounter = new AtomicLong();

    public ArrayList<AbstractAnimal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<AbstractAnimal> animalList) {
        this.animalList = animalList;
    }

    void acquire(String type){

        switch (type){
            case "Dog" :
                animalList.add(Dog.createRandom()); break;
            case "Horse" :
                animalList.add(Horse.createRandom()); break;
            case "Lion" :
                animalList.add(Lion.createRandom()); break;
        }
    }

    void doMate(AbstractAnimal animal1, AbstractAnimal animal2) {

        AbstractAnimal newAnimal = (AbstractAnimal) animal1.mate(animal2);
        if (newAnimal != null) {
            animalList.add(newAnimal);
        }
    }

    AbstractAnimal giveAnimalToOutsideUsers(AbstractAnimal animal) {

        animalList.remove(animal);
        return animal;
    }

    AbstractAnimal giveAnimalToFarmer(AbstractAnimal animal) {

        return animal;
    }

    public static int createID()
    {
        return (int) idCounter.getAndIncrement();
    }
}
