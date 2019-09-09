
/**
 * This class models a car.
 *
 * @author gcschmit
 * @version 9 September 2019
 */
public class Car
{
    /*
     * Instance variables store the object's attributes.
     *      specify the visibility (eg, private)
     *          public: accessible by anyone
     *          private: only accessible by methods in this class
     *      specify the type (e.g., double)
     *      specify the name (e.g., fuelEfficiency, fuelInTank)
     *  
     *  
     */
    private double fuelEfficiency; // in units of miles per gallon
    
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








