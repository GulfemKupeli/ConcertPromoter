import java.util.Scanner;

public class ConcertPromoter {
    private String band_name;
    private int venue_capacity;
    private int tickets_sold;
    private boolean venue_sold;
    private double total_sale;
    private int phone_price;
    private int venue_price;

    public ConcertPromoter() {
//No preconditions.
        //Creates a ConcertPromoter object.
    }

    //This is constructor for initializing the object.
    public ConcertPromoter(String band_name, int venue_capacity, int phone_price, int venue_price) {
        //Preconditions:string band_name; int-> venue_capacity, phone_price, venue_price
        //Post-conditions: Creates a Concert Promoter object with specified values.(band name, venue capacity, phone price, venue price.)
        this.band_name = band_name;
        this.venue_capacity = venue_capacity;
        this.phone_price = phone_price;
        this.venue_price = venue_price;
        this.tickets_sold = 0;
        this.total_sale = 0.0;
        this.venue_sold = false;
    }

    //This method keeps the record of sold tickets.
    public void TicketSale(int tickets_num) {
        //Preconditions: int tickets_num
        //Post-Conditions: updates ticket sales.
        if (tickets_num > 0 && tickets_num <= getRemainingTickets()) {
            if (venue_sold) {
                total_sale = total_sale + tickets_num * venue_price;
            } else {
                total_sale = total_sale + tickets_num * phone_price;
            }
            tickets_sold = tickets_sold + tickets_num;
        } else {
            System.out.println("Invalid ticket number.");
        }
    }

    //This gets the number of tickets sold.
    public int getSoldTicket() {
        //no preconditions
        //postconditions: returns the tickets_sold
        return tickets_sold;
    }

    //This method calculates the remaining tickets.
    public int getRemainingTickets() {
        //no preconditions
        //postconditions: returns the remaining ticket number.
        return venue_capacity - tickets_sold;
    }

    //Gets total sales amount.
    public double getTotal_sale() {
        //no preconditions
        //postconditions: returns the total_sale
        return total_sale;
    }

    public void turnVenueSale() {
        //no preconditions
        //Postconditions: switch to venue sales
        venue_sold = true;
    }
//This is for running the game.(Test the class)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter band name: ");
        String band_name = scanner.nextLine();
        System.out.println("Enter venue capacity: ");
        int venue_capacity = scanner.nextInt();
        System.out.println("Enter price of a ticket sold at the venue: ");
        int venue_price = scanner.nextInt();
        System.out.println("Enter price of a ticket sold by phone: ");
        int phone_price = scanner.nextInt();

        ConcertPromoter concert = new ConcertPromoter(band_name, venue_capacity, phone_price, venue_price);

        System.out.println("Enter the number of tickets sold by phone:");
        int phoneSales = scanner.nextInt();
        concert.TicketSale(phoneSales);
        System.out.println("Tickets remaining after phone sale: " + concert.getRemainingTickets());

        System.out.println("Enter the number of tickets sold at the venue:");
        int venueSales = scanner.nextInt();
        concert.TicketSale(venueSales);
        System.out.println("Tickets remaining after venue sale: " + concert.getRemainingTickets());

        //displays final state
        System.out.println("**********************************");
        System.out.println("Band Name: " + concert.band_name);
        System.out.println("Total tickets sold: " + concert.getSoldTicket());
        System.out.println("Total sales amount: $" + concert.getTotal_sale());

        scanner.close();
    }
}
