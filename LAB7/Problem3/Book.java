package LAB7.Problem3;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L; 
    
    private String title;
    private String author;
    
    private transient int visitCount;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.visitCount = 1; 
    }

    public void incrementVisitCount() {
        this.visitCount++;
    }

    public String toString() {
        return "Title: '" + title + "', Author: '" + author + "', Visits: " + visitCount;
    }
}