package Methods;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Coupon> coupons = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public User(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//
//        return coupons.stream().map(Coupon::toString).toString();
//    }
}
