package LAB3.Problem2;

public class Task2 {
	public  static void main(String[] args) {
		Pencil p = new Pencil(Color.BLUE,12);
		System.out.println(Pencil.getTotNumPen());
		System.out.println(p.getColor());	
		System.out.println(p.getLength());
		p.Sharpen();
		System.out.println(p.getLength());
		p.Sharpen(11.5);
		System.out.println(p.getLength());
		System.out.println(Pencil.getTotNumPen());
	}
}
