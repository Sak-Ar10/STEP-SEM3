public class CineScreen {

    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (this.seatsAvailable > 0) {
            this.seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (this.seatsAvailable < this.seatsTotal) {
            this.seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return this.seatsAvailable;
    }

    public static void main(String[] args) {
        try {
            new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        CineScreen c = new CineScreen(2);
        c.bookSeat(); 
        c.bookSeat(); 
        c.bookSeat();
        System.out.println(c.getSeatsAvailable());

        c.cancelBooking(); 
        c.cancelBooking(); 
        c.cancelBooking();
        System.out.println(c.getSeatsAvailable());
    }
}