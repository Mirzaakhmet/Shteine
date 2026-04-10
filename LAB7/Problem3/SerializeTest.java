package LAB7.Problem3;

public class SerializeTest {
	public static void main(String[] args) throws CloneNotSupportedException  {
		Category c = new Category(0);
		Product p = new Product("NESKEB",c);
		Product p1 = (Product) p.clone();
		p1.cId.id=5;
		System.out.println(p.cId.id);
		System.out.println(p1.cId.id);
	}
}
