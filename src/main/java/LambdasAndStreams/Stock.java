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

    public void printDates() {

        for (Item item: itemList) {
            System.out.println("Name: " + item.getName() + " ,Weight: " + item.getWeight() + " ,Date: " + item.getExpirationDate() + " ,Type: " + item.getType());
        }
    }

    void generateItemAndAddToList(String name, double weight, LocalDate expirationDate, ProductType type) {

        Item item = new Item(name, weight, expirationDate, type);

        itemList.add(item);

        itemList = itemList.stream()         // i -> i.getExpirationDate()
                .sorted(Comparator.comparing( Item :: getExpirationDate ))
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
                .min(Comparator.comparing(Item::getExpirationDate)).get();
                                        //item -> item.getExpirationDate()
    }


     List<Item> getAlphabeticallySortedItems() {

        return itemList.stream()
                                           //i -> i.getName()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
    }

    Optional<Item> getItemByName(String name) {

        return itemList.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst();
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
