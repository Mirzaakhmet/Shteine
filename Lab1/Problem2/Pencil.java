package LAB3.Problem2;

enum Color {
	RED,GREEN,BLUE
}


public class Pencil {
	public static final String Brand = "OPARTYPARTYYEAH";
	private static int totNumberPencil = 0;
	private final Color color;
	private double length;
	private boolean isBroken = false;
	
	{
		totNumberPencil++;
	}
	public Pencil(Color color) {
		
		this(color,19.0);
		
	}
	
	public Pencil(Color color, double length) {
		this.color = color;
		if (length < 0) {
	        throw new IllegalArgumentException("Длина карандаша не может быть отрицательной ! ");
	    } else {
	        this.length = length;
	    }
	}
	
	public void Sharpen() {
		Sharpen(0.5);
        }
	public void Sharpen(double length) {
		 if (!isBroken && this.length > length) {
	            this.length -= length;
	        } else if (!isBroken) {
	            System.out.println("Карандаш сломался!");
	            this.length = 0;
	            this.isBroken = true; 
	            totNumberPencil--;    
	            } 
		 }
	
	
	public Color getColor() {
		return color;
	}
	
	public double getLength() {
		return length;
	}
	
	public static int getTotNumPen() {
		return totNumberPencil;
	}
}
