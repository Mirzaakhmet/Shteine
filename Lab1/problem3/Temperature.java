package LAB3.Problem3;

public class Temperature {
    private double val;
    private char scale;

    public Temperature() { this(0.0, 'C'); }
    public Temperature(double val) { this(val, 'C'); }
    public Temperature(char scale) { this(0.0, scale); }
    public Temperature(double val, char scale) {
        this.val = val;
        this.scale = scale;
    }

  
    public double getCelsius() {
        if (scale == 'C') return val;
        return 5 * (val - 32) / 9;
    }

    public double getFahrenheit() {
        if (scale == 'F') return val;
        return (9 * val / 5) + 32; 
    }

    public void setVal(double val) { this.val = val; }
    public void setScale(char c) { this.scale = c; }
    public void setAll(double val, char c) {
        this.val = val;
        this.scale = c;
    }

    public char getScale() { return scale; }
}