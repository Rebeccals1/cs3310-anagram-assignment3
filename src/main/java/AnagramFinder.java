/**************************************************************
 * Rebecca Smith
 * CS 3310, Fall 2025
 * Programming Assignment 2
 * ------------------------------------------------------------
 * File: AnagramFinder.java
 * Purpose: Groups words into sets of anagrams using presorting.
 **************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramFinder {
    private final HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> words = new ArrayList<String>();

    public AnagramFinder(ArrayList<String> list) {
        this.words = list;
    }

    // ****************
    // Getters & Setters
    // ****************
    public HashMap<String, ArrayList<String>> getAnagrams() {
        return anagrams;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> list) {
        this.words = list;
    }

    /**************************************************************
     * Method: findAnagram
     * Purpose: Build groups of anagrams by creating a sorted
     *          signature for each word.
     * Returns: HashMap of signature → list of anagrams
     **************************************************************/
    public HashMap<String, ArrayList<String>> findAnagram(){
        for (String word : words) {
            // Step 1: Convert word into sorted key
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String sortedWord = new String(letters);

            // Step 2: Add word to its group
            anagrams.putIfAbsent(sortedWord, new ArrayList<>());
            anagrams.get(sortedWord).add(word);
        }

        // Step 3: Return completed groups
        return anagrams;
    }


}
