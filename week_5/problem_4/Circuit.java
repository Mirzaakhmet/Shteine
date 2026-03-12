package week_5.problem_4;

public abstract class Circuit {

    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }
}