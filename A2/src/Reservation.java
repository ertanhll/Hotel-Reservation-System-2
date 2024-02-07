

public class Reservation {
    private String hotelName;
    private String reservationMonth;
    private int reservationStart;
    private int reservationEnd;
    private int dailyCost;
    
    public Reservation(String hotelName, String reservationMonth, int reservationStart, int reservationEnd, int dailyCost) {
        setHotelName(hotelName);
        setReservationMonth(reservationMonth);
        setReservationStart(reservationStart);
        setReservationEnd(reservationEnd);
        setDailyCost(dailyCost);
    }
    
    public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public void setReservationMonth(String reservationMonth) {
		this.reservationMonth = reservationMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(int reservationStart) {
		this.reservationStart = reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(int reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dailyCost) {
		this.dailyCost = dailyCost;
	}

	public int calculateTotalPrice() {
        int days = reservationEnd - reservationStart + 1;
        int totalPrice = days * dailyCost;
        return totalPrice;
    }
    
    public void displayInfo() {
        int totalPrice = calculateTotalPrice();
        System.out.printf("Reservation for %s starts on %s %d and ends on %s %d. Reservation has a total cost of $%d.\n", 
                getHotelName(), getReservationMonth(), getReservationStart(), getReservationMonth(), getReservationEnd(), totalPrice);
    }
}
