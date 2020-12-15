class MsgTest {

  // Junit tests for course.java
  // only getters and setters right now

  @Test
	public void testgetCourseNameValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> f, boolean i);
		String c = example.getCourseName();
		assertTrue(c.contentEquals("name"));
	}
  @Test
	public void testgetCourseNameNotValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> f, boolean i);
		String c = example.getCourseName();
		assertFalse(c.contentEquals("notName"));
	}

  @Test
	public void testsetCourseNameValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> f, boolean i);
		example.setCourseName("newName");
    String c = example.getCourseName();
		assertTrue(c.contentEquals("newName"));
	}
  @Test
	public void testsetCourseNameNotValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> f, boolean i);
		example.setCourseName("newName");
    String c = example.getCourseName();
		assertFalse(c.contentEquals("name"));
	}

  @Test
	public void testgetTotalStudentsValid() {
		Course example = new Course(String name, ArrayList<Student> 11, ArrayList<Student> f, boolean i);
		int t = example.getTotalStudents();
		assertTrue(t == 11);
	}
  @Test
	public void testgetTotalStudentsNotValid() {
		Course example = new Course(String name, ArrayList<Student> 11, ArrayList<Student> f, boolean i);
		int t = example.getTotalStudents();
		assertFalse(t == 13);
	}

  @Test
	public void testsetTotalStudentsValid() {
		Course example = new Course(String name, ArrayList<Student> 11, ArrayList<Student> f, boolean i);
		example.setTotalStudents(12);
    int t = example.getCourseName();
		assertTrue(t == 12);
	}
  @Test
	public void testsetTotalStudentsNotValid() {
		Course example = new Course(String name, ArrayList<Student> 11, ArrayList<Student> f, boolean i);
		example.setCourseName(12);
    int t = example.getCourseName();
		assertFalse(c == 11);
	}

  @Test
	public void testgetF2fStudentsValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> 11, boolean i);
		int f = example.getF2fStudents();
		assertTrue(f == 11);
	}
  @Test
	public void testgetF2fStudentsNotValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> 11, boolean i);
		int f = example.getCourseName();
		assertFalse(f == 22);
	}

  @Test
	public void testsetF2fStudentsValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student>11, boolean i);
		example.setTotalStudents(12);
    int f = example.getCourseName();
		assertTrue(f == 12);
	}
  @Test
	public void testsetF2fStudentsNotValid() {
		Course example = new Course(String name, ArrayList<Student> t, ArrayList<Student> 11, boolean i);
		example.setCourseName(12);
    int f = example.getCourseName();
		assertFalse(f == 11);
	}

  // Junit tests for Residency.java
  //only getters and setters right now

  @Test
	public void testGetDormNameValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> res);
    String d = test.GetDormName();
    assertTrue(d == "name");
	}
  @Test
	public void testGetDormNameNotValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> res);
    String d = test.GetDormName();
    assertFalse(d.contentEquals("notName"));
	}

  @Test
	public void testsetDormNameValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> res);
		test.setDormName("newName");
    String d  = test.getCourseName();
		assertTrue(d.equalsContent("newName"));
	}
  @Test
	public void testsetDormNameNotValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> res);
		test.setDormName("newName");
    String d  = test.getCourseName();
		assertFalse(d.equalsContent("name"));
	}

  @Test
	public void testsetDormNameValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> res);
		test.setDormName("newName");
    String d = test.getDormName();
		assertTrue(d.contentEquals("newName"));
	}
  @Test
	public void testsetDormNameNotValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> res);
		test.setDormName("newName");
    String d = test.getDormName();
		assertFalse(d.contentEquals("name"));
	}

  @Test
	public void testgetRoomsValid() {
		Residency test = new Residency(String name, ArrayList<Room> 11, ArrayList<Student> res);
    int r = test.getRooms();
		assertTrue(r == 11);
	}
  @Test
	public void testgetRoomsNotValid() {
		Residency test = new Residency(String name, ArrayList<Room> 11, ArrayList<Student> res);
    int r = test.getRooms();
		assertFalse(r == 12);
	}

  @Test
	public void testsetRoomsValid() {
		Residency test = new Residency(String name, ArrayList<Room> 11, ArrayList<Student> res);
		test.setRooms(12);
    int r = test.getDormName();
		assertTrue(r == 12);
	}
  @Test
	public void testsetRoomsValid() {
		Residency test = new Residency(String name, ArrayList<Room> 11, ArrayList<Student> res);
		test.setRooms(12);
    int r = test.getDormName();
		assertFalse(r == 11);
	}

  @Test
	public void testgetResidentsValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> 11);
    int res = test.getResidents();
		assertTrue(res == 11);
	}
  @Test
	public void testgetResidentsNotValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> 11);
    int res = test.getResidents();
		assertFalse(res == 12);
	}

  @Test
	public void testsetResidentsValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> 11);
		test.setResidents(12);
    int res = test.getResidents();
		assertTrue(res == 12);
	}
  @Test
	public void testsetResidentsValid() {
		Residency test = new Residency(String name, ArrayList<Room> r, ArrayList<Student> 11);
		test.setResidents(12);
    int res = test.getResidents();
		assertFalse(res == 11);
	}

  // Junit tests for Room.java
  // only getters and setter right now
  
  @Test
	public void testgetRoomNumberValid() {
    Room test = new Room(int 12, ArrayList<Student> s, Residency r);
    int rn = test.getRoomNumber();
    assertTrue(rn == 12);
  }
  @Test
	public void testgetRoomNumberNotValid() {
    Room test = new Room(int 12, ArrayList<Student> s, Residency r);
    int rn = test.getRoomNumber();
    assertFalse(rn == 11);
  }

  @Test
  public void testSetRoomNumberValid{
    Room test = new Room(int 12, ArrayList<Student> s, Residency r);
    test.setRoomNumber(11);
    int rn = test.getRoomNumber();
   assertTrue(rn == 11);
  }
  @Test
  public void testSetRoomNumberNotValid{
    Room test = new Room(int 12, ArrayList<Student> s, Residency r);
    test.setRoomNumber(11);
    int rn = test.getRoomNumber();
   assertFalse(rn == 12);
  }

  @Test
	public void testgetResidencyValid() {
    Room test = new Room(int rn, ArrayList<Student> s, Residency "resHall");
    Residency r = test.getRresidency();
    assertTrue(r.contentEquals("resHall"));
  }
  @Test
	public void testgetResidencyNotValid() {
    Room test = new Room(int 12, ArrayList<Student> s, Residency "resHall");
    Residency r = test.getResidency();
    assertFalse(r.contentEquals("resHall"));
  }

  @Test
  public void testSetResidencyValid(){
    Room test = new Room(int rn, ArrayList<Student> s, Residency "resHall");
    test.setResidency("resHallNew");
    Residency rn = test.getResidency();
   assertTrue(rn.contentEquals("resHallNew"));
  }
  @Test
  public void testSetResidencyNotValid(){
    Room test = new Room(int rn, ArrayList<Student> s, Residency "resHall");
    test.setResidency("resHallNew");
    Residency rn = test.getResidency();
   assertFalse(rn.contentEquals("resHall"));
  }




}