// Whenever you make a sizeable edit to the project, commit and push the change to GitHub via the version control tab on the left.
// Also may not be a bad idea to make a manual copy as well. I don't have full confidence in Repl.

// Try your best to be rigorous with comments. It'll make it easier for others to follow your code and contribute
import java.util.ArrayList;

public class Residency {

  // Data members
  private String dormName;
  private ArrayList<Room> rooms;
  private ArrayList<Student> residents;

  // Constructor
  public Residency(String d, ArrayList<Room> r, ArrayList<Student> res) {
    dormName = d;
    rooms = r;
    residents = r;
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
    this.students = students;
  } 
}