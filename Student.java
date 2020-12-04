import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    // Data members
    private String studentName;
    private String rNumber;
    private int isolationStatus; // Changed to an int to indicate the number of days left. 0 indicates not isolated
    private boolean testResult;
    private int quarantineStatus;// Changed to an int to indicate the number of days left. 0 indicates not quarantined
    private Room room;
    private ArrayList<Course> registeredCourses = new ArrayList<Course>();

    // Constructor
    public Student(String n, String r, int i, boolean t, int q, Room ro, ArrayList<Course> reg) {
        studentName = n;
        rNumber = r;
        isolationStatus = i;
        testResult = t;
        quarantineStatus = q;
        room = ro;
        registeredCourses = reg;
    }

    Scanner InputScan = new Scanner(System.in);

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


    public int getIsolationStatus() {
        return isolationStatus;
    }

    public void setIsolationStatus(int isolationStatus) {
        this.isolationStatus = isolationStatus;
    }


    public boolean getTestResult() {
        return testResult;
    }

    public void setTestResult(boolean testResult) {
        this.testResult = testResult;
    }


    public int getQuarantineStatus() {
        return quarantineStatus;
    }

    public void setQuarantineStatus(int quarantineStatus) {
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

    // Methods

    // Method to notify a student, prompting them to be tested and begin their isolation.
    public void notify(Student s) {
        System.out.println(s.getStudentName() + ", you must isolate and get tested.");
        s.startIsolation();
    }

    // Method for notifying a student's contacts (Roommates, face-to-face classmates, and outside contacts)
    public void notifyContacts(ArrayList<Student> outsideContacts) { // The parameter is an ArrayList of Students that are not either roommates or classmates, for those two groups are going to be accounted for regardless.
        ArrayList<Student> roommates = new ArrayList<Student>(); // ArrayList of the student's roommates
        roommates = room.getRoommates();

        for (int i = 0; i < roommates.size(); i++) { // Loop through all roommates and notify them
            notify(roommates.get(i));
        }

        for (int i = 0; i < registeredCourses.size(); i++) { // Loop through all registered courses and save the f2f classmates
            ArrayList<Student> f2fclassmates = new ArrayList<Student>();
            f2fclassmates = registeredCourses.get(i).getF2fStudents();

            for (int j = 0; j < f2fclassmates.size(); j++) { // Loop through the f2f classmates and notify them
                notify(f2fclassmates.get(j));
            }
        }

        for (int i = 0; i < outsideContacts.size(); i++) { // Loop through outsideContacts and notify each
            notify(outsideContacts.get(i));
        }

    }

    // Method for handling a COVID test
    public void test(boolean result) {
        setTestResult(result);

        if (result == true) { // If result is true, then they tested positive
            System.out.println(getStudentName() + " has tested positive.");
            startQuarantine();
            notifyContacts(closeContactPrompt());
        }
        else if (result == false) {
            System.out.println(getStudentName() + " has tested negative.");
        }
    }

    // Method for initiating quarantine
    public void startQuarantine() {
        setIsolationStatus(0); // Remove their isolation status to replace it with a quarantine status
        setQuarantineStatus(14); // Start 14 day quarantine
        System.out.println(getStudentName() + " has begun quarantine.");
        Main.addQuarantined(Main.studentFromR(getrNumber())); // Add the student to the Quarantined Students ArrayList. Make use of the studentFromR method to get the proper Student object
    }

    // Method for initiating isolation
    public void startIsolation() {
        setIsolationStatus(14); // Start 14 day isolation
        System.out.println(getStudentName() + " has begun isolation.");
        Main.addIsolated(Main.studentFromR(getrNumber())); // Add the student to the Quarantined Students ArrayList. Make use of the studentFromR method to get the proper Student object
    }

    // Method for prompting a Student to input the R-Numbers of their close contacts that aren't in their face-to-face classes or roommates.
    public ArrayList<Student> closeContactPrompt() {
        ArrayList<String> rNumbers = new ArrayList<String>(); // ArrayList to hold the rNumbers the student inputs
        ArrayList<Student> outsideContacts = new ArrayList<Student>(); // Arraylist to hold the students that the given student is within close contact of.

        System.out.println("Please input the rNumber of your close contacts and type \"Done\" when finished");
        while (!(InputScan.nextLine().equals("Done"))) { // While loop when the input is not "Done"
            rNumbers.add(InputScan.nextLine()); // Save the inputted string into the ArrayList
        }

        for (int i = 0; i < rNumbers.size(); i++) { // Loop through all inputted rNumbers and add the corresponding Student objects to the outsideContacts ArrayList via the studentFromRNumber method.
            if (Main.studentFromR(rNumbers.get(i)) != null) {
                outsideContacts.add(Main.studentFromR(rNumbers.get(i)));
            }
        }
        return outsideContacts;
    }
}