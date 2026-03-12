package week_5.problem_5;

public class Student extends Person {
    private final String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() { return major; }

    @Override
    public String getOccupation() {
        return "Student(" + major + ")";
    }
}