package LambdasAndStreams;

import java.time.LocalDate;

public class Item {

    public enum ProductType {
        TABLE,
        CHAIR,
        LIBRARY,
        CLOSET,
        WATCH;
    }

    private String name;
    private double weight;
    private LocalDate expirationDate;
    private ProductType type;

    public Item(String name, double weight, LocalDate expirationDate, ProductType type) {
        this.name = name;
        this.weight = weight;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
