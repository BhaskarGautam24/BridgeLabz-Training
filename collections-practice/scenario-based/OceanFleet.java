import java.util.*;
public class OceanFleet{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        VesselUtil util=new VesselUtil();
        System.out.println("Enter the number of vessels to be added");
        int n=sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter vessel details");
        for(int i=0;i<n;i++){
            String input=sc.nextLine();
            String[] data=input.split(":");
            String vesselId=data[0];
            String vesselName=data[1];
            double averageSpeed=Double.parseDouble(data[2]);
            String vesselType=data[3];

            Vessel vessel=new Vessel(vesselId, vesselName, averageSpeed, vesselType);
            util.addVesselPerformance(vessel);
        }
        System.out.println("Enter the Vessel Id to check speed");
        String searchId=sc.nextLine();
        Vessel result = util.getVesselById(searchId);
        if (result != null){
            System.out.println(result.getVesselId()+" | "+result.getVesselName()+" | "+result.getVesselType()+" | "+result.getAverageSpeed()+" knots");
        } else {
            System.out.println("Vessel Id "+searchId+" not found");
        }
        System.out.println("High performance vessels are");
        List<Vessel> highVessels=util.getHighPerformanceVessels();
        for (Vessel v : highVessels){
            System.out.println(v.getVesselId()+" | "+v.getVesselName()+" | "+v.getVesselType()+" | "+v.getAverageSpeed()+" knots");
        }
    }
}
class Vessel{
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;
    public Vessel(){
    }
    public Vessel(String vesselId,String vesselName,double averageSpeed,String vesselType) {
        this.vesselId=vesselId;
        this.vesselName=vesselName;
        this.averageSpeed=averageSpeed;
        this.vesselType=vesselType;
    }
    public String getVesselId(){
        return vesselId;
    }

    public void setVesselId(String vesselId){
        this.vesselId=vesselId;
    }

    public String getVesselName(){
        return vesselName;
    }

    public void setVesselName(String vesselName){
        this.vesselName=vesselName;
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed){
        this.averageSpeed=averageSpeed;
    }

    public String getVesselType(){
        return vesselType;
    }

    public void setVesselType(String vesselType){
        this.vesselType=vesselType;
    }
}
class VesselUtil{
    private List<Vessel> vesselList=new ArrayList<Vessel>();
    public List<Vessel> getVesselList(){
        return vesselList;
    }
    public void setVesselList(List<Vessel> vesselList){
        this.vesselList=vesselList;
    }
    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
    }
    public Vessel getVesselById(String vesselId){

        for (Vessel v:vesselList) {
            if (v.getVesselId().equals(vesselId)){
                return v;
            }
        }
        return null;
    }
    public List<Vessel> getHighPerformanceVessels(){
        List<Vessel> result=new ArrayList<Vessel>();
        double maxSpeed=0.0;
        for (Vessel v:vesselList){
            if (v.getAverageSpeed()>maxSpeed) {
                maxSpeed=v.getAverageSpeed();
            }
        }
        for (Vessel v:vesselList){
            if (v.getAverageSpeed()==maxSpeed) {
                result.add(v);
            }
        }
        return result;
    }
}