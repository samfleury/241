package week08;

import java.util.*;
import java.io.*;

/**
 * Digram Generator.
 * @author Sam Fleury
 */
public class DigramGenerator implements WordGenerator {

    /** Random object for testing.  */
    private Random random;

    /** The length of the English alphabet. */
    private static final int ALPHABET_LENGTH = 26;

    /** The ASCII value of 'a'. */
    private static final int A_VALUE = 97;

    /** Holds the list of first letters. */
    private String firstLetters;

    /** Holds the list of weighted continuations for letters. */
    private String[] continuations = new String[ALPHABET_LENGTH];

    /** Constructor.
     * @param r The random object for testing.
     */
    public DigramGenerator(Random r) {
        random = r;
        fillArray();
        // System.out.println(Arrays.toString(continuations));
        fillString();
        //System.out.println(firstLetters);
    }

    /** Fills the array with letter continuations. */
    private void fillArray(){
        try {
            FileReader fileReader = new FileReader("continuations.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner in = new Scanner(bufferedReader);
            for(int i = 0; i < ALPHABET_LENGTH; i++){
                continuations[i] = in.nextLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    /** Fills the String with first letters. */
    private void fillString(){
        try{
            FileReader fileReader = new FileReader("first-letters.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner in = new Scanner(bufferedReader);
            firstLetters = in.nextLine();
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    /** Returns a random word of a given length.
     * @param n The length of the word.
     * @return The random word.*/
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder(n);
        // first letter
        char c = firstLetters.charAt(random.nextInt(firstLetters.length()));
        result.append(c);

        // rest of letters
        for (int i = 1; i < n; i++){
            char lastChar = result.charAt(i - 1);
            int lastCharVal = (int) lastChar - A_VALUE;
            c = continuations[lastCharVal].charAt
                (random.nextInt(continuations[lastCharVal].length()));
            result.append(c);
            //System.out.println(result.toString());
        }
        
        return result.toString();
    }

}
