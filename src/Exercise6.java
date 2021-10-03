import textio.TextIO;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise6 {

    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();   // Look at the next character.
        }
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
        String word = "";  // This will be the word that is read.
        while (true) {
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek();  // Look at next character.
            if ( ch == '\'' ) {
                TextIO.getAnyChar();   // Read the apostrophe.
                ch = TextIO.peek();    // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                }
                else
                    break;
            }
            if ( ! Character.isLetter(ch) ) {
                break;
            }
        }
        return word;  // Return the word that has been read.
    }

    private static void printWords( ArrayList<String> words) {
        System.out.println("[");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(" " + words.get(i));
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("No input file selected.  Exiting.");
                System.exit(1);
            }
            ArrayList<String> wordList = new ArrayList<String>();
            String word;
            word = readNextWord();
            while (word != null) {
                if (!wordList.contains(word)) {
                    wordList.add(word);
                }
                word = readNextWord();
            }
            System.out.println("Number of different words in the file: " + wordList.size());
            Collections.sort(wordList);
            printWords(wordList);
        } catch (IllegalArgumentException e) {
            System.out.println("Encountered error: " + e);
        }
    }

}
