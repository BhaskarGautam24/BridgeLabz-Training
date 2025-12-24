class MovieTicket {

    String movieName;
    String seatNumber;
    double price;
    boolean booked = false;

    void bookTicket(String movieName, String seatNumber, double price) {            // Book a ticket
        if (booked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
        } else {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            booked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        }
    }

    void displayTicket() {                                                    // Display ticket details
        if (!booked) {                                     
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
}

public class MovieTicketSystem {
    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        ticket.displayTicket();                           // not booked yet
        ticket.bookTicket("Dragon", "A10", 120.0);        // booking
        ticket.bookTicket("Dragon", "A10", 120.0);        // already booked
        ticket.bookTicket("Dragon", "A10", 120.0);        
        ticket.displayTicket();                          
    }
}

