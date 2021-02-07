/* Author: Sandro Sobczyński */

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Excercise26 {

    public static void main(final String[] args) {
        try {

            // Odpowiedź to: "the"

            final String filePath = "C:\\Users\\hasto\\Desktop\\hamlet.txt";
            final String text = getText(filePath);
            final ArrayList<WordCounter> uniqueWords = getUniqueWords(text);
            String prettyString = generatePrettyString(uniqueWords);
            System.out.println(String.format("File: %s", text));
            System.out.println(String.format("Unique: %s", prettyString));
            System.out.println(String.format("Unique length: %d", uniqueWords.size()));
        } catch (final FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (final Exception ex) {
            System.out.println("Unknown error -> " + ex.getMessage());
        }

    }

    private static String getText(final String filePath) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File(filePath));
        String result = "";
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            result += String.format(" %s", line);
        }
        scanner.close();
        return result.substring(1);
    }

    private static ArrayList<WordCounter> getUniqueWords(String text) {
        text = text.replace(",", "");
        text = text.replace(".", "");
        text = text.toLowerCase();
        final ArrayList<WordCounter> result = new ArrayList<WordCounter>();
        final List<String> words = Arrays.asList(text.split(" "));
        for (String word : words) {
            if (word.equals(""))
                continue;
            final Optional<WordCounter> foundWord = result.stream().filter(c -> c.name.equals(word)).findFirst();
            if (foundWord.isPresent()) {
                foundWord.get().count += 1;
            } else {
                final WordCounter newObj = new WordCounter(word);
                result.add(newObj);
            }
        }
        result.sort((WordCounter a1, WordCounter a2) -> a2.count - a1.count);
        return result;
    }

    private static String generatePrettyString(ArrayList<WordCounter> uniqueWords) {
        String prettyUniqueWords = "";
        for (WordCounter word : uniqueWords)
            prettyUniqueWords += String.format(", %s=%d", word.name, word.count);
        return prettyUniqueWords.substring(2);
    }

}
