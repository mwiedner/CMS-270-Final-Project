// Whenever you make a sizeable edit to the project, commit and push the change to GitHub via the version control tab on the left.
// Also may not be a bad idea to make a manual copy as well. I don't have full confidence in Repl.

// Try your best to be rigorous with comments. It'll make it easier for others to follow your code and contribute
import java.util.ArrayList;

public class Student {

  // Data members
  private String studentName;
  private String rNumber;
  private String isolationStatus;
  private boolean testResult;
  private boolean quarantineStatus;
  private Room room;
  private ArrayList<Course> registeredCourses = new ArrayList<Course>(); 

  // Constructor
  public Student(String n, String r, String i, boolean t, boolean q, Room ro, ArrayList<Course> reg) {
    studentName = n;
    rNumber = r;
    isolationStatus = i;
    testResult = t;
    quarantineStatus = q;
    room = ro;
    registeredCourses = reg;
  }
  
  // Getters and setters
  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

    
  public String getrNumber() {
    return rNumber;
  }

  public void setrNumber(String rNumber) {
    this.rNumber = rNumber;
  }

    
  public String getIsolationStatus() {
    return isolationStatus;
  }

  public void setIsolationStatus(String isolationStatus) {
    this.isolationStatus = isolationStatus;
  }

    
  public boolean isTestResult() {
    return testResult;
  }

  public void setTestResult(boolean testResult) {
    this.testResult = testResult;
  }

    
  public boolean isQuarantineStatus() {
    return quarantineStatus;
  }

  public void setQuarantineStatus(boolean quarantineStatus) {
    this.quarantineStatus = quarantineStatus;
  }

    
  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

    
  public ArrayList<Course> getRegisteredCourses() {
    return registeredCourses;
  }

  public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
    this.registeredCourses = registeredCourses;
  }


public void notifyContacts() {

}

public void startQuarantine() {

}

public void startIsolation() {

}

public void closeContactPrompt(String rNumber) {

}

public ArrayList<Student> (String sn, String rn, Boolean tr) {

}
}