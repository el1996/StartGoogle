package CreatingAndDestroyingObjects;

import java.util.*;

public class Utilities {

    private  ArrayList<String> names1;

    private  ArrayList<String> names2;

    public Utilities() {

        ArrayList<String> nameList1 = new ArrayList<>(
                Arrays.asList("Wade Williams", "Dave Harris", "Seth Thomas","Ivan Robinson", "Riley Walker", "Nathaniel Scott",
                        "Ramon Nelson", "Gilbert Mitchell", "Harvey Morgan","Milton Cooper", "Ethan Howard", "Glen Davis",
                        "Roberto Anderson", "Jorge White", "Liam Perry","Claude Clark", "Lewis Richards", "Joshua Wheeler",
                        "Brian Miller", "Dan Martin", "Miles Smith"));

        ArrayList<String> nameList2 =  new ArrayList<>(
                Arrays.asList("Wade Williams", "Dave Harris", "Seth Thomas","Ivan Robinson", "Riley Walker", "Nathaniel Scott",
                        "Ramon Nelson", "Gilbert Mitchell", "Harvey Morgan","Milton Cooper", "Ethan Howard", "Glen Davis",
                        "Roberto Anderson", "Jorge White", "Liam Perry","Claude Clark", "Lewis Richards", "Joshua Wheeler",
                        "Brian Miller", "Dan Martin", "Miles Smith"));

        names1 = nameList1;
        names2 = nameList2;
    }

    public  ArrayList<String> getNames1() {
        return names1;
    }

    public void setNames1( ArrayList<String> names1) {
        this.names1 = names1;
    }

    public  ArrayList<String> getNames2() {
        return names2;
    }

    public void setNames2( ArrayList<String> names2) {
        this.names2 = names2;
    }

}
