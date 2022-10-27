package Generics;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Generics {

    private static int sleep = 7;
    private static int retry = 6;
    private static ArrayList<String> names = new ArrayList<>(Arrays.asList("Shalom", "Michal", "Or"));

    public static void main(String[] args) throws Exception {

        Callable<String> stringCallable = new Callable<>() {

            @Override
            public String call() throws Exception {
                return names.get(ThreadLocalRandom.current().nextInt(3));
            }
        };

        Callable<Integer> intCallable = new Callable<>() {

            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().nextInt(3);
            }
        };

        System.out.println("Find expected result \"Shalom\" before max retry 10:");
        System.out.println(retry(stringCallable, "Shalom", 2, 10));
        System.out.println("\nDoes not find expected result \"Bar\" before max retry 7:");
        System.out.println(retry(stringCallable, "Bar", 1, 7));
        System.out.println("\nDoes not find expected result \"11\" before max retry 8:");
        System.out.println(retry(intCallable,11, 5, 8));
        System.out.println("\nFind expected result \"2\" before max retry 6:");
        System.out.println(retry(intCallable,2, 3, 6));

        System.out.println("\n\nDefault sleeps and retry limits:");
        System.out.println("\nFind expected result \"Shalom\" before max retry " + retry + ":");
        System.out.println(retryWithDefault(stringCallable, "Shalom"));
        System.out.println("\nDoes not find expected result \"Bar\" before max retry " + retry + ":");
        System.out.println(retryWithDefault(stringCallable, "Bar"));
        System.out.println("\nDoes not find expected result \"11\" before max retry " + retry + ":");
        System.out.println(retryWithDefault(intCallable,11));
        System.out.println("\nFind expected result \"2\" before max retry " + retry + ":");
        System.out.println(retryWithDefault(intCallable,2));
    }

    public static <T> T retry(Callable<T> action, T expectedResult, int sleep, int retry) throws Exception {
        T result;
        int retryNum = 0;

        do {
            result = action.call();
            retryNum++;

            System.out.println("retryNum: " + retryNum);

            Thread.sleep(sleep * 10L);
        }
        while (!result.toString().equalsIgnoreCase(expectedResult.toString()) && retryNum < retry);

        return result;
    }
    public static <T> T retryWithDefault(Callable<T> action, T expectedResult) throws Exception {

        return retry(action, expectedResult, sleep, retry);
    }
}