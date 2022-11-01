package SingletonAndFactoryMethod;

public class Boat implements Vehicle{
    private int boatId;

    public Boat(int boatId) {
        this.boatId = boatId;
    }

    @Override
    public int getId() {
        return boatId;
    }

    @Override
    public VehicleFactory.VehicleType getType() {
        return VehicleFactory.VehicleType.BOAT;
    }

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " : on boat " + boatId);
    }
}
