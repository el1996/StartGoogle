package ClassesAndInterfaces;

public class Circle implements Figure{
    public Circle(double radius) {
        this.radius = radius;
    }
    private double radius;

    public double area(){
        return Math.PI * (radius * radius);
    }
}
