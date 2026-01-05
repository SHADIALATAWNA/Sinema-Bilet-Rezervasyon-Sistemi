package Sinema;

public interface Bookable {
    /**
     * Koltuk rezervasyonu yapar.
     * @return rezervasyon başarılı ise true, aksi halde false
     */
    boolean book();
    
    /**
     * Rezervasyonu iptal eder.
     * @return iptal başarılı ise true, aksi halde false
     */
    boolean cancelBooking();
}