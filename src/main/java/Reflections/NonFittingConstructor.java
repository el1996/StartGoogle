package Reflections;

public class NonFittingConstructor {

    private int num;

    public NonFittingConstructor(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
