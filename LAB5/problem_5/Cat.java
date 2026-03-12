package week_5.problem_5;

public class Cat extends Animal {
    public Cat(String name) { super(name); }
    @Override public String getSpecies() { return "Cat"; }
    @Override public String getSound() { return "Meow"; }
}