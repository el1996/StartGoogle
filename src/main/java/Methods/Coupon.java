package Methods;

import java.time.LocalDate;

public class Coupon {
    private int id;
    private LocalDate expiryDate;
    private int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Coupon(int id, LocalDate expiryDate, int value) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.value = value;
    }

    public String print() {
        return "Id: " + id + " ExpiryDate: " + expiryDate + " Value: " + value;
    }
}
