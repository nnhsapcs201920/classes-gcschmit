import java.util.Scanner;

/**
 * Create a RectangleCalculator class with a constructor that takes the height
 * and width as parameters and with three methods: getArea, getPerimeter,
 * getDiagonalLength. Also add the toString method which returns a String
 * containing the rectangle's height, width, area, perimeter, and diagonal
 * length.
 * 
 * Create a main method that asks the user for the lengths of a rectangle's
 * sides, creates a RectangleCalculator object, and passes the variable
 * referencing the object to the System.out.println method (which indirectly
 * invokes the three methods on the object, and prints the values returned).
 *
 * @author gcschmit
 * @version 2 October 2018
 */
public class RectangleCalculator
{
    private double height;
    private double width;

    public RectangleCalculator(double initialHeight, double initialWidth)
    {
        this.height = initialHeight;
        this.width = initialWidth;
    }

    public double getArea()
    {
        double area = this.height * this.width;
        return area;
    }
    
    public double getPerimeter()
    {
        double perimeter = 2 * (this.height + this.width);
        return perimeter;
    }
    
    public double getDiagonalLength()
    {
        double diagonalLength =
                Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.width, 2));
        return diagonalLength;
    }
    
    public String toString()
    {
        String str = "height: " + this.height + ", width: " + this.width +
            ", area: " + this.getArea() +
            ", perimeter: " + this.getPerimeter() +
            ", diagonal length: " + this.getDiagonalLength();
        return str;
    }
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the rectangle's height: ");
        double userHeight = s.nextDouble();
        
        System.out.print("Enter the rectangle's width: ");
        double userWidth= s.nextDouble();
        
        RectangleCalculator rectCalc =
                new RectangleCalculator(userHeight, userWidth);

        System.out.println(rectCalc);
    }
}
