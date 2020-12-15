import java.util.ArrayList;

public class Room {

    // Data Members
    private int roomNumber;
    private ArrayList<Student> roommates = new ArrayList<Student>();
    private Residency residency;

    // Constructor
    public Room(int rn, Residency r) {
        roomNumber = rn;
        residency = r;
    }

    // Getters and setters
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int rn) {
        roomNumber = rn;
    }


    public ArrayList<Student> getRoommates() {
        return roommates;
    }
    public void setRoommates(ArrayList<Student> r) {
        roommates = r;
    }


    public Residency getResidency() {
        return residency;
    }
    public void setResidency(Residency r) {
        residency = r;
    }

    // Methods
    public void addStudent(Student s) { // Method for adding a student to the roommates ArrayList, indicating that a student has moved in to a room.
        roommates.add(s);
    }

    public void removeStudent(Student s) {
        String studentName = s.getStudentName();
        for(int i = 0; i < roommates.size(); i++) {
            if (studentName.equals(roommates.get(i).getStudentName())) {
                roommates.remove(i);
            }
        }
    }
}