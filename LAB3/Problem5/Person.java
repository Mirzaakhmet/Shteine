package LAB3.Problem5;

enum Gender {B,G};

public class Person {
	private Gender gender;
	
	
	public Person(Gender G){
		this.gender = G;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	private String displayInfo(){
		String res;
		res = "Gender: " + gender;
		return res;
	}
	public String toString() {
		return displayInfo();
	}
	
	
}
