package SingletonAndFactoryMethod;

public class Taxi implements Vehicle{
    private int taxiId;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public int getId() {
        return taxiId;
    }

    @Override
    public VehicleFactory.VehicleType getType() {
        return VehicleFactory.VehicleType.TAXI;
    }

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " : on taxi " + taxiId);
    }
}
