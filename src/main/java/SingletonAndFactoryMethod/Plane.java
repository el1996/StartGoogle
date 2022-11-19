package SingletonAndFactoryMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Plane implements Vehicle{

    private static Logger logger = LogManager.getLogger(Plane.class.getName());
    private int planeId;

    public Plane(int planeId) {
        this.planeId = planeId;
        logger.info("Created Plane: " + planeId);
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
