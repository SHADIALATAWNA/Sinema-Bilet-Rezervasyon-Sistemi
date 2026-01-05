package Sinema;

public class Movie2D extends Movie {

    /**
     * 2D film oluşturucu
     * @param title Film başlığı
     * @param duration Süre (dakika)
     * @param basePrice Temel fiyat
     */
    public Movie2D(String title, int duration, double basePrice) {
        super(title, duration, basePrice);
    }
    
    /**
     * 2D film bilgilerini döndürür
     * @return film tipi ve bilgileri
     */
    @Override
    public String toString() {
        return "[2D] " + super.toString();
    }
}