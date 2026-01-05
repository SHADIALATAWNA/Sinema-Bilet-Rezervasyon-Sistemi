package Sinema;

public class Booking {

    private Customer customer;
    private ShowTime showTime;
    private Seat seat;
    private double totalPrice;
    private String bookingId;
    private static int bookingCounter = 1;

    /**
     * Rezervasyon oluşturucu
     * @param customer Müşteri
     * @param showTime Seans
     * @param seat Koltuk
     */
    public Booking(Customer customer, ShowTime showTime, Seat seat) {
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;
        this.totalPrice = showTime.getMovie().getPrice();
        this.bookingId = "B" + String.format("%04d", bookingCounter++);
    }

    /**
     * Rezervasyonu onaylar
     * @return onay başarılı ise true
     */
    public boolean confirmBooking() {
        if (seat.book()) {
            customer.addBooking(this);
            System.out.println("Rezervasyon onaylandı! Rezervasyon ID: " + bookingId);
            return true;
        }
        System.out.println("Rezervasyon onaylanamadı!");
        return false;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public Seat getSeat() {
        return seat;
    }
    
    public String getBookingId() {
        return bookingId;
    }
    
    /**
     * Rezervasyon bilgilerini string olarak döndürür
     * @return rezervasyon bilgisi
     */
    @Override
    public String toString() {
        return bookingId + " - " + showTime.getMovie().getTitle() + 
               " | " + showTime.getDateTime() + 
               " | Koltuk: " + seat.getSeatNumber() + 
               " | Fiyat: " + totalPrice + " TL";
    }
}