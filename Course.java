// Whenever you make a sizeable edit to the project, commit and push the change to GitHub via the version control tab on the left.
// Also may not be a bad idea to make a manual copy as well. I don't have full confidence in Repl.

// Try your best to be rigorous with comments. It'll make it easier for others to follow your code and contribute
import java.util.ArrayList;

public class Course {
  
  // Data Members
  private String courseName;
  private ArrayList<Student> totalStudents = new ArrayList<Student>();
  private ArrayList<Student> f2fStudents = new ArrayList<Student>();
  private boolean inPerson;

  // Constructor
  public Course(String c, ArrayList<Student> t, ArrayList<Student> f, boolean i) {
    courseName = c;
    totalStudents = t;
    f2fStudents = f;
    inPerson = i;
  }

  // Getters and Setters
    public String getCourseName() {
      return courseName;
    }

    public void setCourseName(String courseName) {
      this.courseName = courseName;
    }


    public ArrayList<Student> getTotalStudents() {
      return totalStudents;
    }

    public void setTotalStudents(ArrayList<Student> totalStudents) {
      this.totalStudents = totalStudents;
    }


    public ArrayList<Student> getF2fStudents() {
      return f2fStudents;
    }

    public void setF2fStudents(ArrayList<Student> f2fStudents) {
      this.f2fStudents = f2fStudents;
    }


    public boolean isInPerson() {
      return inPerson;
    }

    public void setInPerson(boolean inPerson) {
      this.inPerson = inPerson;
    }

    // Methods
    public void addF2F(Student s) { // Add a student to the face-to-face ArrayList
      f2fStudents.add(s);
    }

    public void removeF2F(Student s) { // Remove a student from the face-to-face ArrayList
      f2fStudents.remove(s);
    }

    public void removeTotalStudent(Student s) { // Remove a student from the totalStudents ArrayList
      totalStudents.remove(s);
    }

    public void contactF2F() { // Loop through all face-to-face students and move them to quarantine
      for(int i = 0; i < f2fStudents.size(); i++) {
        f2fStudents.get(i).startQuarantine();
      }
    }
}