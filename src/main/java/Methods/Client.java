package Methods;

import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {

        Store store = new Store();

        LocalDate localDate = LocalDate.of(2023, 8, 1);  // 01.08.23

        Coupon coupon1 = new Coupon(1,localDate,6);  // 01.08.23
        Coupon coupon2 = new Coupon(2,localDate.minusMonths(6),66);  // 01.02.23
        Coupon coupon3 = new Coupon(3,localDate.plusYears(1), 666);  // 01.08.24
        Coupon coupon4 = new Coupon(4,localDate.minusMonths(3),6666);  // 01.05.23
        Coupon coupon5 = new Coupon(5,localDate.plusMonths(4),66666);  // 01.12.23
        Coupon coupon6 = new Coupon(6,localDate.plusDays(5),666666);  // 06.08.23
        Coupon coupon7 = new Coupon(7,localDate.plusYears(4),66666666);  // 01.08.27
        Coupon coupon8 = new Coupon(8,localDate.minusYears(2),666666666);  // 01.08.23
        Coupon coupon9 = new Coupon(9,localDate.plusYears(2),777777777);  // 01.08.23

        User user = new User("Dani");

        // store.assignCouponToUser(new Coupon(1,localDate,6), user);

        store.assignCouponToUser(coupon1, user);
        store.assignCouponToUser(coupon2, user);
        store.assignCouponToUser(coupon3, user);
        store.assignCouponToUser(coupon4, user);
        store.assignCouponToUser(coupon5, user);
        store.assignCouponToUser(coupon6, user);
        store.assignCouponToUser(coupon7, user);
        store.assignCouponToUser(coupon8, user);
        store.assignCouponToUser(coupon9, user);

        //System.out.println(user);

        System.out.println("All Coupons");
        for(Coupon c : user.getCoupons()){
           System.out.println(c.print());
        }

        System.out.println("\nuseCouponById - coupon expiry date not valid");
        store.useCouponById(user,8);
        for(Coupon c : user.getCoupons()){
            System.out.println(c.print());
        }

        System.out.println("\nuseCouponById - coupon expiry date is valid");
        store.useCouponById(user,4);
        for(Coupon c : user.getCoupons()){
            System.out.println(c.print());
        }

        System.out.println("\nuseCouponByClosestExpiryDate");
        store.useCouponByClosestExpiryDate(user);
        for(Coupon c : user.getCoupons()){
            System.out.println(c.print());
        }

        System.out.println("\nuseCouponByHighestValue");
        store.useCouponByHighestValue(user);
        for(Coupon c : user.getCoupons()){
            System.out.println(c.print());
        }

        System.out.println("\nuseCouponByRandomlySelected");
        store.useCouponByRandomlySelected(user);
        for(Coupon c : user.getCoupons()){
            System.out.println(c.print());
        }

    }
}
