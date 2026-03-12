package week_5.problem_5;

public class Bird extends Animal {
    public Bird(String name) { super(name); }
    @Override public String getSpecies() { return "Bird"; }
    @Override public String getSound() { return "Chirp"; }
}