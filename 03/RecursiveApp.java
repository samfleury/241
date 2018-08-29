package week03;

/** RecursiveApp.java Does some recursive stuff.
    COSC241
    @author Sam Fleury**/

public class RecursiveApp{

    /** It's the main method.
     @param args It's the args.*/
    public static void main(String[] args){

        long n = Long.parseLong(args[0]);
        System.out.println(sumOfDigits(n));

        
    }

    /** Returns the number of digits in the number.
     @param n the input number
     @return the number of digits in the input number*/    
    public static long digits(long n){
        if (n < 0){
            n *= -1;
        }
        if (n < 10){
            return 1;
        }
        return 1 + digits(n/10); 
    }

    /** Returns the sum of the digits.
     @param n the input number
     @return the sum of the digits**/
    public static long sumOfDigits (long n){
        long sum = 0;
        long nAbs = Math.abs(n);
        if (nAbs < 10){  //base case
            sum = nAbs;
        } else {         //recursive call
            sum = (nAbs % 10) + sumOfDigits(nAbs / 10);
        }
        
        if (n > 0) {     //checks for negative input
            return sum;
        } else {
            return (-1) * sum;
        }
    }

    
}
