/* File: WordSalad.java - April 2018 */
package week09;

import java.util.ArrayList;

/**
 *  Full implementation of the WordSalad class.
 *  Divides up and reassembles collections of words.
 *  All methods implemented as per assignment.
 *
 *  @author Michael Albert
 *  @author Sam Fleury
 *  @author Vivek George
 *  @author Benjamin Schuck
 */
public class WordSalad implements Iterable<String> {

    /**A WordNode representing the first item in a WordSalad.*/
    private WordNode first;
    /**A WordNode representing the last item in a WordSalad.*/
    private WordNode last;

    /** Replacement for the default constructor.*/
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    
    /** Contructor. Takes a list of Strings.
     * @param words A List of words to be initialised. */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    
    /** Adds a word to the beginning of the WordSalad.
     * @param word A word to be added. */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    
    /** Adds a word to the end of the WordSalad.
     * @param word A word to be added. */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }

    
    /** WordNode. Holds the words and links.*/
    private class WordNode {
        /**The word at particular WordNode.*/
        private String word;
        /**The WordNode that is linked to by the current WordNode.*/
        private WordNode next;

        /** WordNode constructor.
         * @param word The word the node represents.
         * @param next A link to the next node. */
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }  
    }

    
    /** Iterator.
     @return java.util.Iterator<String>() An iterator for WordSalads.*/
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private WordNode current = first;
      
            public boolean hasNext() {
                return current != null;
            }
      
            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }
      
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    
    /** Returns the WordSalad as a String.
     * @return The WordSalad as a String.*/
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }


    /** Divides the WordSalad into k blocks, like dealing cards.
     * @param k The number of blocks to divide into.
     * @return An array blocks (WordSalads). */
    public WordSalad[] distribute(int k) {

        // create and initialise array
        WordSalad[] array = new WordSalad[k];
        for (int i = 0; i < array.length; i++){
            array[i] = new WordSalad();
        }

        // for each array element
        for (int i = 0; i < array.length; i++){
            WordNode current = this.first;
            
            // move starting point
            if (i > 0){
                for (int j = 0; j < i; j++){
                    current = current.next;
                }
            }

            // for each word
            while (current != null){
                array[i].addLast(current.word);

                // move current
                if (k > 0){
                    for (int j = 0; j < k; j++){
                        if (current != null){
                            current = current.next;
                        }
                    }
                }
            }
        }
        return array;
    }

    
    /** Divides the WordSalad into k blocks as evenly as possible.
     * @param k The number of blocks to divide into.
     * @return The divide blocks as WordSalads.*/
    public WordSalad[] chop(int k) {

        // if list empty
        if (this.first == null){
            return null;
        }
        
        WordSalad[] array = new WordSalad[k];
        // count nodes
        WordNode current = this.first;
        int nodeCount = 1;
        while (current.next != null){
            nodeCount++;
            current = current.next;
        }
        // reset current pointer
        current = this.first;
        
        // find base number + extra number
        int baseCount = nodeCount / k;
        int extraCount = nodeCount % k;

        // for each array index
        for (int i = 0; i < array.length; i++){
            array[i] = new WordSalad();
            // add base number of words
            for (int j = 0; j < baseCount; j++){
                array[i].addLast(current.word);
                current = current.next;
            }
            // if any more extras, add one, decrement num of extras
            if (extraCount > 0){
                array[i].addLast(current.word);
                current = current.next;
                extraCount--;
            }
        }
        return array;
    }

    
    /** Helper method to determine the size of the original WordSalad.
        @return i An int representing number of items in original WordSalad.
    */
    public int size(){
        if(this.first == null){
            return 0;  //If there are no items in the WordSalad, return 0.
        }else{
            WordNode current = this.first;
            int i = 1;
            while(current.next != null){
                i++;
                current = current.next;
            }
            return i;
        }
    }

    
    /** Method for placing every kth item in a new WordSalad.
        The same actions are then performed on the remaining items.
        @param k An int that represents the size of the interval in which items,
        will be removed.
        @return finalArray An array of split off WordSalads.
    */
    public WordSalad[] split(int k) {
        if(this.first == null){
            return null;  //If the WordSalad is empty, return null.
        }
        //ArrayList used to temporarily store the objects, as it is resizable.
        ArrayList<WordSalad> finalTemp = new ArrayList<WordSalad>();
        WordNode current = this.first;  //Sets current node to first in list.
        int blockCount = 0;  //Keeps count of the number of blocks.
        int size = size();
        
        while(0 < size){
            int indexCount = 0; //Counts the progress when iterating.
            WordSalad block = new WordSalad();   //Creates a new block.
            blockCount++;  //Adds the new block to the count.
            
            while(current != null){
                if(current.word == null){  //Do not consider null words.
                    current = current.next;
                }else{
                    if(indexCount % k == 0){  //If the item is a kth item.
                        block.addLast(current.word);
                        current.word = null;
                        size--;  //Decrease size when a kth item is removed.
                    }
                    current = current.next;
                    indexCount++;
                }
            }
            finalTemp.add(block);
            current = this.first;
        }
        //Move blocks from the ArrayList to an array to satisfy return type.
        WordSalad[] finalArray = new WordSalad[blockCount];
        for(int i = 0; i < finalTemp.size(); i++){
            finalArray[i] = finalTemp.get(i);
        }
        return finalArray;
    }

    
    /** Reverses the operation of the Distribute method.
     * @param blocks The input blocks to be reunited.
     * @return The WordSalad of merged blocks.*/
    public static WordSalad merge(WordSalad[] blocks) {
        WordSalad result = new WordSalad();

        // count nodes
        WordNode current = blocks[0].first;
        int maxNodeCount = 1;
        while (current.next != null){
            maxNodeCount++;
            current = current.next;
        }

        // for each index in each WS
        for (int i = 0; i < maxNodeCount; i++){
            
            // for each WS
            for (int j = 0; j < blocks.length; j++){
                current = blocks[j].first;

                // move start point if necesary
                if (i > 0){
                    for (int x = 0; x < i; x++){
                        if (current != null){
                            current = current.next;
                        }
                    }
                }
                // actually add the word to the result
                if (current != null){
                    result.addLast(current.word);
                }
            }
        }  
        return result;
    }

    
    /** Reverses the division of the Chop method.
     * @param blocks The blocks to be joined.
     * @return The complete WordSalad.*/
    public static WordSalad join(WordSalad[] blocks) {
        WordSalad result = new WordSalad();

        // for each WS in blocks
        for (int i = 0; i < blocks.length; i++){
            WordNode current = blocks[i].first;
            while (current != null){
                result.addLast(current.word);
                current = current.next;
            }
        }
        return result;
    }


    /**Method for finding the size of a WordSalad.
       @param block A WordSalad with an unknown size.
       @return i An int representing the size of the WordSalad.
    */
    public static int blockSize(WordSalad block){
        WordNode current = block.first;
        int size = 1;
        while(current.next != null){
            size++;
            current = current.next;
        }
        return size;
    }


    /**Method that performs the opposite actions to split.
       Recombining a split WordSalad will produce the original.
       @param blocks An array of WordSalad objects to be recombined.
       @param k The interval size for inserting the words.
       @return finalSalad The singular, complete WordSalad.
    */
    public static WordSalad recombine(WordSalad[] blocks, int k) {
        ArrayList<String> finalOrder = new ArrayList<String>();
        WordSalad finalSalad = new WordSalad();
        //Loop through the blocks in the array blocks in reverse order.
        for(int arrayIndex = blocks.length-1; -1 < arrayIndex; arrayIndex--){
            WordNode current = blocks[arrayIndex].first;
            int insertionIndex = 0;
            //Loop through the words in each block.
            //Add each word at indexes spaced k apart.
            while(current != null){ 
                finalOrder.add(insertionIndex, current.word);
                insertionIndex = insertionIndex + k;
                current = current.next;
            }  
        }
        //Translate the words from the ArrayList to the final WordSalad.
        for(int i=0; i<finalOrder.size(); i++){
            finalSalad.addLast(finalOrder.get(i));
        }
        return finalSalad;
    }

    
}
