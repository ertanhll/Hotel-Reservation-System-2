
import java.util.Scanner;

public class Service {
    private Reservation[] reservedList;
    private int numReservations;

    public Service() {
        reservedList = new Reservation[20];
        numReservations = 0;      
    }

	public int getNumReservations() {
		return numReservations;	
	}

	public void displayReservations() {
        if (numReservations == 0) {
            System.out.println("There are no reservations.");
            return;
        }

        for (int i = 0; i < numReservations; i++) {
            reservedList[i].displayInfo();
        }
    }

    public static void main(String[] args) {
       
    	Service reserved = new Service();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create new Reservation");
            System.out.println("2. Display all Reservations");
            System.out.println("0. Exit");

            int option = input.nextInt();
            input.nextLine();

            if (option == 0) {
            	System.out.println("Goodbye");
            	input.close();
                break;
            }

            switch (option) {
            case 1:        	
                System.out.print("Hotel Name: ");
                String hotelName = input.nextLine();

                System.out.print("Reservation Month: ");
                String reservationMonth = input.nextLine();
                
                int reservationStart = 0;
                while (reservationStart <= 0 || reservationStart > 30) {
                    System.out.print("Reservation Start (1-30): ");
                    reservationStart = input.nextInt();
                    if (reservationStart <= 0 || reservationStart > 30) {
                        System.out.println("Invalid start day. Please enter a day between 1-30.");
                    }
                }
              
                int reservationEnd = 0;
                while (reservationEnd <= 0 || reservationEnd > 30 || reservationEnd < reservationStart) {
                    System.out.print("Reservation End (" + reservationStart + "-30): ");
                    reservationEnd = input.nextInt();
                    if (reservationEnd <= 0 || reservationEnd > 30) {
                        System.out.println("Invalid end day. Please enter a day between " + reservationStart + "-30.");
                    } else if (reservationEnd < reservationStart) {
                        System.out.println("Invalid end day. End day must be greater than or equal to the start day.");
                    }
                }

                System.out.print("Daily Cost: ");
                int dailyCost = input.nextInt();
                
                    Reservation reservation = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, dailyCost);                  
                    reserved.reservedList[reserved.getNumReservations()] = reservation;                 
                    reserved.numReservations++;
                    System.out.println("Reservation created!");
                    break;
                    
                case 2:
                    reserved.displayReservations();
                    break;
                    
                default:
                    System.out.println("Invalid input.");
            }
        } 
    }
}

