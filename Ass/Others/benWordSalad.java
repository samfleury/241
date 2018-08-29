/* File: WordSalad.java - April 2018 */
package week09;
import java.util.ArrayList;

/**
 *  Skeleton implementation of the WordSalad class.
 *
 *  @author Michael Albert
 */
public class WordSalad implements Iterable<String> {

    private WordNode first;
    private WordNode last;
     
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**constructor that takes a list of strings called words as a parameter
       calls the addLast method for each word in the list to add them to a WordSalad object
    */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /**adds a word to a WordSalad object if there are no existing nodes in the object
       assigns this.first and this.last to the new node
    */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    /**takes a string as a parameter
       if there are no nodes in the WordSalad object then add(String word) is called
       if there is an existing node, it creates a new node and adds the word
       this.last is assigned to the new node
    */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }

    /**a private class for a node in WordSalad
       
     */
    private class WordNode {
        private String word;
        private WordNode next;
                
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }
        
    }
  
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
        
    public WordSalad[] distribute(int k) {
        return null;
    }
        
    public WordSalad[] chop(int k) {
        return null;
    }

    /**Public method to determine the size of the original WordSalad.
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

    /**Method for placing every kth item in a new WordSalad.
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
    
        
    public static WordSalad merge(WordSalad[] blocks) {
        return null;
    }
        
    public static WordSalad join(WordSalad[] blocks) {
        return null;
    }

    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }

}
