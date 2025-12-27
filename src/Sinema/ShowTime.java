package Sinema;

import java.util.ArrayList;
import java.util.List;

public class ShowTime {

    private Movie movie;
    private String dateTime;
    private List<Seat> seats;

    public ShowTime(Movie movie, String dateTime, int seatCount) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= seatCount; i++) {
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
}
