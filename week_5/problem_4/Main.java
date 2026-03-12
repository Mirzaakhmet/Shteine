package week_5.problem_4;

public class Main {
    public static void main(String[] args) {

        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);
        Circuit g = new Parallel(c, d);
        Circuit h = new Series(f, g);
        Circuit i = new Parallel(e, h);

        i.applyPotentialDiff(12.0);

        double R = i.getResistance();
        double I = i.getCurrent();

        System.out.println("Total Resistance: " + R);
        System.out.println("Total Current: " + I);
    }
}