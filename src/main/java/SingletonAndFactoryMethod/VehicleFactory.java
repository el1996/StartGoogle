package SingletonAndFactoryMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class VehicleFactory {

    private static Logger logger = LogManager.getLogger(VehicleFactory.class.getName());
    private static VehicleFactory single_instance = null;

    private static AtomicInteger count = new AtomicInteger();

    private VehicleFactory(){}

    public static VehicleFactory getInstance()
    {
        if (single_instance == null)
            single_instance = new VehicleFactory();

        return single_instance;
    }


        enum VehicleType{PLANE,TAXI,BUS,BOAT,GANDOLA}
        public static Vehicle createVehicle(VehicleType type){
            switch (type){
                case PLANE:
                    return new Plane(count.getAndIncrement());
                case TAXI:
                    return new Taxi(count.getAndIncrement());
                case BUS:
                    return new Bus(count.getAndIncrement());
                case BOAT:
                    return new Boat(count.getAndIncrement());
                default:
                    logger.error("Vehicle type not supported: " + type);
                    throw new IllegalArgumentException(String.format("Vehicle type not supported: %s", type));
            }
        }
}
