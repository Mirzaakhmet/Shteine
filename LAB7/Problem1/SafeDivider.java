package LAB7.Problem1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivider {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isSuccessful = false;

        while (!isSuccessful) {
            try {
                System.out.print("Enter the first integer: ");
                int x1 = scan.nextInt();

                System.out.print("Enter the second integer: ");
                int x2 = scan.nextInt();

                int result = x1 / x2;
                System.out.println("Division result: " + result);
                
                isSuccessful = true; 

            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero! Please try again.\n");
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: An integer was expected, but text was entered! Please try again.\n");
                System.out.println(e.getMessage());
                e.printStackTrace();
                scan.nextLine(); 
            }
        }
        scan.close();
    }
}