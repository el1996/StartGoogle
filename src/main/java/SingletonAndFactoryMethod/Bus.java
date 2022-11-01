package SingletonAndFactoryMethod;

public class Bus implements Vehicle{
    public Bus(int busId) {
        this.busId = busId;
    }

    private int busId;

    @Override
    public int getId() {
        return busId;
    }

    @Override
    public VehicleFactory.VehicleType getType() {
        return VehicleFactory.VehicleType.BUS;
    }

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " : on bus " + busId);
    }
}
