import java.util.Scanner;

// Extract Interface
interface Printable {
    void printDetails();
}

// Reservation Class
class Reservation implements Printable {
    private String customerName;
    private String reservationDate;
    private String timeOfReservation;
    private int numberOfPeople;

    public Reservation(String customerName, String reservationDate, String timeOfReservation, int numberOfPeople) {
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.timeOfReservation = timeOfReservation;
        this.numberOfPeople = numberOfPeople;
    }

    // Encapsulate Fields: Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(String timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void printDetails() {
        System.out.println("Reservation Details:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Reservation Date: " + reservationDate);
        System.out.println("Reservation Time: " + timeOfReservation);
        System.out.println("Number of People: " + numberOfPeople);
    }
}

// Restaurant Class
class Restaurant implements Printable {
    private String restaurantName;
    private String location;

    public Restaurant(String restaurantName, String location) {
        this.restaurantName = restaurantName;
        this.location = location;
    }

    // Encapsulate Fields: Getters and Setters
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void printDetails() {
        System.out.println("Restaurant Name: " + restaurantName);
        System.out.println("Location: " + location);
    }

    // Move Method: Moved from Reservation
    public void printReservationDetails(Reservation reservation) {
        System.out.println("Reservation Details for " + restaurantName + ":");
        System.out.println("Customer Name: " + reservation.getCustomerName());
        System.out.println("Reservation Date: " + reservation.getReservationDate());
        System.out.println("Reservation Time: " + reservation.getTimeOfReservation());
        System.out.println("Number of People: " + reservation.getNumberOfPeople());
    }
}

// Main Application Class
class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Extract Method: Separated input logic
        Restaurant restaurant = inputRestaurantDetails(scanner);
        Reservation reservation = inputReservationDetails(scanner);

        restaurant.printDetails();  // Print restaurant details
        restaurant.printReservationDetails(reservation);  // Print reservation details

        System.out.println("Reservation Confirmed! Thank you for choosing " + restaurant.getRestaurantName() + ".");

        scanner.close();
    }

    // Method to input restaurant details
    private static Restaurant inputRestaurantDetails(Scanner scanner) {
        System.out.print("Enter Restaurant Name: ");
        String restaurantName = scanner.nextLine();
        System.out.print("Enter Restaurant Location: ");
        String location = scanner.nextLine();
        return new Restaurant(restaurantName, location);
    }

    // Method to input reservation details
    private static Reservation inputReservationDetails(Scanner scanner) {
        System.out.print("Enter Your Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
        String reservationDate = scanner.nextLine();
        System.out.print("Enter Reservation Time (HH:MM): ");
        String timeOfReservation = scanner.nextLine();
        System.out.print("Enter Number of People: ");
        int numberOfPeople = scanner.nextInt();
        return new Reservation(customerName, reservationDate, timeOfReservation, numberOfPeople);
    }
}