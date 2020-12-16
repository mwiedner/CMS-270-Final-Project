import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
    private static int numPositiveCases = 0;

    private static int daysPassed = 0;

    // These two methods must be public to allow the test() method of Student.java to increase the figures.
    public static int numTestsAdministered = 0;
    public static int numNegativeTests = 0;

    // Methods
    public static void dayCounter(){ // Method that shows how many days Student s has left in quarantine or isolation
        if ((s.getQuarantineStatus() == 0) && (s.getIsolationStatus() == 0)) { // If both Isolation Status and Quarantine Status are zero, then they are not in quarantine or isolation
            System.out.println(s.getStudentName() + " is not in quarantine or isolation.");
        }
        else if (s.getIsolationStatus() != 0) { // If Isolation Status is nonzero, then they are in isolation.
          int days = s.getIsolationStatus() - x;
          System.out.println(s.getStudentName() + " is in isolation for " + days + " more day(s).");
        }
        else { // If none of the above are true, then they are in quarantine.
            System.out.println(s.getStudentName() + " is in quarantine for " + daysQ + " more day(s).");
        }
    }

    public static void dayPassed(int x) { // Method for keeping track of passing days and updating quarantine and isolation times
        for (int i = 0; i < students.size(); i++) { // Loop through all Students
            if (students.get(i).getQuarantineStatus() != 0) { // If a student's quarantine status is nonzero,
                students.get(i).setQuarantineStatus(students.get(i).getQuarantineStatus() - x); // then reduce their quarantine status by one

                if (students.get(i).getQuarantineStatus() == 0) { // If the student's quarantine status is now zero,
                    removeQuarantined(students.get(i)); // Then remove them from the total quarantined students ArrayList
                }   
            }

            else if (students.get(i).getIsolationStatus() != 0) { // If a student's isolation status is nonzero,
                students.get(i).setIsolationStatus(students.get(i).getIsolationStatus() - x); // then reduce their isolation status by one

                if (students.get(i).getIsolationStatus() == 0) { // If the student's isolation status is now zero,
                    removeIsolated(students.get(i)); // Then remove them from the total isolated students ArrayList
                }
            }
        }
    }

    public void changeRoom(String rNumber, String building, int room ){
      studentFromR(rNumber).getRoom().removeStudent(studentFromR(rNumber)); // Remove the Student from the roommates ArrayList of their old room
     for (int i = 0; i < residencies.size(); i++) {
       if (residencies.get(i).getDormName().equals(building)) {
         for (int j = 0; j < residencies.get(i).getRooms.size(); j++) {
           if (residencies.get(i).getRooms().get(j).getRoomNumber() == room) {
             studentFromR(rNumber).setRoom(residencies.get(i).getRooms().get(j)); // Set the Student's room as the correct new room
             residencies.get(i).getRooms().get(j).addStudent(studentFromR(rNumber)); // Add Student to the list of roommates in the new room
           }
         }
       }
     }
    }

    public void dropCourse(String rNumber, String course){
      for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getCourseName().equals(course)) {
          courses.get(i).removeStudent(studentFromR(rNumber)); // Removes Student from the course roster
          studentFromR(rNumber).removeCourse(courses.get(i)); // Remove the course from the Student's registeredCourses ArrayList<Course>
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

    // Method for updating the information needed for the database
    public static void updateInfo() {
      numStudents = students.size();
      numCourses = courses.size();
      numResidencies = residencies.size();
      numRooms = allRooms.size();
      numPositiveCases = quarantinedStudents.size();
    }

    // Method that prints all of the data members above as well as a few percentages computed from the given information
    public static void displayDatabase() {
      updateInfo();
      System.out.println("Total students: " + numStudents +
        "\nTotal courses: " + numCourses +
        "\nTotal residencies " + numResidencies +
        "\nTotal rooms: " + numRooms +
        "\nTotal positive cases: " + numPositiveCases +
        "\nTotal tests administered: " + numTestsAdministered +
        "\nTotal negative tests: " + numNegativeTests +
        "\nPercentage of students tested positive: " + (numPositiveCases/numStudents*100) + "%\nPercentage of tests resulting negative: " + (numNegativeTests/numTestsAdministered*100) + "%");
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

    // Method for welcoming a user and processing their requests
    public static void welcome() {
      System.out.println("Would you like to\n[1.] View COVID statistics\n[2.] Input COVID test results\n[3.] Check the status of a student\n[4.] Exit the application\n\nPlease type the number corresponding to your request below.");
      Scanner scanner = new Scanner(System.in);
      boolean running = true;
      while (running) {
        if (scanner.nextInt() == 1) {
          displayDatabase();
          cont();
          running = false;
        }
        else if (scanner.nextInt() == 2) {
          System.out.println("Please enter your R-Number:");
          String rNum = scanner.nextLine();
          System.out.println("Have you tested [1.] positive or [2.] negative?\nPlease type the number corresponding to your result below.");
          Student user = studentFromR(rNum);
          if (scanner.nextInt() == 1) {
            user.test(true);
          }
          else if (scanner.nextInt() == 2) {
            user.test(false);
          }
          else {
            System.out.println("That is an invalid input. Please try again.");
          }
          cont();
          running = false;
        }
        else if (scanner.nextInt() == 3) {
          System.out.println("Please enter the R-Number of the student:");
          String rNum = scanner.nextLine();
          Student subject = studentFromR(rNum);
          dayCounter(subject);
          cont();
          running = false;
        }
        else if (scanner.nextInt() == 4) {
          System.out.println("Thank you for using the COVID-19 Contact Tracing Application. Have a nice day.");
          running = false;
        }
        else {
          System.out.println("That is an invalid input. Please try again.");
        }
      }
    }

    public static void cont() { // Method for asking the user if they wish to continue using the application, or if they wish to exit. 
      System.out.println("\nThank you for using the COVID-19 Contact Tracing Application. Would you like to [1.] use a different feature or [2.] exit the application?\nPlease type the number corresponding to your request below."); // Prompt the user for input
      Scanner scanner = new Scanner(System.in); // Scanner to read input
      boolean prompting = true; // Boolean for using the loop
      while (prompting) { // Loop to read the user input
        if (scanner.nextInt() == 1) {
          welcome(); // If the user inputs 1, run welcome() again
        }
        else if (scanner.nextInt() == 2) {
          System.out.println("Have a nice day.");
          prompting = false; // If the user inputs 2, exit the application by not running welcome() again. The welcome() method is set up such that it will exit the application if the user doesn't prompt for the welcome() method to be ran again. Every call to the cont() method is followed by running = false.
        }
        else { // Otherwise, prompt for input again for their input was invalid. 
          System.out.println("That is an invalid input. Please try again.");
        }
      }
    }

    public static void processData() {
      try {
        File file = new File("StudentData.txt");
        File d = new File("DayData.txt");
        Scanner scan = new Scanner(file);
        Scanner a = new Scanner(d);
        
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
          String input = scan.nextLine();
          String[] tokens = input.split(" ");
          
          boolean covidStatus;
          if (tokens[0].equals("P")) {
            covidStatus = true;
          } else {
            covidStatus = false;
          }
          String name = tokens[1] + " " + tokens[2];
          String rNumber = tokens[3];
          int numOfClasses = Integer.parseInt(tokens[4]);
          Student s = new Student(name, rNumber, covidStatus);
          for (int n = 0; n < numOfClasses; n++) { 
            if(tokens[5].equals(courses.get(n).getCourseName())) {
              courses.get(n).addStudent(s);
            }
          }
          int residencyStatus = Integer.parseInt(tokens[5 + numOfClasses]);
          String dormName;
          String dormNumber;
          int numOfRoommates;
          if (residencyStatus == 1) {
            dormName = tokens[6 + numOfClasses];
            dormNumber = tokens[7 + numOfClasses];
            numOfRoommates = Integer.parseInt(tokens[8 + numOfClasses]);
          }
          
          for (int n = 0; n < residencies.size(); n++) { 
            if(dormName.equals(residencies.get(n).getDormName())) {
              for (int m = 0; m < numOfClasses; m++) { 
                if(dormNumber.equals(courses.get(n).getCourseName())) {
                  courses.get(n).addStudent(s);
                }
              }
            }
          }
          System.out.println(covidStatus + " " + name + " " + rNumber + " " + numOfClasses + " "+ residencyStatus);
        }
        while(a.nextline){
          String line = a.nextLine();
          String [] token = line.split(" ");
          boolean covidStatus;
          if(token[0].equals("P")){
          covidStatus = true;
          updateInfo();
          }
          if(token[0].equals("DP")){
            daysPassed(token[1]);
            updateInfo();
          }
          if(token[0].equals("D")){
            String name = token[1] + " " + token[2];
            dropClass(name, token[3]);
        }
        if(token[0].equals("C")){
          String name = token[1] + " " + token[2];
          changeRoom(name,token[3], token[4]);
        } 
        if(token[0].equals("PD")){
          displayDatabase();
        }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }
		
    }
  }

    public static void makeCourses() {
    	courses.add(new Course("CMS230", false));
    	courses.add(new Course("CMS370", true));
    	courses.add(new Course("CMS167", true));
    	courses.add(new Course("CMS170", false));
    	courses.add(new Course("POL100", true));
    	courses.add(new Course("MAT100", false));
    	courses.add(new Course("RFLA200", true));
      numCourses += 7;
    }

    public static void makeResidencies() {
    	residencies.add(new Residency("Lakeside"));
    	residencies.add(new Residency("Sutton"));
      numResidencies += 2;
    }
    
    public static void makeRooms() {
      // 1 = Sutton
      // 2 = Lakeside
      Room room1 = new Room(215, residencies.get(1));
    	allRooms.add(room1);
    	allRooms.add(new Room(105, residencies.get(0)));
      numRooms += 2;
    }

    public static void main(String[] args) {
      makeCourses();
      makeResidencies();
      makeRooms();
      processStudentData();
      displayDatabase();
      System.out.println("Welcome to the COVID-19 Contact Tracing Application.\n");
      welcome();

    }

}