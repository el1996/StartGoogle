package ClassesAndInterfaces;

public class WoodenStructureAdapter implements Animal {

    WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    public WoodenStructures getWoodenStructures() {
        return woodenStructures;
    }

    public void setWoodenStructures(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    @Override
    public void move() {
        woodenStructures.roll();
    }

    @Override
    public Animal mate(Animal partner) {

        return new WoodenStructureAdapter(woodenStructures.replicate());
    }
}
