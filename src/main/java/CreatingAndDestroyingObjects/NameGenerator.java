package CreatingAndDestroyingObjects;

import java.util.ArrayList;
import java.util.Random;

public class NameGenerator {

    private ArrayList<String> names;

    private static Random random = new Random();

    public NameGenerator(ArrayList<String> names) {

        this.names =  names;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String generateName() {

        return names.get(generateRandomNumber(21));
    }

    private int generateRandomNumber(int num) {

        return random.nextInt(num);
    }


}
