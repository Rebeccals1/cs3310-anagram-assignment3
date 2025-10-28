/**************************************************************
 * Rebecca Smith
 * CS 3310, Fall 2025
 * Programming Assignment 2
 * ------------------------------------------------------------
 * File: Main.java
 * Purpose: Driver class that reads a Word file from the command
 *          line, loads words into memory, finds sets of anagrams,
 *          and prints the results.
 **************************************************************/
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    /**************************************************************
     * Method: main
     * Purpose: Entry point for the program. Expects a filename in
     *          args[0], loads words, finds anagrams, and prints them.
     * Parameters: String[] args - command line argument with filename
     * Returns: void
     **************************************************************/
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <filename>");
            return;
        }

        // Our list of words
        ArrayList<String> words = new ArrayList<>();

        // Read file
        AnagramFileReader fileReader = new AnagramFileReader(args[0], words);
        fileReader.readFile();

        // Process anagrams
        AnagramFinder finder = new AnagramFinder(words);
        HashMap<String, ArrayList<String>> results = finder.findAnagram();

        // Print only sets of 2 or more words
        System.out.println("\n=== Anagram Groups ===\n");
        int counter = 0;
        for (String key : results.keySet()) {
            ArrayList<String> group = results.get(key);
            if (group.size() > 1) {
                System.out.println(group);
                counter += 1;
            }
        }
        System.out.println("Total Anagram Groups: " + counter);
    }
}
