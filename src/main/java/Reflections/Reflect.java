package Reflections;

import Enums.Enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.Random;


public class Reflect {

    private static Random random = new Random();

    public static Optional<Object> newInstanceSingleString(Object o){
        Class<?> aClass = o.getClass();
        try {
            Constructor<?> constructor = aClass.getConstructor(String.class);
            Object newObject = constructor.newInstance(generateRandoString());
            return Optional.of(newObject);
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to instantiate constructor",e);
        }
    }

    private static void checkReflect(Object o) {

        Optional<Object> newObject = newInstanceSingleString(o);
        if (newObject.isPresent()) {
            System.out.println("Constructor with one string exists, String: " + newObject.get().toString());
        }
        else {
            System.out.println("Constructor with one string dose not exist");
        }
    }

    public static String generateRandoString() {
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

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

    public static void main(String[] args) {
      //  Reflect reflect = new Reflect();
        FittingConstructor fittingConstructor = new FittingConstructor("sjhjshfj");
        NonFittingConstructor nonFittingConstructor = new NonFittingConstructor(5);

        checkReflect(fittingConstructor);
        checkReflect(nonFittingConstructor);
    }

}
