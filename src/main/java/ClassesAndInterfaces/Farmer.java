package ClassesAndInterfaces;

public class Farmer {

    private Farm farm;

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    void createFarm() {
        farm = new Farm();
    }

    void makeAnimalMove(AbstractAnimal animal){
        animal.move();
    }

    AbstractAnimal requestAnimal(AbstractAnimal animal){
        return farm.giveAnimalToFarmer(animal);
    }
}
