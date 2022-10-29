package LambdasAndStreams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import LambdasAndStreams.Item.ProductType;

public class Stock {

    List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int printDates() {

        for (Item item: itemList) {
            System.out.println("Name: " + item.getName() + " ,Weight: " + item.getWeight() + " ,Date: " + item.getExpirationDate() + " ,Type: " + item.getType());
        }

        return 0;
    }

    void generateItemAndAddToList(String name, double weight, LocalDate expirationDate, ProductType type) {

        Item item = new Item(name, weight, expirationDate, type);

        itemList.add(item);

        itemList = itemList.stream()
                .sorted(Comparator.comparing(i -> i.getExpirationDate()))
                .collect(Collectors.toList());
    }

    List<Item> getExpiredItems() {

       return itemList.stream()
               .filter(i -> i.getExpirationDate().isBefore(LocalDate.now()))
               .collect(Collectors.toList());
    }

    Item getClosestExpiryDateItem(){

        return itemList.stream()
                .filter(i -> i.getExpirationDate().isAfter(LocalDate.now().minusDays(1)))
                .min(Comparator.comparing(item -> item.getExpirationDate())).get();
    }


     List<Item> getAlphabeticallySortedItems() {

        return itemList.stream()
                .sorted(Comparator.comparing(i -> i.getName()))
                .collect(Collectors.toList());
    }

    Item getItemByName(String name) {

        return itemList.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    List<String> getListNamesAboveWeight(double weight) {

        return itemList.stream()
                .filter(i -> i.getWeight() > weight)
                .map(i -> i.getName())
                .collect(Collectors.toList());
    }

    HashMap<ProductType, Integer> getItemsMap() {

        HashMap<ProductType,Integer> itemsMap = new HashMap<>();

        itemList.stream().map(i -> i.getType())
                .forEach(type -> itemsMap.put(type, (int) itemList.stream().filter(item -> item.getType() == type).count()));

        return  itemsMap;
    }

}
