package week_5.problem_5;

public class Employee extends Person {
    private final String role;

    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    public String getRole() { return role; }

    @Override
    public String getOccupation() {
        return "Employee(" + role + ")";
    }
}