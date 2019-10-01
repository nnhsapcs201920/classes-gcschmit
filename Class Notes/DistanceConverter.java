import java.util.Scanner;

public class DistanceConverter
{   
    public static final int FEET_FOR_EVERY_YARD = 3;
    public static final int INCHES_FOR_EVERY_FOOT = 12;

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of yards to be converted to feet and inches: ");

		double yards = s.nextDouble();
        double feet = yards * DistanceConverter.FEET_FOR_EVERY_YARD;
        double inches = feet * DistanceConverter.INCHES_FOR_EVERY_FOOT;

        System.out.println(yards + " yards are " + feet + " feet");
        System.out.println(yards + " yards are " + inches + " inches");
    }
}