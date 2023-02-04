package student;

//we need to import something so we can use the classes from the assignment
//the exercise says import assignment.*; which does not work
public class Assignment01Tester {

	private Group group;
	public void createGroup(int i) {
		group = new Group(i);
	}

	public void addStudent(int sNumber, String firstName, String lastName) {
		Student student = new Student(firstName, lastName, sNumber);
		group.addStudent(student);
	}

	public void changeStudent(int sNumber, String firstName, String lastName) {
		Student student = new Student (firstName, lastName, sNumber);
		student.changeStudent(firstName, lastName, sNumber);
	}

	public String printStudents() {
		return group.toString();
	}

}
