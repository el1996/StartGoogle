package CommonMethods;

import java.util.Objects;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    String areaCode;
    String number;

    private PhoneNumber(String areaCode, String number) {

        this.areaCode = areaCode;
        this.number = number;
    }

    static PhoneNumber create(String areaCode, String number) {
        return new PhoneNumber(areaCode, number);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    protected PhoneNumber clone() {

        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "PhoneNumber: " +
                "areaCode=" + areaCode +
                ", number='" + number + "";
    }

    @Override
    public int compareTo(PhoneNumber o) {

        int result = areaCode.compareTo(o.areaCode);

        if (result == 0) {

            result = number.compareTo(o.number);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return Objects.equals(areaCode, phoneNumber.areaCode) &&
                Objects.equals(number, phoneNumber.number);
    }
}
