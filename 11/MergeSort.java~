package week10;

/**
 *  A selection sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Sam Fleury
 */
public class SelectionSort extends Sorter {

    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        int temp;
        for (i = 0; i < nums.length - 1; i++){
            int smallestPos = i;
            for ( j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[smallestPos]){
                    smallestPos = j;
                }
                comparisons++;
                update();
            }
            temp = nums[i];
            nums[i] = nums[smallestPos];
            nums[smallestPos] = temp;
            
        }
    }
}
