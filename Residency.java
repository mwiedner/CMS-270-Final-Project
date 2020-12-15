import java.util.ArrayList;

public class Residency {

    // Data members
    private String dormName;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    // Constructor
    public Residency(String d) {
        dormName = d;
    }

    // Getters and setters
    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }


    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    // Method to add a room to the ArrayList rooms
    public void addRoom(Room r) {
        rooms.add(r);
    }

}