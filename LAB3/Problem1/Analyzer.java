package LAB3.Problem1;

import java.util.Scanner;

public class Analyzer {
	public static  void main(String[] args) {
            try (Scanner s = new Scanner(System.in)) {
                Data dataSet = new Data();
                while(true) {
                    System.out.println("Enter number (Q to quit): ");
                    if (s.hasNextDouble()) {
                        double in = s.nextDouble();
                        dataSet.add(in);
                    }
                    else {
                        String in = s.next();
                        if (in.equalsIgnoreCase("Q")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input. Please enter a number or 'Q'.");
                        }
                    }
                }
                
                System.out.println("Average = " + dataSet.getAvg());
                System.out.println("Maximum = " + dataSet.getMax());
            }
	}
}
