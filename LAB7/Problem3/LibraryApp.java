package LAB7.Problem3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static final String FILE_NAME = "library.dat";

    public static void main(String[] args) {
        List<Book> library = loadLibrary();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Loaded " + library.size() + " books from " + FILE_NAME);

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("(A)dd a book");
            System.out.println("(L)ist books");
            System.out.println("(Q)uit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    
                    library.add(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;
                    
                case "L":
                    if (library.isEmpty()) {
                        System.out.println("The library is currently empty.");
                    } else {
                        System.out.println("\n--- Library Contents ---");
                        for (Book book : library) {
                            System.out.println(book);
                            book.incrementVisitCount(); 
                        }
                        System.out.println("------------------------");
                    }
                    break;
                    
                case "Q":
                    saveLibrary(library);
                    System.out.println("Library saved. Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please type A, L, or Q.");
            }
        }
        scanner.close();
    }

    @SuppressWarnings("unchecked")
    private static List<Book> loadLibrary() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading library: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static void saveLibrary(List<Book> library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(library);
        } catch (IOException e) {
            System.err.println("Error saving library: " + e.getMessage());
        }
    }
}