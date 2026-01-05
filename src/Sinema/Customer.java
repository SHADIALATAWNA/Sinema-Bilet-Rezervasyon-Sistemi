package Sinema;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String email;
    private List<Booking> bookingHistory;

    /**
     * Müşteri oluşturucu
     * @param name Müşteri adı
     * @param email Müşteri email
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }

    /**
     * Rezervasyon ekler
     * @param booking Rezervasyon nesnesi
     */
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
        System.out.println(name + " için yeni rezervasyon eklendi.");
    }
    
    /**
     * Rezervasyon iptal eder
     * @param booking İptal edilecek rezervasyon
     * @return iptal başarılı ise true
     */
    public boolean cancelBooking(Booking booking) {
        if (bookingHistory.contains(booking)) {
            if (booking.getSeat().cancelBooking()) {
                bookingHistory.remove(booking);
                System.out.println(name + " için rezervasyon iptal edildi.");
                return true;
            }
        }
        System.out.println("Rezervasyon bulunamadı veya iptal edilemedi.");
        return false;
    }

    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    /**
     * Müşteri rezervasyon geçmişini gösterir
     */
    public void showBookingHistory() {
        System.out.println("\n=== " + name + " Rezervasyon Geçmişi ===");
        
        if (bookingHistory.isEmpty()) {
            System.out.println("Henüz rezervasyonunuz bulunmuyor.");
        } else {
            for (int i = 0; i < bookingHistory.size(); i++) {
                Booking booking = bookingHistory.get(i);
                System.out.println((i+1) + ". " + booking.toString());
            }
        }
    }
    
    /**
     * Müşteri bilgilerini string olarak döndürür
     * @return müşteri bilgisi
     */
    @Override
    public String toString() {
        return name + " (" + email + ") - Toplam Rezervasyon: " + bookingHistory.size();
    }
}