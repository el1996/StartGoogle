package ClassesAndInterfaces;

public class Square implements Figure{

   private double length;


    public Square(double length) {
        this.length = length;
       // super(length,length)

    }

    public double area(){
        return length*length;
    }
}
