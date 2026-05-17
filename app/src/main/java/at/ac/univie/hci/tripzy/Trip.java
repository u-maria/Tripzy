package at.ac.univie.hci.tripzy;
// Pretend data about the trip
public class Trip {
    public String city;
    public String date;
    public String transport;
    public String price;
    public String duration;

    public Trip(String city, String date, String transport, String price, String duration) {
        this.city = city;
        this.date = date;
        this.transport = transport;
        this.price = price;
        this.duration = duration;
    }
}
