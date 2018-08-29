package week12;

/**
 *  A selection sort implementation which is able to be observed through
 *  its Sorter superclass.
 *
 * @author Iain Hewson
 */
public class SelectionSort extends Sorter {
    
    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using selection sort.
     */
    public void sortNums() {
        for (i = 0; i < nums.length - 1; i++){
            //find smallest from p to length - 1;
            int smallestPos = i;
            for (j = i; j < nums.length; j++){
                if (nums[j] < nums[smallestPos]){
                    smallestPos = j;
                }
            }
            // swap smallest
            int temp = nums[i];
            nums[i] = nums[smallestPos];
            nums[smallestPos] = temp;
        }
    }

}
