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
    private static int daysPassed = 0;

    // Object instantiation methods
    public static void makeStudent(String n, String r, int i, boolean t, int q, Room ro, ArrayList<Course> reg) {
        students.add(new Student(n, r, i, t, q, ro, reg));
    }

    public static void makeCourse(String c, ArrayList<Student> t, ArrayList<Student> f, boolean i) {
        courses.add(new Course(c, t, f, i));
    }

    public static void makeResidency(String d, ArrayList<Room> r, ArrayList<Student> res) {
        residencies.add(new Residency(d, r, res));
    }

    // Methods
    public void dayCounter(Student s){ // Method that shows how many days Student s has left in quarantine or isolation
        if ((s.getQuarantineStatus() == 0) && (s.getIsolationStatus() == 0)) { // If both Isolation Status and Quarantine Status are zero, then they are not in quarantine or isolation
            System.out.println(s.getStudentName() + " is not in quarantine or isolation.");
        }
        else if (s.getIsolationStatus() != 0) { // If Isolation Status is nonzero, then they are in isolation.
            System.out.println(s.getStudentName() + " is in isolation for " + s.getIsolationStatus() + " more day(s).");
        }
        else { // If none of the above are true, then they are in quarantine.
            System.out.println(s.getStudentName() + " is in quarantine for " + s.getQuarantineStatus() + " more day(s).");
        }
    }

    public static void dayPassed() { // Method for keeping track of passing days and updating quarantine and isolation times
        daysPassed++;

        for (int i = 0; i < students.size(); i++) { // Loop through all Students
            if (students.get(i).getQuarantineStatus() != 0) { // If a student's quarantine status is nonzero,
                students.get(i).setQuarantineStatus(students.get(i).getQuarantineStatus() - 1); // then reduce their quarantine status by one
            }
            else if (students.get(i).getIsolationStatus() != 0) { // If a student's isolation status is nonzero,
                students.get(i).setIsolationStatus(students.get(i).getIsolationStatus() - 1); // then reduce their isolation status by one
            }
        }
    }

    public static Student studentFromR(String rNumber) { // Method for getting a Student object based on their rNumber
        for (int i = 0; i < students.size(); i++) { // Loop through all Students and check if there is a match with the rNumber.
            if (rNumber.equals(students.get(i).getrNumber())) { // If there's a match, return that Student
                    return students.get(i);
            }
        }

        // The following will only execute if there is no matching Student found with the given R-Number
        System.out.println("There is no student in our directory with the R-Number " + rNumber);
        return null; // If none is found, return null
    }


    public static void displayDatabase() { // Method that prints all of the data members above as well as a few percentages computed from the given information
        System.out.println("Total students: " + numStudents +
                "\nTotal courses: " + numCourses +
                "\nTotal residencies " + numResidencies +
                "\nTotal rooms: " + numRooms +
                "\nTotal positive cases: " + numPositiveCases +
                "\nTotal tests administered: " + numTestsAdministered +
                "\nTotal negative tests: " + numNegativeTests +
                "\nPercentage of students tested positive: " + (numPositiveCases/numStudents*100) + "%" +
                "\nPercentage of tests resulting negative: " + (numNegativeTests/numTestsAdministered*100) + "%");
    }


    public static void main(String[] args) {

    }

}