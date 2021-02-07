/* Author: Sandro Sobczyński */

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Excercise25 {

    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\hasto\\Desktop\\test.txt";
            String text = getText(filePath);
            ArrayList<String> uniqueWords = getUniqueWords(text);
            String prettyUniqueWords = uniqueWords.stream().reduce("", (a, b) -> String.format("%s %s", a, b))
                    .substring(1);
            System.out.println(String.format("File: %s", text));
            System.out.println(String.format("Unique: %s", prettyUniqueWords));
            System.out.println(String.format("Unique length: %d", uniqueWords.size()));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (Exception ex) {
            System.out.println("Unknown error -> " + ex.getMessage());
        }

    }

    private static String getText(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        String result = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result += String.format(" %s", line);
        }
        scanner.close();
        return result.substring(1);
    }

    private static ArrayList<String> getUniqueWords(String text) {
        text = text.replace(",", "");
        text = text.replace(".", "");
        text = text.toLowerCase();
        List<String> words = Arrays.asList(text.split(" "));
        Set<String> uniqueWords = new HashSet<>(words);
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(uniqueWords);
        return result;
    }

}
