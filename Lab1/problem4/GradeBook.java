package LAB3.Problem4;
import java.util.*;
import LAB2.Student;

public class GradeBook {
    private Course course;
    private ArrayList<Student> students;
    private Map<Integer, Integer> grades;

    public GradeBook(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void addStudentGrade(Student student, int grade) {
        students.add(student);
        grades.put(student.getID(), grade);
    }

    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course.getName() + "!");
    }

    public void displayGradeReport() {
        System.out.println();
        determineClassAverage();
        System.out.println();
        outputLetterStats();
        System.out.println();
        outputBarChart();
    }

    private void determineClassAverage() {
        if (students.isEmpty()) return;

        double total = 0;
        int maxGrade = -1;
        int minGrade = 101;
        Student bestStudent = null;
        Student worstStudent = null;

        for (Student s : students) {
            int g = grades.get(s.getID());
            total += g;

            if (g > maxGrade) {
                maxGrade = g;
                bestStudent = s;
            }
            if (g < minGrade) {
                minGrade = g;
                worstStudent = s;
            }
        }

        double average = total / students.size();
        System.out.printf("Class average is %.2f. ", average);
        System.out.printf("Lowest grade is %d (Student %s, id: %d).\n", 
                          minGrade, worstStudent.getName(), worstStudent.getID());
        System.out.printf("Highest grade is %d (Student %s, id: %d).", 
                          maxGrade, bestStudent.getName(), bestStudent.getID());
    }

    private void outputLetterStats() {
        System.out.println("Letter grades distribution:");
        Map<String, Integer> stats = new LinkedHashMap<>();
        String[] letters = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        for (String l : letters) stats.put(l, 0);

        for (int g : grades.values()) {
            String l = convertToLetter(g);
            stats.put(l, stats.get(l) + 1);
        }

        stats.forEach((letter, count) -> {
            if (count > 0) System.out.println(letter + ": " + count);
        });
    }

    private String convertToLetter(int g) {
        if (g >= 95) return "A";
        if (g >= 90) return "A-";
        if (g >= 85) return "B+";
        if (g >= 80) return "B";
        if (g >= 75) return "B-";
        if (g >= 70) return "C+";
        if (g >= 65) return "C";
        if (g >= 60) return "C-";
        if (g >= 55) return "D+";
        if (g >= 50) return "D";
        return "F";
    }

    public void outputBarChart() {
        System.out.println("Grades distribution:");
        int[] frequency = new int[11];

        for (int g : grades.values()) {
            int safeGrade = Math.max(0, Math.min(g, 100)); 
            
            if (safeGrade == 100) {
                frequency[10]++;
            } else {
                frequency[safeGrade / 10]++;
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            if (i == 10) System.out.print("  100: ");
            else System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);

            for (int stars = 0; stars < frequency[i]; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
 
    @Override
    public String toString() {
        return "GradeBook for Course: " + course.getName() + " (Students: " + students.size() + ")";
    }
}