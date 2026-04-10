package LAB7.Problem3;


public class Product implements Cloneable {
	String name;
	Category cId;
	
	Product(String name, Category cId){
		this.cId=cId;
		this.name=name;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Product p = (Product) super.clone();
		p.cId = (Category) this.cId.clone();
		return p;
	}
	
	
}

class Category implements Cloneable{
	int id;
	
	public Category(int id) {
		this.id=id;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
