package ClassesAndInterfaces;

public class MainFarm {

    public static void main(String[] args) {

        Farmer farmer = new Farmer();
        farmer.createFarm();

        farmer.getFarm().acquire("Lion");
        farmer.getFarm().acquire("Dog");
        farmer.getFarm().acquire("Horse");
        farmer.getFarm().acquire("Dog");
        farmer.getFarm().acquire("Horse");

        AbstractAnimal requestedAnimal = farmer.requestAnimal(farmer.getFarm().getAnimalList().get(2));
        farmer.makeAnimalMove(requestedAnimal);

        requestedAnimal = farmer.getFarm().giveAnimalToFarmer(requestedAnimal);

        AbstractAnimal requestedAnimalToMate = farmer.requestAnimal(farmer.getFarm().getAnimalList().get(4));

        farmer.getFarm().doMate(requestedAnimal, requestedAnimalToMate);

        requestedAnimal = farmer.getFarm().giveAnimalToOutsideUsers(requestedAnimal);


    }
}
