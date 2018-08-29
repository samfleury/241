package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Michael Albert
 */
public class Tower{

    /** The top block. */
    private char top;
    
    /** The rest of the tower. */
    private Tower rest;


    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }
    
    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }
        
    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /** Returns the height of the tower.
     @return the height of the tower.*/
    public int height(){
        if (this.rest == null){
            return 0;
        } else {
            return 1 + rest.height();
        }
    }

    /**  Counts the number of appearances of a particular color in the tower.
         @param c Represents the color as a char.
         @return the number of appearances of the color.*/
    public int count (char c){
        int sumChar = 0;
        if (top == c){
            sumChar++;
        }
        if (isEmpty()){
            return 0;
        }
        return sumChar + rest.count(c);
    }

    /** It's the main method.
        @param args It's the args. */
    public static void main (String[] args){
        int numTimes = Integer.parseInt(args[0]);
        Tower tower0 = new Tower();
        for (int i = 0; i < numTimes; i++){
            tower0 = tower0.add('R');
        }
        System.out.println(tower0.height());
        System.out.println(tower0.count('R'));
    }
    

}
