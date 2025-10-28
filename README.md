# CS 3310 - Design and Analysis of Algorithms

### Programming Assignment 3: Anagram Finder
------------------------------------------------------------


PROGRAM DESCRIPTION
------------------------------------------------------------
This program reads a text file containing one word per line
and groups together all words that are anagrams of one another.
It ignores capitalization and non-alphabetic characters, and
prints each detected set of anagrams in a clean, readable format.

FILES INCLUDED
------------------------------------------------------------
Main.java                - Driver class; handles user input and output
AnagramFileReader.java   - Reads and normalizes all words from a file
AnagramFinder.java       - Groups words into anagram sets using presorting
README.txt               - Instructions for compiling and running
WRITEUP.txt              - Runtime analysis explanation

COMPILATION INSTRUCTIONS
------------------------------------------------------------
To compile all Java source files:
    javac Main.java AnagramFileReader.java AnagramFinder.java

RUNNING THE PROGRAM
------------------------------------------------------------
To run the program, use:
    java Main <filename>

Example:
    java Main words.txt

NOTES
------------------------------------------------------------
• The input file must contain one word per line.
• Words are case-insensitive; “Elvis” and “lives” will be grouped together.
• Large files such as /usr/share/dict/words may be used for testing.
• Output only displays sets of words that contain two or more anagrams.

EXPECTED OUTPUT FORMAT
------------------------------------------------------------
Each group of anagrams will be printed as a list, for example:

[tea, ate, eat]
[lives, Elvis]

