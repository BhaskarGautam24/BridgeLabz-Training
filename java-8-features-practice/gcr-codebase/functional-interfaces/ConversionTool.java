interface UnitConverter{
    static double kmToMiles(double km){
        return km * 0.621;
    }
    static double kgToLbs(double kg){
        return kg * 2.204;
    }
}
public class ConversionTool{
    public static void main(String[] args){
        double distanceKm = 10;
        double weightKg = 5;
        System.out.println("Km to Miles: " + UnitConverter.kmToMiles(distanceKm));
        System.out.println("Kg to Lbs: " + UnitConverter.kgToLbs(weightKg));
    }
}

