package LAB7.Problem4;
import java.io.*;
import java.util.Random;

public class SensorDataSimulator {
    public static void main(String[] args) {
        String fileName = "sensor.bin";
        int totalRecords = 60;

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            Random random = new Random();
            for (int i = 0; i < totalRecords; i++) {
                double temp = 15.0 + (20.0 * random.nextDouble()); 
                dos.writeDouble(temp);
            }
            System.out.println("Step 1: Successfully wrote " + totalRecords + " records to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return; 
        }

        long targetBytePosition = 29L * 8L; 

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(targetBytePosition);
            raf.writeDouble(999.9);
            System.out.println("Step 2: Successfully changed the 30th record to 999.9");
        } catch (IOException e) {
            System.err.println("Error modifying the file: " + e.getMessage());
            return;
        }

        double maxTemp = Double.MIN_VALUE;
        double sumTemp = 0.0;
        int count = 0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\n--- Verification Results ---");
            try {
                while (true) {
                    double temp = dis.readDouble();
                    sumTemp += temp;
                    
                    if (temp > maxTemp) {
                        maxTemp = temp;
                    }
                    
                    if (count == 29) {
                        System.out.println("-> Value read at 30th position: " + temp);
                    }
                    count++;
                }
            } catch (EOFException e) {
                // End of file 
            }

            if (count > 0) {
                double averageTemp = sumTemp / count;
                System.out.println("Total records read: " + count);
                System.out.printf("Maximum temperature: %.2f °C\n", maxTemp);
                System.out.printf("Average temperature: %.2f °C\n", averageTemp);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}