package SingletonAndFactoryMethod;

import SingletonAndFactoryMethod.VehicleFactory.VehicleType;

public class Passenger {
    private String name;

    private int id;
    private VehicleType favoriteVehicle;

   // enum VehicleType{PLANE,TAXI,BUS,BOAT}


    public Passenger(String name, int id, VehicleType favoriteVehicle) {
        this.name = name;
        this.id = id;
        this.favoriteVehicle = favoriteVehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getFavoriteVehicle() {
        return favoriteVehicle;
    }

    public void setFavoriteVehicle(VehicleType favoriteVehicle) {
        this.favoriteVehicle = favoriteVehicle;
    }

}
