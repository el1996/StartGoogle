package LambdasAndStreams;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class LambdasAndStreams {

    public static void main(String []args){

        Stock stock = new Stock();

        stock.generateItemAndAddToList("ddf",9.5, LocalDate.now().plusYears(1), Item.ProductType.CLOSET);
        stock.generateItemAndAddToList("xs",2.8, LocalDate.now().minusYears(1), Item.ProductType.CHAIR);
        stock.generateItemAndAddToList("a",4.5, LocalDate.now(), Item.ProductType.CHAIR);

        System.out.println("Stock items: ");
        stock.printDates();

        System.out.println("\nExpired items: ");
        List<Item> y = stock.getExpiredItems();
        for (Item item: y) {
            System.out.println(item.getExpirationDate());
        }

        System.out.println("\nClosest expiry date item: ");
        Item t = stock.getClosestExpiryDateItem();
        if (t != null) {
            System.out.println(t.getExpirationDate());
        }

        System.out.println("\nAlphabetically sorted items: ");
        List<Item> m = stock.getAlphabeticallySortedItems();
        for (Item item: m) {
            System.out.println(item.getName());
        }

        System.out.println("\nItem by name: ");
        Item w = stock.getItemByName("xs");
        if (w != null) {
            System.out.println(w.getName());
        }

        System.out.println("\nNames of items above specific weight: ");
        List<String> b = stock.getListNamesAboveWeight(3.0);
        for (String s: b) {
            System.out.println(s);
        }

        System.out.println("\nMap of items: ");
        Map<Item.ProductType, Integer> myMap = stock.getItemsMap();
        for (Map.Entry<Item.ProductType, Integer> mi: myMap.entrySet()) {
            System.out.println(mi.getKey() + " " + mi.getValue());
        }
    }

}
