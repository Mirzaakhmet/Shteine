import java.util.Scanner;

class vatafa1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
///TASK 1
        System.out.print("Task 1. Enter your name: ");
        String name = scanner.nextLine();
        int len = name.length();
        System.out.println("+" + "-".repeat(len + 2) + "+\n" + "| " + name + " |\n" + "+" + "-".repeat(len + 2) + "+");
///TASK 2
        System.out.print("Task 2. Enter number: ");
        String num1 = scanner.nextLine();
        int num2 = Integer.parseInt(num1);
        int area = num2 * num2;
        System.err.println("Area = " + area + "; Perimeter = " + (4 * num2) + "; Diagonal = " + (num2 * Math.sqrt(2)));
///TASK 3
        System.out.print("Task 3. Enter marks: ");
        String mark1 = scanner.nextLine();
        double mark1double = Double.parseDouble(mark1);
        int mark2 = (int) Math.ceil(mark1double);
        System.err.println("Your grade is: " + (mark2 >= 95 ? "A" : mark2 >= 90 ? "A-" : mark2 >= 85 ? "B+" : mark2 >= 80 ? "B" : mark2 >= 75 ? "B-" : mark2 >= 70 ? "C+" : mark2 >= 65 ? "C" : mark2 >= 60 ? "C-" : mark2 >= 55 ? "D+" : mark2 >= 50 ? "D" : "F"));
///TASK 4
        System.err.print("Task 4. Enter a b c: ");
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        double D = b * b - 4 * a * c;
        if (D > 0) {
            System.err.println("x1 = " + ((-b + Math.sqrt(D)) / (2 * a)) + "; x2 = " + ((-b - Math.sqrt(D)) / (2 * a)));
        } else if (D == 0) {
            System.err.println("x = " + (-b / (2 * a)));
        } else {
            System.err.println("Error bro");
        }
///TASK 5
        System.err.print("Task 5. Enter the opening balance: ");
        String balance1 = scanner.nextLine();
        double balance = Double.parseDouble(balance1);
        System.err.print("Enter annual interest rate (in %): ");
        String rate1 = scanner.nextLine();
        double rate = Double.parseDouble(rate1);
        System.err.println("Your balance after one year is: " + (balance * (1 + rate / 100)));
///TASK 6
        System.err.print("Task 6. Enter word: ");
        String word = scanner.nextLine();
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            System.err.println("The word is a palindrome.");
        } else {
            System.err.println("The word is not a palindrome.");
        }
    }
}