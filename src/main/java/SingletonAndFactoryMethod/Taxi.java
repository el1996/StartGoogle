package SingletonAndFactoryMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Taxi implements Vehicle{

    private static Logger logger = LogManager.getLogger(Plane.class.getName());

    private int taxiId;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        logger.info("Created Taxi: " + taxiId);
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
