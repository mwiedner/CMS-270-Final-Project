// Whenever you make a sizeable edit to the project, commit and push the change to GitHub via the version control tab on the left.
// Also may not be a bad idea to make a manual copy as well. I don't have full confidence in Repl.

// Try your best to be rigorous with comments. It'll make it easier for others to follow your code and contribute
import java.util.ArrayList;

public class Room {
  private int roomNumber;
  private ArrayList<Student> roommates;
  private Residency residency;

  public Room(String rn, ArrayList<Student> s, Residency r) {
    roomNumber = rn;
    roommates = s;
    residency = r;
  }

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


  public void addStudent(Student s) {
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