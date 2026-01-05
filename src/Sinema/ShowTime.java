package Sinema;

import java.util.ArrayList;
import java.util.List;

public class ShowTime {

    private Movie movie;
    private String dateTime;
    private List<Seat> seats;

    /**
     * Seans oluşturucu
     * @param movie Film
     * @param dateTime Tarih ve saat
     */
    public ShowTime(Movie movie, String dateTime) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.seats = new ArrayList<>();

        // 10 koltuk oluştur (1-10)
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDateTime() {
        return dateTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
    
    /**
     * Boş koltukları getirir
     * @return boş koltuk listesi
     */
    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();

        for (Seat seat : seats) {
            if (!seat.isReserved()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
    
    /**
     * Dolu koltukları getirir
     * @return dolu koltuk listesi
     */
    public List<Seat> getReservedSeats() {
        List<Seat> reservedSeats = new ArrayList<>();

        for (Seat seat : seats) {
            if (seat.isReserved()) {
                reservedSeats.add(seat);
            }
        }
        return reservedSeats;
    }
    
    /**
     * Seans bilgilerini gösterir
     */
    public void showSeatMap() {
        System.out.println("\n=== " + movie.getTitle() + " - " + dateTime + " ===");
        System.out.println("KOLTUK DURUMU:");
        
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seats.get(i);
            System.out.print("[" + seat.getSeatNumber() + ":" + (seat.isReserved() ? "X" : "O") + "] ");
            
            // Her 5 koltukta bir alt satıra geç
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n(O: Boş, X: Dolu)");
        System.out.println("Boş koltuk: " + getAvailableSeats().size() + " | Dolu koltuk: " + getReservedSeats().size());
    }
    
    /**
     * Seans bilgilerini string olarak döndürür
     * @return seans bilgisi
     */
    @Override
    public String toString() {
        return movie.getTitle() + " - " + dateTime + " - Fiyat: " + movie.getPrice() + " TL";
    }
}