
/**
 * This class models a car.
 *
 * @author gcschmit
 * @version 9 September 2019
 */
public class Car
{
    /*
     * 2. Define the instance variables (store the object's attributes):
     *      specify the visibility (e.g., private)
     *          public: accessible by any code in any class
     *          private: only accessible by methods in this class
     *      specify the type (e.g., double)
     *      specify the name (e.g., fuelEfficiency)
     *   
     *   Instance variables differ from local variables in the following ways:
     *      scoped to the class (accessible in all methods of the class;
     *          lifetime is the same as the object)
     *      automatically initialized to a default value (0, false, null)
     *      best practice is not to immediately initialize instance variables
     */
    private double fuelEfficiency;  // in units of miles per gallon
    private double fuelInTank;  // in units of gallons
    private String vin; // vehicle identification
    
    
    /*
     * 3. Define the constructor(s):
     *      responsible for initializing newly created objects
     *      invoked automatically via the new operator
     *      name of the constructor must match the name of the class
     *      has no return type (not even void)
     *      multiple constructors may be defined for a class
     *      one constructor may call another constructor (with restrictions)
     */
    
    /**
     * Default constructor for the Car class.
     *      Initializes this car's fuel efficiency to 30 mpg, the fuel in the tank to 0 gallons,
     *          and the VIN to null.
     */
    public Car()
    {
    }
    
    /**
     * Constructs a new Car object with the specified fuel efficiency.
     * 
     * @param initialFuelEfficiency the initial fuel efficiency, in miles per gallon, of this new car
     */
    public Car(double initialFuelEfficiency)
    {
    }
    
    
    /*
     * 1. Define methods by specifying:
     *      the visibility (e.g., public)
     *      the return type (e.g., void)
     *      the method name (e.g., drive)
     *      the parameters and their types (e.g., distance of type double)
     */
    
    /**
     * Account that this car has driven the specified distance, consuming fuel.
     * 
     * @param distance  the distance, in miles, this car drove
     */
    public void drive(double distance)
    {
    }
    
    /**
     * Adds the specified amount of fuel to this car's tank.
     * 
     * @param amount    the amount of fuel, in gallons, to add to this car's tank
     */
    public void addFuel(double amount)
    {
    }
    
    /**
     * Returns the amount of fuel in this car's tank.
     * 
     * @return the amount of fuel, in gallons, in this car's tank.
     */
    public double getFuelInTank()
    {
        return 0.0;
    }
    
    /**
     * Returns the vehicle identification (VIN) of this car.
     * 
     * @return the vehicle identification (VIN) of this car
     */
    public String getVIN()
    {
        return "";
    }
    
    /**
     * Sets the vehicle identification (VIN) of this car.
     * 
     * @param newVIN    the vehicle identification (VIN) of this car
     */
    public void setVIN(String newVIN)
    {
    }
}






