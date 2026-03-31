import java.util.function.Predicate;
public class TemperatureAlertSystem{
    public static void main(String[] args){

        double temperature=45.0;
        double limit=40.0;

        Predicate<Double> temperatureCheck=temp -> temp>limit;

        if (temperatureCheck.test(temperature)){
            System.out.println("Alert! Temperature crossed the threshold");
        } else{
            System.out.println("Temperature is under control");
        }
    }
}
