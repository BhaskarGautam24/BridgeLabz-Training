/*Write a program calculate the wind chill temperature given the temperature and wind speed
Hint => 
Write a method to calculate the wind chill temperature using the formula 
windChill = 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * windSpeed0.16 
public double calculateWindChill(double temperature, double windSpeed)
 */
package methods;
import java.util.*;
public class WindChillCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temperature = scn.nextDouble();

        System.out.print("Enter the wind speed (in miles per hour): ");
        double windSpeed = scn.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed); // calling method to calculate wind chill

        System.out.println("The Wind Chill Temperature is: " + windChill);
    }
    // Method to calculate wind chill temperature
    static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}