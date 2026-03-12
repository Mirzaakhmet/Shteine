package week_5.problem_5;

import java.util.Objects;

public abstract class Person {
    private final String name;
    private final int age;
    private Animal pet;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public Animal getPet() { return pet; }

    public boolean hasPet() {
        return pet != null;
    }

    public boolean assignPet(Animal pet) {
        if (pet == null) return false;
        if (this.pet != null) return false;

        if (this instanceof PhDStudent && pet instanceof Dog) {
            return false;
        }

        this.pet = pet;
        return true;
    }

    public Animal removePet() {
        Animal old = this.pet;
        this.pet = null;
        return old;
    }

    public abstract String getOccupation();

    @Override
    public String toString() {
        return getOccupation() + "{name='" + name + "', age=" + age +
                ", pet=" + (pet == null ? "none" : pet.toString() + " says " + pet.getSound()) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
               Objects.equals(name, person.name) &&
               Objects.equals(getOccupation(), person.getOccupation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, getOccupation());
    }
}