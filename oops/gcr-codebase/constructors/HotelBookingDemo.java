import java.util.*;
public class HotelBookingDemo {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // taking user values
        String guestName = scn.nextLine();
        String roomType = scn.nextLine();
        int nights = scn.nextInt();

        // using parameterized constructor
        HotelBooking booking1 = new HotelBooking(guestName, roomType, nights);

        // using default constructor
        HotelBooking booking2 = new HotelBooking();

        // using copy constructor
        HotelBooking booking3 = new HotelBooking(booking1);

        // showing outputs
        booking1.showBooking();
        booking2.showBooking();
        booking3.showBooking();
    }
}

// class for hotel booking
class HotelBooking {

    // booking variables
    private String guestName;
    private String roomType;
    private int nights;

    // default constructor
    public HotelBooking() {
        this.guestName = "guest";
        this.roomType = "normal";
        this.nights = 1;
    }

    // parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // copy constructor
    public HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    // method to display booking
    public void showBooking() {
        System.out.println(guestName + " | " + roomType + " | " + nights);
    }
}

