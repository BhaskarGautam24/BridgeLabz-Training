

public class VolumeOfEarth {
  public static void main(String[] args){
    int radius = 6378;
    double r_in_miles = radius * 0.6213;
    double volume = (4/3.0) * 3.14 * radius * radius * radius;
    double volume_in_miles = (4/3.0) * 3.14 * r_in_miles * r_in_miles * r_in_miles;
    System.out.println("The volume of earth in cubic kilometers is"+" "+volume+" "+"and in cubic miles is"+" "+volume_in_miles);

  }
  
}
