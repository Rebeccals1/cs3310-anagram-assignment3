/**************************************************************
 * Rebecca Smith
 * CS 3310, Fall 2025
 * Programming Assignment 2
 * ------------------------------------------------------------
 * File: AnagramFileReader.java
 * Purpose: Reads a text file of words, removes accents and
 *          non-letter characters, and stores the cleaned words
 *          for anagram processing.
 **************************************************************/

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;

public class AnagramFileReader {

    private String filePath;            // Path to input file
    private final ArrayList<String> wordList; // List of cleaned words

    /**************************************************************
     * Constructor
     * Purpose: store filename and target list for words
     **************************************************************/
    public AnagramFileReader(String path, ArrayList<String> wordList) {
        this.filePath = path;
        this.wordList = wordList;
    }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public ArrayList<String> getWordList() { return wordList; }

    /**************************************************************
     * Method: getReader
     * Purpose: Open text file for reading
     * Parameters: String path - file path to open
     * Returns: BufferedReader
     **************************************************************/
    private BufferedReader getReader(String path) throws FileNotFoundException {
        File file = new File(path);
        return new BufferedReader(new FileReader(file));
    }

    /**************************************************************
     * Method: readFile
     * Purpose: Reads each line, filters it, and stores the word
     **************************************************************/
    public void readFile() {
        try (BufferedReader reader = getReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Ignore empty lines
                if (!line.trim().isEmpty()) {
                    String filtered = filterWord(line);
                    wordList.add(filtered);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**************************************************************
     * Method: filterWord
     * Purpose: Normalize and clean strings; lowercase, strip accents
     **************************************************************/
    public String filterWord(String word) {
        String normalized = Normalizer.normalize(word,
                Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return normalized.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
}
