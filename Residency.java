import java.util.ArrayList;

public class Residency {

    // Data members
    private String dormName;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Student> residents = new ArrayList<Student>();

    // Constructor
    public Residency(String d, ArrayList<Room> r, ArrayList<Student> res) {
        dormName = d;
        rooms = r;
        residents = res;
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


    public ArrayList<Student> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<Student> residents) {
        this.residents = residents;
    }

    // Method to add a room to the ArrayList rooms
    public void addRoom(Room r) {
        rooms.add(r);
    }

}