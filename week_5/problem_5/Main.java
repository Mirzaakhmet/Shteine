package week_5.problem_5;

public class Main {
    public static void main(String[] args) {
        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Computer Science");
        Animal rex = new Dog("Rex");

        boolean ok = john.assignPet(rex);
        System.out.println("John got Rex: " + ok);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);

        System.out.println(registry);

        System.out.println("John goes on vacation and leaves Rex with Alice:");
        System.out.println("leavePetWith result: " + registry.leavePetWith(john, alice));
        System.out.println(registry);

        System.out.println("John returns from vacation and retrieves Rex:");
        System.out.println("retrievePetFrom result: " + registry.retrievePetFrom(john));
        System.out.println(registry);
    }
}