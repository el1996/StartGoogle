package SingletonAndFactoryMethod;

public class Plane implements Vehicle{

    private int planeId;

    public Plane(int planeId) {
        this.planeId = planeId;
    }

    @Override
    public int getId() {
        return planeId;
    }

    @Override
    public VehicleFactory.VehicleType getType() {
        return VehicleFactory.VehicleType.PLANE;
    }

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " : on plane " + planeId);
    }
}
