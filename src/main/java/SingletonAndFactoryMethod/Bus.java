package SingletonAndFactoryMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bus implements Vehicle{

    private static Logger logger = LogManager.getLogger(Plane.class.getName());

    public Bus(int busId) {
        this.busId = busId;
        logger.info("Created Bus: " + busId);
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
