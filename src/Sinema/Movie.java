package Sinema;

public class Movie {
    protected String title;
    protected int duration; // dakika
    protected double basePrice;

    public Movie(String title, int duration, double basePrice) {
        this.title = title;
        this.duration = duration;
        this.basePrice = basePrice;
    }

    public double getPrice() {
        return basePrice;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
