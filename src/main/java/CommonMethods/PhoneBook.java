package CommonMethods;

import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Contact> contactList;
    private Name name;

    public PhoneBook(ArrayList<Contact> contactList, Name name) {
        this.contactList = contactList;
        this.name = name;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void print() {

        for (Contact c: contactList) {
            System.out.println(c);
        }
    }
}
