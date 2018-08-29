package week02;

import java.util.Random;

/**  Coins.java Deals with coin flips, including setting and counting.
     @author Sam Fleury
     COSC241      */

public class Coins{

    /** Constants to represent coin flip results as bools. */
    public static final boolean HEADS = true;
    /** As above. */
    public static final boolean TAILS = false;
    /** Array to hold series of flips. */
    private boolean[] coins;

    /** Constructor.
        @param coins A boolean array representing coin face values.*/
        
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /** Constructor.
        @param c A string representing a series of coin flip results as chars.*/
    
    public Coins (String c){

        boolean[] coins = new boolean[c.length()];
        for (int i = 0; i < c.length(); i++){
            if (c.charAt(i) == 'H'){
                coins[i] = HEADS;
            } else{
                coins[i] = TAILS;
            }
        }
        this.coins = coins;

    }

    /** Constructor.
        @param length A number of coin flips to generate for the array.*/
    
    public Coins (int length){

        boolean[] coins = new boolean[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++){

            if (rand.nextInt(2) == 1){
                coins[i] = true;
            } else{
                coins[i] = false;
            }
            
        }

        this.coins = coins;

    }

    /** Counts the number of heads in the series of flips.
     @return the number of heads in the series.*/

    public int countHeads(){

        int numHeads = 0;
        for (boolean c : coins){
            if (c){
                numHeads++;
            }
        }

        return numHeads;

    }

    /** Counts the number of runs in the series.
     @return the number of runs.*/
    public int countRuns(){

        int runs = 1;  //starts at 1 because can't have zero runs
        boolean lastVal = coins[0];

        for (int i = 1; i < coins.length; i++){
            if (coins[i] != lastVal){
                lastVal = coins[i];
                runs++;
            }
        }

        return runs;

    }

    /** Returns the series of flips as H and T.
     @return the series of flips as characters.*/

    public String toString(){

        String output = "";
        for (boolean c : coins){
            if (c){
                output = (output + "H");
            }  else{
                output = (output + "T");
            }
        }
        return output;        
    }

    /** It's the main method.
     @param args arguments*/
    public static void main(String[] args){

        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        System.out.println("Heads: " + c.countHeads());
        System.out.println(c.toString());
        System.out.println("Runs: " + c.countRuns());

        String s = "HTHHT";
        Coins c2 = new Coins(s);
        System.out.println("Heads: " + c2.countHeads());
        System.out.println(c2.toString());
        System.out.println("Runs: " + c2.countRuns());

        Coins c3 = new Coins(5);
        System.out.println("Heads: " + c3.countHeads());
        System.out.println(c3.toString());
        System.out.println("Runs: " + c3.countRuns());
        
    }

}
