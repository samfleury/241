package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if (!rowLengthsDecrease(t)){
            return false;
        }
        if (!rowValuesIncrease(t)){
            return false;
        }
        if (!columnValuesIncrease(t)){
            return false;
        }
        if (!isSetOf1toN(t)){
            return false;
        }

        return true;
    }

    /**
     * Determines whether the array passed has rows that decrease in length.
     *
     * @param t a 2d array to test row length
     *
     * @return true if each row is shorter than its predecessor
     */
    public static boolean rowLengthsDecrease (int [] [] t){

        if (t.length == 0 || t.length == 1){
            return true;
        }
        
        for (int i = 1; i < t.length; i++){  // start at second element
            if (t[i].length > t[(i-1)].length){
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether the values in each row increase.
     *
     * @param t a 2d array to test row increase
     *
     * @return true if each value is shorter than the one to its left
     */
    public static boolean rowValuesIncrease(int [] [] t){

        if (t.length == 0){
            return true;
        }

        for (int [] arr : t){
            
            for (int i = 1; i < arr.length; i++){
                if (arr[i] <= arr[i-1]){
                    return false;
                }
            }
        }

        return true;

    }

    /**
     * Determines whether the values increase in each column.
     *
     * @param t a 2d array to test column increase
     *
     * @return true if each value is smaller than the one above it
     */
    public static boolean columnValuesIncrease(int [] [] t){

        if (t.length < 2){
            return true;
        }
        
        for (int i = 0; i < t[0].length; i++){
            for (int j = 1; j < t.length; j++){
                if (i < t[j].length){
                    if (t[j][i] < t[j-1][i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Determines whether all numbers between 1 and n are present.
     *
     * @param t a 2d array to test for numbers.
     *
     * @return true if all numbers present.
     */

    public static boolean isSetOf1toN(int [] [] t){
        // count cells
        int cellCount = 0;
  
        for (int [] i : t){
            for (int j : i){
                cellCount++;
            }
        }
            

        // read values to array
        boolean [] set = new boolean[cellCount];

        for (int [] i : t){
            for (int j : i){
                if (j > cellCount){
                    return false;
                }
                set[j - 1] = true;
            }
        }

        // check array for all values
        for (boolean present : set){
            if (!present){
                return false;
            }
        }

        return true;
       
       
    }
    
    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    
}
