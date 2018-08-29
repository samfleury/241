/* File: WordSalad.java - April 2018 */
package week09;

import java.util.Arrays;
import java.util.ArrayList;

/**
 *  Skeleton implementation of the WordSalad class.
 *
 *  @author Michael Albert
 */
public class WordSalad implements Iterable<String> {

    private WordNode first;
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
        private String word;
        private WordNode next;

        /** WordNode constructor.
         * @param word The word the node represents.
         * @param next A link to the next node. */
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }
        
    }

    /** Iterator. */
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


    // Method stubs to be completed for the assignment.
    // See the assignment description for specification of their behaviour.

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

    /** Divides the WordSalad according to an idiosyncratic assignment.
     * @param k The number of blocks to divide into.
     * @return The divide blocks as WordSalads.*/
    public WordSalad[] split(int k) {
        ArrayList<WordNode> words = new ArrayList<WordNode>();
        ArrayList<WordSalad> result = new ArrayList<WordSalad>();

        WordNode current = this.first;
        // fill words list from WS
        while (current != null){
            words.add(current);
        }

        // loop
        int resultIndex = 0;
        while (!words.isEmpty()){
            int wordsIndex = 0;
            int oldIndex = wordsIndex;

            // HERE: Trying to add words a la Distribute, but remove from words ArrayList after
            result.get(resultIndex).addLast(words.get(wordsIndex).word);
            
            
        }
        // for each word
        current = this.first;
        int i = 0;
        while (current != null){
            result.get(i).addLast(current.word);

            // move current
            if (k > 0){
                for (int j = 0; j < k; j++){
                    if (current != null){
                        current = current.next;
                    }
                }
            }
                
        }
        
        return result.toArray(new WordSalad[0]);
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

    /** Reverses the division of the Split method.
     * @param blocks The blocks to be reunited.
     * @param k The original number of divisions.
     * @return The recompiled WordSalad.*/
    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }

}
