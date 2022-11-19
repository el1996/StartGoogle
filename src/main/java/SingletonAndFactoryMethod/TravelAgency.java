package SingletonAndFactoryMethod;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static SingletonAndFactoryMethod.VehicleFactory.VehicleType.*;
import SingletonAndFactoryMethod.VehicleFactory.VehicleType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TravelAgency {
    private static Logger logger = LogManager.getLogger(TravelAgency.class.getName());


    private static AtomicInteger count = new AtomicInteger();

    static List<Passenger> passengers = new ArrayList<>();
    static List<Vehicle> vehicles = new ArrayList<>();

    static Map<Integer,Integer> vehiclesAndPassengers = new HashMap<>();

      static void assignPassengersToVehicles(Passenger passenger){
          logger.info("create bus");
          List<Integer> borrowedVehiclesId = new ArrayList<>(vehiclesAndPassengers.keySet());
          List<Vehicle> unBorrowedVehicles = vehicles.stream().filter(v -> !borrowedVehiclesId.contains(v.getId())).collect(Collectors.toList());

          Vehicle vehicle = null;

          for (Vehicle v: unBorrowedVehicles) {
              if (v.getType() == passenger.getFavoriteVehicle()) {
                  vehicle = v;
                  break;
              }
          }

          if (vehicle == null) {
              vehicle = unBorrowedVehicles.get(ThreadLocalRandom.current().nextInt(unBorrowedVehicles.size()));
          }

          vehiclesAndPassengers.put(vehicle.getId(), passenger.getId());
          vehicle.transport(passenger);
      }

    public static void main(String[] args) {

        VehicleFactory storeFactory = VehicleFactory.getInstance();
        logger.info("Created Vehicle Factory");

        logger.debug("Add vehicles - BUS");
        for (int i = 0; i < 4; i++) {
            vehicles.add(VehicleFactory.createVehicle(VehicleFactory.VehicleType.BUS));
        }

        logger.debug("Add vehicles - TAXI");
        for (int i = 0; i < 8; i++) {
            logger.info("create taxi");
            vehicles.add(VehicleFactory.createVehicle(VehicleFactory.VehicleType.TAXI));
        }

        logger.debug("Add vehicles - BOAT");
        for (int i = 0; i < 3; i++) {
            vehicles.add(VehicleFactory.createVehicle(BOAT));
        }

        logger.debug("Add vehicles - PLANE");
        vehicles.add(VehicleFactory.createVehicle(PLANE));

        try{
            vehicles.add(VehicleFactory.createVehicle(GANDOLA));
        } catch (Exception exception) {}

        Passenger p1 = new Passenger("Elchanan",count.getAndIncrement() ,VehicleType.PLANE );
        Passenger p2 = new Passenger("Dani",count.getAndIncrement() ,VehicleType.TAXI );
        Passenger p3 = new Passenger("Yael", count.getAndIncrement(),VehicleType.BOAT );
        Passenger p4 = new Passenger("Sarah", count.getAndIncrement(),VehicleType.BUS );
        Passenger p5 = new Passenger("Dan", count.getAndIncrement(), PLANE );

        passengers.add(p1);
        passengers.add(p2);
        passengers.add(p3);
        passengers.add(p4);
        passengers.add(p5);

        assignPassengersToVehicles(p1);
        assignPassengersToVehicles(p2);
        assignPassengersToVehicles(p3);
        assignPassengersToVehicles(p4);
        assignPassengersToVehicles(p5);

    }


}
