package week_5.problem_1.Part_b;

public class Book extends LibraryItem {
	private int numberOfPages;
	
	public Book(String title, String author, int year, int pages) {
		super(title, author, year);
		this.numberOfPages = pages;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages (int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Pages" + numberOfPages;
	}
}
