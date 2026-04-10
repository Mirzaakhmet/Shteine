package LAB7.Problem2;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "report.txt";

        Map<String, Integer> wordCounts = new HashMap<>();

        try (
            BufferedReader br =  new BufferedReader(Files.newBufferedReader(Paths.get(inputFile)));
            PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(outputFile), StandardCharsets.UTF_8))
        ) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\p{Punct}\\s]+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());

            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            for (Map.Entry<String, Integer> entry : sortedEntries) {
                pw.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("Word frequencies successfully written to " + outputFile);

        } catch (IOException e) {
            System.err.println("An error occurred while reading or writing the files: " + e.getMessage());
        }
    }
}