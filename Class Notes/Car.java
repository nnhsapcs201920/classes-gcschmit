
/**
 * This class models a car.
 *
 * @author gcschmit
 * @version 9 September 2019
 */
public class Car
{
    /*
     * 2. Instance variables store the object's attributes.
     *      specify the visibility (eg, private)
     *          public: accessible by anyone
     *          private: only accessible by methods in this class
     *      specify the type (e.g., double)
     *      specify the name (e.g., fuelEfficiency, fuelInTank)
     *  
     *  Instance variables differ from local variables in the following ways:
     *      scoped to their class (accessible for all methods)
     *      automatically initialized to a default value (0, false, null)
     *      best practice is not to immediately initialize instance variables
     */
    private double fuelEfficiency; // in units of miles per gallon
    private double fuelInTank;  // in units of gallons
    private String vin; // vehicle identification
    
    
    /*
     * 3. Define the constructor(s):
     *      responsible for initializing newly created objects
     *      invoked automatically via the new operator
     *      name of the constructor must match the name of the class
     *      has no return type (not even void)
     *      multiple  constuctors may be defined for a class
     *      one constructor may call another constructor (with restrictions)
     */
    
    /**
     * Default constructor for the Car class.
     *      Initializes the fuel efficiency to 30 mpg and the fuel in this car's tank to 0 gallons.
     */
    public Car()
    {
        /*
         * The "this" reserved word references the current object (like "self" Python)
         *  Its usage is encouraged but only sometimes required.
         */
        this.fuelEfficiency = 30;
        this.fuelInTank = 0;
        this.vin = null;
    }
    
    /**
     * Constructs a new Car object with the specified fuel efficiency
     * 
     * @param initialFuelEfficiency     the initial fuel efficiency, in miles per gallon, of this new car
     */
    public Car(double initialFuelEfficiency)
    {
        
    }
    
    /*
     * 1. Define the methods:
     *      the visibility (e.g, public)
     *      the return type (e.g., void)
     *      the method name (e.g., drive)
     *      the parameters and their type (e.g., distance of type double)
     */
    
    /**
     * Drives this car the specified distance, consuming fuel
     * 
     * @param distance  the distance, in miles, this car drives
     */
    public void drive(double distance)
    {
    }
    
    /**
     * Adds the specified amount of fuel to this car's tank
     * 
     * @param amount    the amount of fuel, in gallons, to add to this car's tank
     */
    public void addFuel(double amount)
    {
    }
    
    /**
     * Returns the amount of fuel in this car's tank
     * 
     * @return the amount of fuel, in gallons, in this car's tank
     */
    public double getFuelInTank()
    {
        return 0.0;
    }
    
    /**
     * Returns the VIN of this car
     * 
     * @return the VIN of this car
     */
    public String getVIN()
    {
        return "";
    }
    
    /**
     * Sets the VIN of this car
     * 
     * @param newVIN    the VIN of this car
     */
    public void setVIN(String newVIN)
    {
    }
}








