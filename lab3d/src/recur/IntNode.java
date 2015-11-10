package recur;
import java.util.Random;

/**
 * This is the class we wrote first; an IntNode is very simple, with
 * only two fields and a simple constructor.  It is a recursive data
 * structure -- it can hold data in the 'value' field  and can 
 * hold a reference to itself (recursion!) in the 'next' field
 */
public class IntNode {

    int value;
    IntNode next;

    IntNode(int value, IntNode next) {
        this.value = value;
        this.next = next;
    }

    
    /**
     * Next we made the static method 'makeIntNodeRandomly', which
     * take a int parameter and returns a linked node structure (one 
     * IntNode pointing to another) of that length.  The randomness
     * comes in for the data that gets stored in each node.
     */
    private static Random r = new Random();
    public static IntNode makeIntNodeRandomly(int count) {

        /**
         * Here we used the strategy similar to that in the reverse 
         * string method in your lab: solve each value of count separately
         * in a big if statement.  After a while we notice a pattern, and the 
         * way we can use makeIntNodeRandomly with a count of one less
         * to help us... this is the beginning of recursion!
         */
        if (count == 1) {
            return new IntNode(r.nextInt(100), null);
        } else if (count == 2) {
            IntNode x = new IntNode(r.nextInt(100), null);
            IntNode y = new IntNode(r.nextInt(100), null);
            x.next = y;
            return x;
        } else if (count == 3) {
            // use this method to get a length 2 structure
            IntNode temp = makeIntNodeRandomly(2);
            // stick another one on the front to get length 3
            return new IntNode(r.nextInt(100), temp);
        } else if (count == 4) {
            IntNode temp = makeIntNodeRandomly(3);
            return new IntNode(r.nextInt(100), temp);
        } else if (count == 5) {
            IntNode temp = makeIntNodeRandomly(4);
            return new IntNode(r.nextInt(100), temp);
        } else {
            /**
             * here we generalize the pattern, and can handle 
             * any length.  This is a general recursive solution.
             */
            IntNode temp = makeIntNodeRandomly(count - 1);
            return new IntNode(r.nextInt(100), temp);
        }

    }

    public static void main(String[] args) {
        IntNode x = makeIntNodeRandomly(1);
        System.out.println("A single node:");
        System.out.println(x.value);
        System.out.println(x.next);

        IntNode t = makeIntNodeRandomly(3);
        System.out.println(t.value + ", " + t.next.value + ", " + t.next.next.value + ", " + t.next.next.next);

        t = makeIntNodeRandomly(23);
        System.out.println(t.value + ", " + t.next.value + ", " + t.next.next.value + ", " + t.next.next.next);

    }
}
