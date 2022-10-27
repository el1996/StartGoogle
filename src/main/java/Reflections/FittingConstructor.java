package Reflections;

public class FittingConstructor {
    private String str;
    public FittingConstructor(String s) {
        this.str = s;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return str;
    }
}
