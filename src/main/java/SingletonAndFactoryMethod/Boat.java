package SingletonAndFactoryMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Boat implements Vehicle{

    private static Logger logger = LogManager.getLogger(Plane.class.getName());
    private int boatId;

    public Boat(int boatId) {
        this.boatId = boatId;
        logger.info("Created Boat: " + boatId);
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
