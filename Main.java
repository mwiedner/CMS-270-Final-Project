// This is the Driver class. Repl is dumb and forces it to be called Main.java

// Whenever you make a sizeable edit to the project, commit and push the change to GitHub via the version control tab on the left.
// Also may not be a bad idea to make a manual copy as well. I don't have full confidence in Repl.

// Try your best to be rigorous with comments. It'll make it easier for others to follow your code and contribute
import java.util.ArrayList;

public class Main {
  
  // Data members
  private static ArrayList<Student> students = new ArrayList<Student>();
  private static ArrayList<Course> courses = new ArrayList<Course>();
  private static ArrayList<Residency> residencies = new ArrayList<Residency>();

  private static ArrayList<Student> isolatedStudents = new ArrayList<Student>();
  private static ArrayList<Student> quarantinedStudents = new ArrayList<Student>();

  // These data members seem kinda weird
  private static int numStudents;
  private static int numCourses;
  private static int numResidencies;
  private static int numRooms;
  private static int numPositiveCases;
  private static int numTestsAdministered;
  private static int numNegativeTests;
  
  // Methods
  public static void displayDatabase() {
    System.out.println("Total students: " + numStudents + "\nTotal courses: " + numCourses + "\nTotal residencies " + numResidencies + "\nTotal rooms: " + numRooms + "\nTotal positive cases: " + numPositiveCases + "\nTotal tests administered: " + numTestsAdministered + "\nTotal negative tests: " + numNegativeTests + "\nPercentage of students tested positive: " + (numPositiveCases/numStudents*100) + "%" + "\nPercentage of tests resulting negative: " + (numNegativeTests/numTestsAdministered*100) + "%");
  }

  
  public static void main(String[] args) {
    
  }

}