package CommonMethods;

import java.util.Objects;

public class Name implements Cloneable, Comparable<Name> {

    private String prefix;
    private String firstName;
    private String lastName;

    private Name(String prefix, String firstName, String lastName) {
       // Thread.dumpStack();
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static Name create(String prefix, String firstName, String lastName) {
        return new Name(prefix, firstName, lastName);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    protected Name clone() {

        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Name: " +
                "prefix=" + prefix +
                ", firstName=" + firstName +
                ", lastName=" + lastName + " | ";
    }

    @Override
    public int compareTo(Name o) {

        int result = prefix.compareTo(o.prefix);

        if (result == 0) {

            result = firstName.compareTo(o.firstName);

            if (result == 0) {

                result = lastName.compareTo(o.lastName);
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(prefix, name.prefix) &&
               Objects.equals(firstName, name.firstName) &&
               Objects.equals(lastName, name.lastName);
    }
}
