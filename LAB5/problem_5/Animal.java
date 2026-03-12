package week_5.problem_5;

import java.util.Objects;

public abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getSpecies();
    public abstract String getSound();

    @Override
    public String toString() {
        return getSpecies() + "('" + name + "')";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
               Objects.equals(getSpecies(), animal.getSpecies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getSpecies());
    }
}