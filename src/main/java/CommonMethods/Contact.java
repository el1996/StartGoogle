package CommonMethods;

import java.util.Objects;

public class Contact implements Cloneable, Comparable<Contact> {

    private Name name;
    private PhoneNumber phoneNumber;

    private Contact(Name name, PhoneNumber phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    static Contact create(Name name, PhoneNumber phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected Contact clone() {

        try {
            return (Contact) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Contact{ " + name + phoneNumber + " }";
    }

    @Override
    public int compareTo(Contact o) {

        int result = name.compareTo(o.name);

        if (result == 0) {

            result = phoneNumber.compareTo(o.phoneNumber);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }
}
