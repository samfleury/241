/* File: WordSalad.java - April 2018 */
package week09;

import java.util.*;

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

    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }
  
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

    /**
     *  Distribute words into k wordblocks.
     *  Each word is placed in the first block, second in the second block
     *  and so forth till k blocks
     *  @param k size of the wordsalad blocks
     *  @return wordsalad blocks
     */
        
    public WordSalad[] distribute(int k) {
        
        Iterator<String> itr =  this.iterator();
        
        WordSalad[] array =  new WordSalad[k];

        for(int i = 0; i < k; i++) {
            array[i] = new WordSalad();
        }

        while(itr.hasNext()) {
            for(int i = 0; i < k; i++) {
		if(itr.hasNext()) {
                array[i].addLast(itr.next());
		} else {
		    break;
		}
	    }
	}
	return array;
    }
        
    public WordSalad[] chop(int k) {
        return null;
    }
        
    public WordSalad[] split(int k) {
        return null;
    }

     /**
     *  Merge words from k wordblocks to a single block
     *  resulting in the original text in order. 
     *  First word from first blocks, first word from second block
     *  and add words to the merged block until words run out 
     *  @param blocks as wordsalads
     *  @return wrd the single wordsalad block 
     */
        
    public static WordSalad merge(WordSalad[] blocks) {
	WordSalad wrd = new WordSalad();
	int x=0;
	int mrgSize=0;
	
	
	for (WordSalad array : blocks) {	   
	    for(String w : array) {
		mrgSize++;
	    }
	}
	while(x < mrgSize) {
	    for(int i = 0; i < blocks.length; i++) {
		if(blocks[i].first != null) {
		wrd.addLast(blocks[i].first.word);
		blocks[i].first = blocks[i].first.next;
	    } else {
		break;
		}
	    }
	    x++;
	}
	return wrd;
    }
    

        
    public static WordSalad join(WordSalad[] blocks) {
        return null;
    }

    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }

}
