package Methods;


import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Store {

    LocalDate localDateNow = LocalDate.of(2022, 10, 25);

    void assignCouponToUser(Coupon coupon, User user){
        user.getCoupons().add(coupon);
    }

    void useCoupon(Coupon coupon, User user){
        if (isValid(coupon, user)) {
            user.getCoupons().remove(coupon);
        }
    }

    private boolean isValid(Coupon coupon, User user) {

        // if coupon is not null
        // if User has a coupon
        // and coupon's date is valid
        if (coupon != null &&
            user.getCoupons().contains(coupon) &&
            coupon.getExpiryDate().isAfter(localDateNow)) {
            return true;
        }
        return false;
    }

    void useCouponById(User user, int id) {

//        Optional<Coupon> coupon = user.getCoupons().stream().filter(c -> c.getId() == id).findAny();
//        coupon.ifPresent(value -> useCoupon(value, user));

        for (Coupon c : user.getCoupons()){
            if (c.getId() == id){
                useCoupon(c, user);
                break;
            }
        }
    }
    void useCouponByHighestValue(User user){

        int maxValue = 0;
        Coupon maxValueCoupon = null;

        for (Coupon c : user.getCoupons()) {
            if (c.getValue() > maxValue) {
                maxValue = c.getValue();
                maxValueCoupon = c;
            }
        }

        useCoupon(maxValueCoupon, user);
    }

    void useCouponByClosestExpiryDate (User user){

        ArrayList<LocalDate> localDates = new ArrayList<>();
        for (Coupon c: user.getCoupons()) {
            localDates.add(c.getExpiryDate());
        }

        LocalDate minLocalDate = LocalDate.MAX;
        for(LocalDate localDate: localDates) {
            if (localDate.isAfter(localDateNow)) {
                if (localDate.isBefore(minLocalDate)) {
                    minLocalDate = localDate;
                }
            }
        }

        Coupon removeCoupon = null;
        for (Coupon c: user.getCoupons()) {
            if (c.getExpiryDate().equals(minLocalDate)) {
                removeCoupon = c;
            }
        }

        useCoupon(removeCoupon, user);
    }
    void useCouponByRandomlySelected (User user){

        Coupon coupon = user.getCoupons().get(ThreadLocalRandom.current().nextInt(3));
        useCoupon(coupon, user);
    }


}
