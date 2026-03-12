package week_5.problem_5;

public class Dog extends Animal {
    public Dog(String name) { super(name); }
    @Override public String getSpecies() { return "Dog"; }
    @Override public String getSound() { return "Woof"; }
}