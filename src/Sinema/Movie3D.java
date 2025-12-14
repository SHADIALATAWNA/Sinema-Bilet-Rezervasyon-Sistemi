package Sinema;

public class Movie3D extends Movie {

    private double extraFee;

    public Movie3D(String title, int duration, double basePrice, double extraFee) {
        super(title, duration, basePrice);
        this.extraFee = extraFee;
    }

    @Override
    public double getPrice() {
        return basePrice + extraFee;
    }
}