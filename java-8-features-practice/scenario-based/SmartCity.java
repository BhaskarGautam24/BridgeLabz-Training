/*Smart City Transport & Service Management System

Scenario:
The City Council wants to launch a Smart City Transport & Service Management System that
integrates buses, metros, taxis, and EV charging stations. The goal is to optimize routes,
manage schedules, process passenger data, and provide real-time dashboards. The solution
must use Java 8 features to be modern, clean, and extensible.
Breakdown of Feature Usage:
1. Lambda Expressions –
○ Used for filtering and sorting transport schedules based on user preferences
(e.g., earliest departure time, lowest fare).

2. Method References –
○ For quick printing of available services, logging, or invoking static utility methods
for fare calculations.
3. Default Methods in Interfaces –
○ Interface TransportService defines default methods like
printServiceDetails() for all transport types.

4. Static Methods in Interfaces –
○ Static method calculateDistance() in GeoUtils interface to compute
distance between two locations.

5. Stream APIs –
○ Used to group and aggregate passenger data, calculate revenue, and find
top-used routes.
6. ForEach() Method –
○ Display live schedules of all transport services to the dashboard.

7. Collectors - Roles and Capabilities –
○ groupingBy() for grouping passengers by route.
○ partitioningBy() for separating peak vs. non-peak time trips.
○ summarizingDouble() for total and average fares collected.
8. Defining and Implementing Interfaces –
○ TransportService implemented by BusService, MetroService,
TaxiService.
9. Functional Interfaces –
○ FareCalculator functional interface with a single abstract method
calculateFare(), implemented using lambdas.

10. Marker Interfaces –
○ EmergencyService marker interface for services that can bypass traffic rules
(e.g., Ambulance, Fire Service).

Goal: The final system should be able to:
● Filter, group, and summarize transport data in real-time.
● Dynamically display schedules on dashboards.
● Easily extend to new services like ferry or bike rentals by just implementing the right
interfaces.
Flow in Real-Time Usage
1. Passenger books a trip → Lambda filters and sorts available services.
2. Dashboard updates live → ForEach displays current active services.
3. Revenue reports generated → Collectors group and summarize data.
4. System expansion → Adding FerryService just implements the interfaces, default
methods, and optional overrides.
5. Emergency scenario → Marker interface detects and prioritizes emergency services. */

import java.util.*;
import java.util.stream.*;

// marker interface for emergency services
interface EmergencyService{}

// functional interface for fare calculation
@FunctionalInterface
interface FareCalculator{
    double calculateFare(double distance);
}
interface GeoUtils{
    static double calculateDistance(double x1,double y1,double x2,double y2){
        double dx=x2-x1;
        double dy=y2-y1;
        return Math.sqrt(dx*dx+dy*dy);
    }
}
interface TransportService{
    String getName();
    double getFare();
    String getRoute();
    String getDepartureTime();
    default void printServiceDetails(){
        System.out.println(getName()+" | Route: "+getRoute()+" | Fare: "+getFare()+" | Time: "+getDepartureTime());
    }
}
class BusService implements TransportService{
    private String route;
    private double fare;
    private String time;
    BusService(String route,double fare,String time){
        this.route=route;
        this.fare=fare;
        this.time=time;
    }
  public String getName(){
        return "Bus";
    }
    public double getFare(){
        return fare;
    }
    public String getRoute(){
        return route;
    }
    public String getDepartureTime(){
        return time;
    }
}
class MetroService implements TransportService{
    private String route;
    private double fare;
    private String time;
    MetroService(String route,double fare,String time){
        this.route=route;
        this.fare=fare;
        this.time=time;
    }
    public String getName(){
        return "Metro";
    }

    public double getFare(){
        return fare;
    }

    public String getRoute(){
        return route;
    }

    public String getDepartureTime(){
        return time;
    }
}
class TaxiService implements TransportService,EmergencyService{
    private String route;
    private double fare;
    private String time;
    TaxiService(String route,double fare,String time){
        this.route=route;
        this.fare=fare;
        this.time=time;
    }
    public String getName(){
        return "Taxi";
    }
    public double getFare(){
        return fare;
    }
    public String getRoute(){
        return route;
    }
    public String getDepartureTime(){
        return time;
    }
}
class Passenger{

    String name;
    String route;
    double fare;
    boolean peakTime;

    Passenger(String name,String route,double fare,boolean peakTime){
        this.name=name;
        this.route=route;
        this.fare=fare;
        this.peakTime=peakTime;
    }
}



public class SmartCity {
    public static void main(String[] args){
        List<TransportService> services=Arrays.asList(
            new BusService("A-B",2.5,"08:00"),
            new MetroService("A-C",3.0,"08:15"),
            new TaxiService("B-C",5.0,"08:30")
        );
        System.out.println("Live Transport Services:");
        services.forEach(TransportService::printServiceDetails);
        List<Passenger> passengers=Arrays.asList(
            new Passenger("Alice","A-B",2.5,true),
            new Passenger("Bob","A-C",3.0,false),
            new Passenger("Charlie","B-C",5.0,true),
            new Passenger("David","A-B",2.5,false)
        );
        Map<String,List<Passenger>> groupedByRoute=passengers.stream()
            .collect(Collectors.groupingBy(p->p.route));

        System.out.println("\nPassengers Grouped by Route:");
        groupedByRoute.forEach((route,plist)->{
            System.out.println("Route: "+route+" | Passengers: "+plist.size());
        });
        Map<Boolean,List<Passenger>> partitionedByPeak=passengers.stream()
            .collect(Collectors.partitioningBy(p->p.peakTime));

        System.out.println("\nPassengers Partitioned by Peak Time:");
        partitionedByPeak.forEach((isPeak,plist)->{
            System.out.println((isPeak?"Peak Time":"Non-Peak Time")+": "+plist.size()+" passengers");
        });
        DoubleSummaryStatistics fareStats=passengers.stream()
            .collect(Collectors.summarizingDouble(p->p.fare));

        System.out.println("\nFare Statistics:");
        System.out.println("Total Fare: "+fareStats.getSum());
        System.out.println("Average Fare: "+fareStats.getAverage());
      }
  
}
