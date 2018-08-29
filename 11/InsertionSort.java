package week11;
import java.util.*;

/**
 *  An insertion sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Sam Fleury
 */
public class InsertionSort extends Sorter {

    /**
     *  Create a new InserttionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        for (i = 1; i < nums.length; i++){
            int key = nums[i];
            int pos = i;
            for (j = i - 1; j >= 0; j--){
                if (nums[j] >= key){
                    nums[j + 1] = nums[j];
                    pos = j;
                } else{
                    break;
                }
                comparisons++;
                update();
                
            }
            nums[pos] = key;
        }

    }
}
