package LAB3.Problem4;

import java.util.Scanner;
import LAB2.Student;
import java.util.*;
public class GradeBookTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Course oop = new Course("CS101 Object-oriented Programming and Design", 
                "Basic Java and OOP principles", 5, "None");
		
		System.out.println("\n--- Objects Info ---");
        System.out.println(oop.toString());
		
        System.out.println("Please, input the number of students");
        int a = s.nextInt();
        System.out.println("Please, input the name of each student");
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < a; i++) {
        	System.out.println("Input the name: \n");
        	names.add(s.next());
        }
        
		GradeBook gb = new GradeBook(oop);
		System.out.println(gb.toString());
        
		
        gb.displayMessage();
        System.out.println("Please, input grades for students:");
        for (String name : names) {
            Student st = new Student(name, 1); 
            System.out.print("Student " + st.getName() + ": ");
            int grade = s.nextInt();
            
            while (grade < 0 || grade > 100) {
                System.out.print("Invalid grade! Please enter a value between 0 and 100: ");
                grade = s.nextInt();
            }
            gb.addStudentGrade(st, grade);
        }
            
        System.out.println();
        gb.displayGradeReport();
   
        
		s.close();
	}

}
