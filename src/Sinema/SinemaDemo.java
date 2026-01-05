package Sinema;

public class SinemaDemo {

    public static void main(String[] args) {
        
        System.out.println("=== SİNEMA REZERVASYON SİSTEM DEMOSU ===\n");

        // Film oluşturma (Polymorphism)
        Movie movie = new Movie3D("Avatar", 150, 100, 30);
        System.out.println("Film oluşturuldu: " + movie.toString());

        // Seans oluşturma
        ShowTime showTime = new ShowTime(movie, "20.01.2026 18:00");
        System.out.println("Seans oluşturuldu: " + showTime.toString());
        System.out.println();

        // Müşteri oluşturma
        Customer customer = new Customer("Ali Demir", "ali@mail.com");
        System.out.println("Müşteri oluşturuldu: " + customer.toString());
        System.out.println();

        // Koltuk durumunu göster
        showTime.showSeatMap();
        System.out.println();

        // Boş koltuk seçimi
        if (showTime.getAvailableSeats().isEmpty()) {
            System.out.println("Üzgünüz, boş koltuk kalmadı!");
            return;
        }
        
        Seat seat = showTime.getAvailableSeats().get(0);
        System.out.println("Seçilen koltuk: " + seat.toString());
        System.out.println();

        // Rezervasyon oluşturma ve onaylama
        Booking booking = new Booking(customer, showTime, seat);
        
        if (booking.confirmBooking()) {
            System.out.println("\n=== REZERVASYON BAŞARILI! ===");
            System.out.println("Film: " + movie.getTitle());
            System.out.println("Fiyat: " + movie.getPrice() + " TL");
            System.out.println("Seans: " + showTime.getDateTime());
            System.out.println("Koltuk No: " + seat.getSeatNumber());
            System.out.println("Müşteri: " + customer.getName());
            System.out.println("Rezervasyon ID: " + booking.getBookingId());
        }
        System.out.println();

        // Güncellenmiş koltuk haritası
        showTime.showSeatMap();
        System.out.println();

        // Müşteri rezervasyon geçmişi
        customer.showBookingHistory();
    }
}