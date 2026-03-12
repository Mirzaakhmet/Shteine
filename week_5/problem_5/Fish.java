package week_5.problem_5;

public class Fish extends Animal {
    public Fish(String name) { super(name); }
    @Override public String getSpecies() { return "Fish"; }
    @Override public String getSound() { return "Blub"; }
}