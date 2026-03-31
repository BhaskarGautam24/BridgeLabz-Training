import java.util.*;
public class AeroVigilSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter flight details");
        String input=sc.nextLine();

        String[] data=input.split(":");
        FlightUtil util=new FlightUtil();
        try{
            String flightNumber=data[0];
            String flightName=data[1];
            int passengerCount=Integer.parseInt(data[2]);
            double currentFuelLevel=Double.parseDouble(data[3]);
            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount,flightName);

            double fuelRequired=util.calculateFuelToFillTank(flightName,currentFuelLevel);

            System.out.println("Fuel required to fill the tank: "+fuelRequired+" liters");

        }catch(InvalidFlightException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            // for any unexpected issue
            System.out.println(e.getMessage());
        }
    }
}
class FlightUtil{
    public boolean validateFlightNumber(String flightNumber)throws InvalidFlightException{
        if(!flightNumber.matches("FL-[0-9]{4}")){
            throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
        }
        int num=Integer.parseInt(flightNumber.substring(3));
        if(num<1000||num>9999){
            throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName)throws InvalidFlightException{
        if(!(flightName.equals("SpiceJet")||
             flightName.equals("Vistara")||
             flightName.equals("IndiGo")||
             flightName.equals("Air Arabia"))){

            throw new InvalidFlightException("The flight name "+flightName+" is invalid");
        }
        return true;
    }
    public boolean validatePassengerCount(int passengerCount,String flightName)throws InvalidFlightException{
        int maxCapacity=0;
        if(flightName.equals("SpiceJet")){
            maxCapacity=396;
        }else if(flightName.equals("Vistara")){
            maxCapacity=615;
        }else if(flightName.equals("IndiGo")){
            maxCapacity=230;
        }else if(flightName.equals("Air Arabia")){
            maxCapacity=130;
        }

        if(passengerCount<=0||passengerCount>maxCapacity){
            throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName,double currentFuelLevel)throws InvalidFlightException{
        double capacity=0;
        if(flightName.equals("SpiceJet")){
            capacity=200000;
        }else if(flightName.equals("Vistara")){
            capacity=300000;
        }else if(flightName.equals("IndiGo")){
            capacity=250000;
        }else if(flightName.equals("Air Arabia")){
            capacity=150000;
        }

        if(currentFuelLevel<0||currentFuelLevel>capacity){
            throw new InvalidFlightException("Invalid fuel level for "+flightName);
        }
        return capacity-currentFuelLevel;
    }
}
class InvalidFlightException extends Exception{
    public InvalidFlightException(String message){
        super(message);
    }
}
