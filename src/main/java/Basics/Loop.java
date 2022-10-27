package Basics;


public class Loop {

    static void loopFor(int array[] ,int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]%x == 0) {
                System.out.println(array[i]);
            }
        }
        System.out.println();
    }

    static void loopForEach(int array[] ,int x){
        for (int i: array) {
            if (i%x == 0) {
                System.out.println(i);
            }
        }
        System.out.println();
    }

    static void loopWhile(int array[] ,int x){
        int i=0;
        while (i < array.length) {
            if (array[i]%x==0) {
                System.out.println(array[i]);
            }
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num =5;
        int[] numbers = {0, 15, 2, 3, 40, 5, 6, 7, 85, 9};
        loopForEach(numbers, num);
        loopFor(numbers, num);
        loopWhile(numbers, num);
    }
}
