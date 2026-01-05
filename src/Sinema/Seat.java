package Sinema;

public class Seat implements Bookable {

    private int seatNumber;
    private boolean reserved;

    /**
     * Koltuk oluşturucu
     * @param seatNumber Koltuk numarası
     */
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    /**
     * Koltuk rezerve edilmiş mi kontrol eder
     * @return rezerve edilmişse true
     */
    public boolean isReserved() {
        return reserved;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Koltuk rezervasyonu yapar
     * @return rezervasyon başarılı ise true
     */
    @Override
    public boolean book() {
        if (!reserved) {
            reserved = true;
            System.out.println(seatNumber + " numaralı koltuk rezerve edildi.");
            return true;
        }
        System.out.println(seatNumber + " numaralı koltuk zaten dolu!");
        return false;
    }
    
    /**
     * Rezervasyonu iptal eder
     * @return iptal başarılı ise true
     */
    @Override
    public boolean cancelBooking() {
        if (reserved) {
            reserved = false;
            System.out.println(seatNumber + " numaralı koltuğun rezervasyonu iptal edildi.");
            return true;
        }
        System.out.println(seatNumber + " numaralı koltuk zaten boş!");
        return false;
    }
    
    /**
     * Koltuk durumunu string olarak döndürür
     * @return koltuk bilgisi
     */
    @Override
    public String toString() {
        return "Koltuk " + seatNumber + " - " + (reserved ? "Dolu" : "Boş");
    }
}