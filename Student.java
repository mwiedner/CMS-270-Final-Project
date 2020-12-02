// Whenever you make a sizeable edit to the project, commit and push the change to GitHub via the version control tab on the left.
// Also may not be a bad idea to make a manual copy as well. I don't have full confidence in Repl.

// Try your best to be rigorous with comments. It'll make it easier for others to follow your code and contribute
public class Student{
  private String studentName;
  private String rNumber;
  private String isolationStatus;
  private boolean testResult;
  private boolean quarantineStatus;
  private Room room;
  private ArrayList<Courses>
  registeredCourse; 

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
public ArrayList<Courses> getRegisteredCourse() {
	return registeredCourse;
}
public void setRegisteredCourse(ArrayList<Courses> registeredCourse) {
	this.registeredCourse = registeredCourse;
}
public void notifyContacts(){

}
public void startQuarantine(){

}
public void startIsolation(){

}
public void closeContactPrompt(String rNumber){

}

public <> (String sn, String rn, Boolean tr){

}



}