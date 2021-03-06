package week08;

import java.util.*;
import java.io.*;

/** 
 * Frequency Generator.
 * @author Sam Fleury
 */
public class FrequencyGenerator implements WordGenerator {

    /** Random object. */
    private Random random;
    /** Lenghth of the english alphabet. */
    private static final int ALPHABET_LENGTH = 26;
    /** Array to hold letter weights. */
    private float[] w = new float[ALPHABET_LENGTH];
    
    
    /**
     * Constructor.
     * @param r Random object.
     */
    public FrequencyGenerator(Random r) {
        random = r;
        fillArray();
        //System.out.println(Arrays.toString(w));
    }

    /**
     * Fills the array with the weights from the file supplied.
     */
    private void fillArray(){
        try {
            FileReader fileReader = new FileReader("letter-frequencies.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner in = new Scanner(bufferedReader);
            for(int i = 0; i < ALPHABET_LENGTH; i++){
                w[i] = in.nextFloat();
                //in.nextLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    /**
     * Randomly picks a letter, taking into account the weights provided.
     * @param w The array holding the weights.
     * @return The index of the letter, from 0-26
     */
    private int chooseIndex(float[] w){
        float r = (float) random.nextDouble();
        int i = 0;
        while(r > w[i]){
            r = r - w[i];
            i++;
        }
        return i;
    }

    /**
     * Provides a random word of length n.
     * @param n The length of the word to return.
     * @return The word generated.
     */
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++){
            char c = (char) (chooseIndex(w) + 'a');
            result.append(c);
        }
        return result.toString();
    }

}
