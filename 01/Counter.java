package week01;

import java.util.Scanner;

/** Counter.java  Takes in some text, then outputs the number of lines and
 *  words in it.
 *  @author Sam Fleury
 *  COMP241  */

public class Counter{

    /** Main.
     *  @param args Arguments.*/
    public static void main(String[] args){

        String input;
        int lineCount = 0;
        int wordCount = 0;

        Scanner inScan = new Scanner(System.in);

        while (inScan.hasNextLine()){
            lineCount++;
            input = inScan.nextLine();
            Scanner lineScan = new Scanner(input);

            while (lineScan.hasNext()){
                wordCount++;
                lineScan.next();
            }
        }
        System.out.println("lines: " + lineCount);
        System.out.println("words: " + wordCount);
    }
    
}
