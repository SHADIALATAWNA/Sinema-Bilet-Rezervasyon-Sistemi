package Sinema;

public class Movie3D extends Movie {

    private double extraFee; // 3D ekstra ücreti

    /**
     * 3D film oluşturucu
     * @param title Film başlığı
     * @param duration Süre (dakika)
     * @param basePrice Temel fiyat
     * @param extraFee 3D ekstra ücreti
     */
    public Movie3D(String title, int duration, double basePrice, double extraFee) {
        super(title, duration, basePrice);
        this.extraFee = extraFee;
    }

    /**
     * 3D film fiyatını hesaplar (temel fiyat + ekstra ücret)
     * @return toplam fiyat
     */
    @Override
    public double getPrice() {
        return basePrice + extraFee;
    }
    
    /**
     * 3D film bilgilerini döndürür
     * @return film tipi ve bilgileri
     */
    @Override
    public String toString() {
        return "[3D] " + super.toString() + " - Ekstra Ücret: " + extraFee + " TL";
    }
}