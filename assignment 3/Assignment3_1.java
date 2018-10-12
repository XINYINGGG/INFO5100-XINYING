package assignment3;
//score 5/5

class Student{
	private String name;
	private int id;
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
class Course{
	private String courseName;
	private int numberOfStudent;
	Student[] registeredStudent = new Student[10];
	public String getCourseName() {
		return courseName;
	}
	public Course(String name) {
		this.courseName = name;
	}
	public Student[] getStudents() {
		return registeredStudent;
	}
	public boolean isFull() {
		if(registeredStudent.length == 10)
			return true;
		else 
			return false;
	}
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	public void registerStudent(Student student) {
		if(numberOfStudent < 10) {
			registeredStudent[numberOfStudent] = student;
			numberOfStudent++;
		}else {
			System.out.println("Sorry, the course is full, please choose other courses!");
		}
	}
	
}

public class Assignment3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
