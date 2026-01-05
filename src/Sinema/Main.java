package Sinema;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("=== SİNEMA REZERVASYON SİSTEMİ ===\n");

        // Film oluşturma (Polymorphism)
        Movie movie3D = new Movie3D("Avatar: Suyun Yolu", 192, 120, 35);
        Movie movie2D = new Movie2D("Yıldızlararası", 169, 80);
        
        System.out.println("Mevcut Filmler:");
        System.out.println("1. " + movie3D.toString());
        System.out.println("2. " + movie2D.toString());
        System.out.println();

        // Seans oluşturma
        ShowTime showTime1 = new ShowTime(movie3D, "20.01.2026 18:00");
        ShowTime showTime2 = new ShowTime(movie3D, "20.01.2026 21:00");
        
        System.out.println("Mevcut Seanslar:");
        System.out.println("1. " + showTime1.toString());
        System.out.println("2. " + showTime2.toString());
        System.out.println();

        // Müşteri oluşturma
        Customer customer = new Customer("Ahmet Yılmaz", "ahmet@email.com");
        System.out.println("Müşteri: " + customer.toString());
        System.out.println();

        // Koltuk haritasını göster
        showTime1.showSeatMap();
        System.out.println();

        // Boş koltuk seçimi
        Seat selectedSeat = showTime1.getAvailableSeats().get(2); // 3. boş koltuk
        System.out.println("Seçilen koltuk: " + selectedSeat.toString());
        System.out.println();

        // Rezervasyon oluşturma ve onaylama
        Booking booking = new Booking(customer, showTime1, selectedSeat);
        
        if (booking.confirmBooking()) {
            System.out.println("\n=== REZERVASYON DETAYLARI ===");
            System.out.println("Film: " + movie3D.getTitle());
            System.out.println("Seans: " + showTime1.getDateTime());
            System.out.println("Koltuk No: " + selectedSeat.getSeatNumber());
            System.out.println("Fiyat: " + booking.getTotalPrice() + " TL");
            System.out.println("Rezervasyon ID: " + booking.getBookingId());
            System.out.println("Müşteri: " + customer.getName());
        } else {
            System.out.println("Rezervasyon başarısız!");
        }
        System.out.println();

        // Güncellenmiş koltuk haritası
        showTime1.showSeatMap();
        System.out.println();

        // Müşteri rezervasyon geçmişi
        customer.showBookingHistory();
        
        // Ekstra test: Rezervasyon iptali
        System.out.println("\n=== REZERVASYON İPTALİ TESTİ ===");
        customer.cancelBooking(booking);
        showTime1.showSeatMap();
        customer.showBookingHistory();
    }
}