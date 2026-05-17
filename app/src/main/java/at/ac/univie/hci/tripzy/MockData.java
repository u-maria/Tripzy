package at.ac.univie.hci.tripzy;
//that is mockup data class with saved trips and also user information
public class MockData {
    public static Trip grazTrip = new Trip(
            "Graz",
            "15-17 May",
            "Bus",
            "from EUR 12",
            "3h 10m"
    );

    public static Trip pragueTrip =new Trip(
            "Prague",
            "Weekend",
            "Train",
            "from EUR 29",
            "4h 10m"
    );

    public static Trip salzburgTrip= new Trip(
            "Salzburg",
            "Next week",
            "Train",
            "from EUR 19",
            "2h 30m"
    );

    public static String userName="Max Mustermann";
    public static String homeCity="Vienna";
    public static String prefferedTransport="Train and bus";
    public static String travelStyle ="Budget and boutique";
}
