import java.util.*;
public class FutureLogisticsSystem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();
        Utility utility = new Utility();
        GoodsTransport goods = utility.parseDetails(input);
        if (goods != null) {
            String type = utility.findObjectType(goods);
            if (type.equals("BrickTransport")){
                BrickTransport bt = (BrickTransport) goods;

                System.out.println("Transporter id : "+bt.getTransportId());
                System.out.println("Date of transport : "+bt.getTransportDate());
                System.out.println("Rating of the transport : "+bt.getTransportRating());
                System.out.println("Quantity of bricks : "+bt.getBrickQuantity());
                System.out.println("Brick price : "+bt.getBrickPrice());
                System.out.println("Vehicle for transport : "+bt.vehicleSelection());
                System.out.println("Total charge : "+bt.calculateTotalCharge());
            } else if (type.equals("TimberTransport")) {
                TimberTransport tt=(TimberTransport) goods;

                System.out.println("Transporter id : "+tt.getTransportId());
                System.out.println("Date of transport : "+tt.getTransportDate());
                System.out.println("Rating of the transport : "+tt.getTransportRating());
                System.out.println("Type of the timber : "+tt.getTimberType());
                System.out.println("Timber price per kilo : "+tt.getTimberPrice());
                System.out.println("Vehicle for transport : "+tt.vehicleSelection());
                System.out.println("Total charge : "+tt.calculateTotalCharge());
            }
        }
    }
}
abstract class GoodsTransport{
    protected String transportId;
    protected String transportDate;
    protected int transportRating;
    public GoodsTransport(String transportId,String transportDate,int transportRating){
        this.transportId=transportId;
        this.transportDate=transportDate;
        this.transportRating=transportRating;
    }

    public String getTransportId(){
        return transportId;
    }

    public String getTransportDate(){
        return transportDate;
    }

    public int getTransportRating(){
        return transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}
class BrickTransport extends GoodsTransport{
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;
    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public int getBrickQuantity(){
        return brickQuantity;
    }

    public float getBrickPrice(){
        return brickPrice;
    }

    public String vehicleSelection(){

        if (brickQuantity < 300){
            return "Truck";
        } else if (brickQuantity <= 500){
            return "Lorry";
        } else{
            return "MonsterLorry";
        }
    }
    public float calculateTotalCharge(){

        float price=brickPrice*brickQuantity;
        float tax=price*0.30f;

        float discount=0;
        if (transportRating==5){
            discount = price * 0.20f;
        } else if (transportRating==3||transportRating==4){
            discount = price*0.10f;
        }

        int vehiclePrice = 0;
        String vehicle = vehicleSelection();

        if (vehicle.equalsIgnoreCase("Truck")){
            vehiclePrice = 1000;
        } else if (vehicle.equalsIgnoreCase("Lorry")){
            vehiclePrice = 1700;
        } else {
            vehiclePrice = 3000;
        }

        return (price + tax + vehiclePrice) - discount;
    }
}

/* child class for timber transport */
class TimberTransport extends GoodsTransport{

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId,String transportDate,int transportRating,
                           float timberLength,float timberRadius,
                           String timberType,float timberPrice){
        super(transportId,transportDate,transportRating);
        this.timberLength=timberLength;
        this.timberRadius=timberRadius;
        this.timberType=timberType;
        this.timberPrice=timberPrice;
    }

    public String getTimberType(){
        return timberType;
    }

    public float getTimberPrice(){
        return timberPrice;
    }

    public String vehicleSelection(){

        float area = 2*3.147f*timberRadius*timberLength;
        if (area < 250){
            return "Truck";
        } else if (area <= 400){
            return "Lorry";
        } else{
            return "MonsterLorry";
        }
    }

    public float calculateTotalCharge(){

        float volume=3.147f*timberRadius*timberRadius*timberLength;
        float rate=0;
        if (timberType.equalsIgnoreCase("Premium")){
            rate=0.25f;
        } else {
            rate=0.15f;
        }

        float price=volume*timberPrice*rate;
        float tax=price*0.30f;

        float discount=0;
        if(transportRating==5) {
            discount=price*0.20f;
        } else if(transportRating==3 ||transportRating==4){
            discount=price*0.10f;
        }

        int vehiclePrice=0;
        String vehicle=vehicleSelection();

        if(vehicle.equalsIgnoreCase("Truck")){
            vehiclePrice=1000;
        } else if(vehicle.equalsIgnoreCase("Lorry")){
            vehiclePrice=1700;
        } else{
            vehiclePrice=3000;
        }

        return (price+tax+vehiclePrice)-discount;
    }
}

class Utility{

    public GoodsTransport parseDetails(String input){

        String[] data=input.split(":");

        String transportId=data[0];

        if (!validateTransportId(transportId)){
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return null;
        }

        String date = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (type.equalsIgnoreCase("BrickTransport")){

            float size = Float.parseFloat(data[4]);
            int qty = Integer.parseInt(data[5]);
            float price = Float.parseFloat(data[6]);

            return new BrickTransport(transportId, date, rating, size, qty, price);

        } else{

            float length = Float.parseFloat(data[4]);
            float radius = Float.parseFloat(data[5]);
            String timberType = data[6];
            float timberPrice = Float.parseFloat(data[7]);

            return new TimberTransport(transportId, date, rating,
                    length, radius, timberType, timberPrice);
        }
    }

    public boolean validateTransportId(String transportId){

        if (transportId.length()!=7){
            return false;
        }

        if (!transportId.startsWith("RTS")){
            return false;
        }

        for(int i=3;i<6;i++){
            if (!Character.isDigit(transportId.charAt(i))) {
                return false;
            }
        }

        if(!Character.isUpperCase(transportId.charAt(6))){
            return false;
        }

        return true;
    }

    public String findObjectType(GoodsTransport goodsTransport){

        if (goodsTransport instanceof TimberTransport){
            return "TimberTransport";
        } else {
            return "BrickTransport";
        }
    }
}
