package LAB3.Problem4;

public class Course {
	private String name;
	private String description;
	private int numofCredits;
	private String prereq;
	
	public Course(String name, String description, int numofCredits, String prereq) {
		this.name = name;
		this.description = description;
		this.numofCredits = numofCredits;
		this.prereq = prereq;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Course: " + name + "\n"+
	               "Description: " + description + "\n" +
	               "Credits: " + numofCredits + "\n" +
	               "Prerequisites: " + prereq +"\n" +"\n";
	}
}
