package CommonMethods;

import java.util.ArrayList;

public class MainPhone {

    public static void main(String[] args) {

        Name n1 = Name.create("Mr.", "Dan", "Or");
        Name n2 = Name.create("Ms.", "Bar", "Levi");

        PhoneNumber p1 = PhoneNumber.create("04", "6521684");
        PhoneNumber p2 = PhoneNumber.create("02", "6521111");

        Contact c1 = Contact.create(n1, p1);
        Contact c2 = Contact.create(n2, p2);

        // hashCode
        System.out.println(n1.hashCode());
        System.out.println(p1.hashCode());
        System.out.println(c1.hashCode());

        // toString
        System.out.println(n1);
        System.out.println(p1);
        System.out.println(c1);

        // equals
        System.out.println(n1.equals(n2));
        System.out.println(p1.equals(p2));
        System.out.println(c1.equals(c2));

        // compareTo
        System.out.println(n1.compareTo(n2));
        System.out.println(p1.compareTo(p2));
        System.out.println(c1.compareTo(c2));

        // clone
        Name n3 = n1.clone();
        System.out.println(n1);
        System.out.println(n3);
        n3.setPrefix("Mr.");
        n3.setFirstName("Fname");
        n3.setLastName("Lname");
        System.out.println(n1);
        System.out.println(n3);

        PhoneNumber p3 = p1.clone();
        System.out.println(p1);
        System.out.println(p3);
        p3.setAreaCode("02");
        p3.setNumber("6258421");
        System.out.println(p1);
        System.out.println(p3);

        Contact c3 = c1.clone();
        System.out.println(c1);
        System.out.println(c3);
        c3.setName(Name.create("Mr.", "Fname", "Lname"));
        c3.setPhoneNumber(PhoneNumber.create("02", "6258421"));
        System.out.println(c1);
        System.out.println(c3);

        // PhoneBook
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);

        PhoneBook phoneBook = new PhoneBook(contacts, Name.create("Ms.", "Galit", "Dor"));
        phoneBook.print();
    }
}
