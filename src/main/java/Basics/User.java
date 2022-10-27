package Basics;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class User {
    private String Name;
    private int Id;
    private boolean IsActivated;

    private static Random random = new Random();

    static HashMap<Integer, User> usersMap = new HashMap<>();
    static ArrayList<User> usersList = new ArrayList<>();


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isActivated() {
        return IsActivated;
    }

    public void setActivated(boolean activated) {
        IsActivated = activated;
    }

    public User(String name, int id, boolean isActivated) {
        Name = name;
        Id = id;
        IsActivated = isActivated;
    }

    public static User getUser(int id) {
        for (User user : usersList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static int getActivatedUsersFromMap() {
        int count = 0;
        for (User user : usersMap.values()) {
            if (user.isActivated()) {
                count++;
            }
        }
        return count;
    }

    public static int getActivatedUsersFromList() {
        int count = 0;
        for (User user : usersList) {
            if (user.isActivated()) {
                count++;
            }
        }
        return count;
    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static String generateRandomName() {
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static int generateRandomID() {

        // Generate random integers in range 0 to 99
        return random.nextInt(100);
    }

    public  static void main(String[] args) {

//      Random
        for (int i = 1; i < 5; i++) {
            usersMap.put(i, new User( generateRandomName(), generateRandomID(), getRandomBoolean()));
        }

        // List
        usersList.addAll(usersMap.values());

        User temp = getUser(usersList.get(0).getId());

        if (temp != null) {
            System.out.println("User: " + temp.getName() + " Id: "  + temp.Id + " Active: " + temp.isActivated());
        }

        //System.out.println(getActivatedUsersFromMap());
        System.out.println("Number of Active Users: " + getActivatedUsersFromList());
    }

}
