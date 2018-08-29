package week11;

import java.util.Arrays;

/**
 *  A merge sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Sam Fleury
 */
public class MergeSort extends Sorter {

    /**
     *  Create a new MergeSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        mergeSort(0, nums.length - 1);
    }

    /**
     * Sort the integers.
     * @param left The left bound.
     * @param right The right bound.
     */
    public void mergeSort(int left, int right){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid +1, right);
        }
    }

    /**
     * Merge the sorted parts.
     * @param left The left bound.
     * @param mid The middle.
     * @param right The right bound.
     */
    public void merge(int left, int mid, int right){
        Integer[] temp = Arrays.copyOf(nums, nums.length);
        
        i = left;
        j = left;
        int k = mid;

        while(i < mid && k <= right){
            comparisons++;
            if (temp[i] < temp[k]){
                nums[j++] = temp[i++];
            } else{
                nums[j++] = temp[k++];
            }
        }
        while(i < mid){
            nums[j++] = temp[i++];
        }
        while(j <= right){
            nums[j++] = temp[k++];
        }
        update();
    }
}
