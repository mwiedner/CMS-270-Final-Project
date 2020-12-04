import java.util.ArrayList;

public class Main {

    // Data members
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private static ArrayList<Residency> residencies = new ArrayList<Residency>();
    private static ArrayList<Room> allRooms = new ArrayList<Room>();

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

    public static void makeRoom(int rn, ArrayList<Student> s, Residency res) {
        allRooms.add(new Room(rn, s, res));
        res.addRoom(allRooms.get(allRooms.size() - 1)); // Use the addRoom method in Residency to add the new room to the given residency. The parameter of the addRoom method is the last method added to the allRooms ArrayList, which is the room at the index allRooms.size() - 1.
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
        daysPassed++; // Increase daysPassed by one

        for (int i = 0; i < students.size(); i++) { // Loop through all Students
            if (students.get(i).getQuarantineStatus() != 0) { // If a student's quarantine status is nonzero,
                students.get(i).setQuarantineStatus(students.get(i).getQuarantineStatus() - 1); // then reduce their quarantine status by one

                if (students.get(i).getQuarantineStatus() == 0) { // If the student's quarantine status is now zero,
                    removeQuarantined(students.get(i)); // Then remove them from the total quarantined students ArrayList
                }
            }

            else if (students.get(i).getIsolationStatus() != 0) { // If a student's isolation status is nonzero,
                students.get(i).setIsolationStatus(students.get(i).getIsolationStatus() - 1); // then reduce their isolation status by one

                if (students.get(i).getIsolationStatus() == 0) { // If the student's isolation status is now zero,
                    removeIsolated(students.get(i)); // Then remove them from the total isolated students ArrayList
                }
            }
        }
    }

    // Method for getting a Student object based on their rNumber
    public static Student studentFromR(String rNumber) {
        for (int i = 0; i < students.size(); i++) { // Loop through all Students and check if there is a match with the rNumber.
            if (rNumber.equals(students.get(i).getrNumber())) { // If there's a match, return that Student
                    return students.get(i);
            }
        }

        // The following will only execute if there is no matching Student found with the given R-Number
        System.out.println("There is no student in our directory with the R-Number " + rNumber);
        return null; // If none is found, return null
    }

    // Method that prints all of the data members above as well as a few percentages computed from the given information
    public static void displayDatabase() {
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

    // Methods for adding and removing students from the respective total isolated and total quarantined ArrayLists
    public static void addIsolated(Student s) {
        isolatedStudents.add(s);
    }
    public static void removeIsolated(Student s) {
        isolatedStudents.remove(s);
    }
    public static void addQuarantined(Student s) {
        quarantinedStudents.add(s);
    }
    public static void removeQuarantined(Student s) {
        quarantinedStudents.remove(s);
    }


    public static void main(String[] args) {

    }

}