package week12;

/**
 *  A heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class HeapSort extends Sorter {

    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using heap sort.
     */
    public void sortNums() {
        heapify();
        for (int i = nums.length - 1; i >= 0; i--){
            swap(i, 0);
            siftDown(0, i);
        }
    }

    private void swap(int x, int y) {
        // int i, j, and nums[] are all protected datafields in the
        // superclass Sort so we can use them without declaring them
        i = x;
        j = y;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        update();
    }

    /**
     *  Turn this into a heap by sifting down each value that isn't
     *  already a leaf.
     */
    private void heapify() {
        for ( int i = (nums.length / 2) - 1; i >=0; i--){
            siftDown(i, nums.length);
        }
    }

    /**
     *  Move the value at index i down in the heap to its correct
     *  place by continually swapping it with its largest child that
     *  is bigger than it.
     *
     * @param i the index of the value to be sifted down in the heap.
     * @param size the size of the current heap (will be smaller than
     *        array length as heap sort is performed).
     */
    private void siftDown(int i, int size) {
        largerChildIndex = getLargerChildIndex(i, size != -1);
        if (largerChildIndex != -1){
            swap(i, largerChildIndex);
            siftDown(largerChildIndex);
            }
    }

    /**
     *  Returns the index of the largest child of i, or -1 if i
     *  doesn't have a child larger than itself.
     *
     * @return the index of i's largest child that is bigger than i or
     *         -1 if no such child exists.
     */
    private int getLargerChildIndex(int i, int size) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max = i;
        if (l <= size){
            if (nums[l] > nums[max]){
                max = l;
            }
        }
        if (r <= size){
            if (nums[r] > nums[max]){
                max = r;
            }
        }
        if (max == i){
            return -1;
        } else{
            return max;
        }
    }
    
}
