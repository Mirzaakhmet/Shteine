package LAB3.Problem3;

public class Task3 {
	public static void main(String[] args) {
		Temperature t = new Temperature();
		t.setAll(100, 'F');
		System.out.println(t.getScale());
		System.out.println(t.getCelsius());
		t.setAll(100, 'C');
		System.out.println(t.getFahrenheit());
		System.out.println(t.getScale());
	}
}
