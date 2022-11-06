package ClassesAndInterfaces;

public class WoodenHorse implements WoodenStructures {

    @Override
    public void roll() {
        System.out.println("The wooden horse are rolling");
    }

    @Override
    public WoodenStructures replicate() {
        return new WoodenHorse();
    }
}
