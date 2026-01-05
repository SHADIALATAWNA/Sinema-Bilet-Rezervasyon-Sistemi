package Sinema;

public class Movie {
    protected String title;
    protected int duration; // dakika cinsinden
    protected double basePrice;

    /**
     * Film oluşturucu
     * @param title Film başlığı
     * @param duration Süre (dakika)
     * @param basePrice Temel fiyat
     */
    public Movie(String title, int duration, double basePrice) {
        this.title = title;
        this.duration = duration;
        this.basePrice = basePrice;
    }

    /**
     * Film fiyatını hesaplar
     * @return film fiyatı
     */
    public double getPrice() {
        return basePrice;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
    
    /**
     * Film bilgilerini string olarak döndürür
     * @return film bilgisi
     */
    @Override
    public String toString() {
        return title + " (" + duration + " dakika)";
    }
}