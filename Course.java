import java.util.ArrayList;

public class Course {

    // Data Members
    private String courseName;
    private ArrayList<Student> students = new ArrayList<Student>();
    private boolean inPerson;

    // Constructor
    public Course(String c, boolean i) {
        courseName = c;
        inPerson = i;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> totalStudents) {
        this.students = totalStudents;
    }

    public boolean isInPerson() {
        return inPerson;
    }

    public void setInPerson(boolean inPerson) {
        this.inPerson = inPerson;
    }

    // Methods

    public void removeStudent(Student s) { // Remove a student from the totalStudents ArrayList
        students.remove(s);
    }
    
    public void addStudent(Student s) { // Remove a student from the totalStudents ArrayList
        students.add(s);
    }

    public void contactStudent() { // Loop through all students and move them to quarantine
        for(int i = 0; i < students.size(); i++) {
            students.get(i).startQuarantine();
        }
    }
}