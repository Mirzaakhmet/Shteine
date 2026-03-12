package week_5.problem_1.Part_a;

public class Cube extends Shape3D{
	public double side;
	
	public Cube(double s) {
		this.side = s;
	}
	
	@Override
	public double volume() {
		return Math.pow(side, 3);
	}
	
	@Override
	public double surfaceArea() {
		return 6 * side * side;
	}
}

