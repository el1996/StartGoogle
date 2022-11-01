package SingletonAndFactoryMethod;
import SingletonAndFactoryMethod.VehicleFactory.VehicleType;

public interface Vehicle {

   int getId();
   VehicleType getType();
   void transport(Passenger passenger);



}
