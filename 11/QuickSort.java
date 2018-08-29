package week11;


/**
 *  A quicksort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Sam Fleury
 */
public class QuickSort extends Sorter {

    /**
     *  Create a new QuickSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        quickSort(0, nums.length - 1);
    }

    /**
     * Sort 'em.
     * @param left The left bound.
     * @param right The right bound.
     */
    public void quickSort(int left, int right){
        if (left < right){
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
        }
        update();
    }

    /**
     * Partition them.
     * @param left The left bound.
     * @param right The right bound.
     * @return result.
     */
    public int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        i = left + 1;
        j = right;

        while (true){
            while (j > hole && nums[j] >= pivot){
                comparisons++;
                j--;
            }
            if (j == hole){
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            while (i < hole && nums[i] < pivot){
                comparisons++;
                i++;
            }
            if (i == hole){
                break;
            }
            nums[hole] = nums[i];
            hole = i;
        }
        nums[hole] = pivot;
        return hole;
    }
}
