package LAB7.Problem5;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        String inputFile = "expressions.txt"; 
        String resultsFile = "results.txt";   
        String logFile = "log.txt";           

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            PrintWriter resultsWriter = new PrintWriter(new FileWriter(resultsFile));
            PrintWriter logWriter = new PrintWriter(new FileWriter(logFile))
        ) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String cleanLine = line.replaceAll("\\s+", "");
                if (cleanLine.isEmpty()) continue;

                try {
                    StringTokenizer st = new StringTokenizer(cleanLine, "+-*/%^!=", true);

                    String val1Str = st.nextToken();
                    double val1 = Double.parseDouble(val1Str);

                    String operator = st.nextToken();

                    if (!operator.equals("+") && !operator.equals("-") && 
                        !operator.equals("*") && !operator.equals("/") && !operator.equals("^") && !operator.equals("%") ) {
                        throw new UnsupportedOperationException("Operator '" + operator + "' is not supported.");
                    }

                    String val2Str = st.nextToken();
                    double val2 = Double.parseDouble(val2Str);

                    double result = 0;
                    switch (operator) {
                        case "+": result = val1 + val2; break;
                        case "-": result = val1 - val2; break;
                        case "*": result = val1 * val2; break;
                        case "^": result = Math.pow(val1, val2); break;
                        case "%": result = val1 % val2; break;
                        case "/": 
                            if (val2 == 0) throw new ArithmeticException("Division by zero");
                            result = val1 / val2; 
                            break;
                    }

                    resultsWriter.println(line + " = " + result);

                } catch (NoSuchElementException e) {
                    logWriter.println("Error [Missing Operand]: '" + line + "'");
                } catch (NumberFormatException e) {
                    logWriter.println("Error [Invalid Number Format]: '" + line + "'");
                } catch (UnsupportedOperationException e) {
                    logWriter.println("Error [Unsupported Operator]: '" + line + "' (" + e.getMessage() + ")");
                } catch (Exception e) {
                    logWriter.println("Error [Other]: '" + line + "' (" + e.getMessage() + ")");
                }
            }

            System.out.println("Processing complete. Check results.txt and log.txt.");

        } catch (FileNotFoundException e) {
            System.err.println("File " + inputFile + " not found. Please create it.");
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}