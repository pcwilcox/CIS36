package recur;

import java.util.HashSet;
import java.util.Random;

/**
 * Our second look into a simple recursive structure. (Look at the class IntNode
 * first, before this one).
 *
 * Here we decided that this class was better named as a list than a node,
 * because it includs a 'tail' (referenced in the next field) that, put
 * together, could make a whole list.
 */
public class IntList {

    int value;
    IntList next;

    IntList(int value, IntList next) {
        this.value = value;
        this.next = next;
    }

    private static Random r = new Random();

    public static IntList makeIntListRandomly(int count) {
        if (count > 0) {
            return new IntList(r.nextInt(100), makeIntListRandomly(count - 1));
        } else {
            return null;
        }
    }

    // Recursive printing of IntLists
    @Override
    public String toString() {
        return "(" + toStringHelper() + ")";
    }

    public String toStringHelper() {
        if (next == null) {
            return Integer.toString(value);
        } else {
            return Integer.toString(value) + ", " + next.toStringHelper();
        }
    }

    // recursive length
    public int length() {
        if (next == null) {
            return 1;
        } else {
            return 1 + next.length();
        }
    }

    // non-recurusive length.  Which is better?
    public int lengthIteratively() {
        IntList x = this;
        int count = 1;
        while (x.next != null) {
            count = count + 1;
            x = x.next;
        }
        return count;
    }

    // recursive 'contains'
    public boolean contains(int target) {
        if (value == target) {
            return true;
        } else if (next == null) {
            return false;
        } else {
            return next.contains(target);
        }

    }

    public int sum() {
        if (next == null) {
            return value;
        } else {
            return value + next.sum();
        }
    }

    public boolean allEven() {
        if (value % 2 != 0) {
            return false;
        } else if (next != null) {
            return next.allEven();
        } else {
            return true;
        }
    }

    public boolean allEvenIteratively() {
        IntList x = this;
        if (x.value % 2 != 0) {
            return false;
        } else {

            while (x.next != null) {
                x = x.next;
                if (x.value % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printCol() {
        if (next == null) {
            System.out.println(value + " DONE");
        } else {
            System.out.println(value);
            next.printCol();
        }
    }

    public void setNext(IntList nextNode) {
        this.next = nextNode;
    }

    public void attachTailToHead() {
        if (next == null) {
            // already at the end
        } else {
            next.attachTailToHeadHelper(this);
        }
    }

    private void attachTailToHeadHelper(IntList head) {
        if (next == null) {
            next = head;
            System.out.println("Attached tail to head!");
        } else {
            next.attachTailToHeadHelper(head);
        }

    }

    public void insert(IntList newNode) {
        newNode.next = this.next;
        this.next = newNode;
    }

    public void zip(IntList other) {
        if (next == null) {
            next = other;
        } else if (other == null) {
            return; // nothing left to insert
        } else {
            IntList origNext = next;
            IntList otherNext = other.next;
//            next = origNext.zip(otherNext);
//            next.next =
        }
    }

    public static void main(String[] args) {

//        IntNode x = makeIntNodeRandomly(1);
//        System.out.println(x.value);
//        System.out.println(x.next);
        IntList t = makeIntListRandomly(23);
        System.out.println(t);
        System.out.println("length: " + t.length());
        System.out.println("Length (iteratively): " + t.lengthIteratively());
        System.out.println("Contains 7: " + t.contains(7));
        System.out.println("Sum: " + t.sum());
        System.out.println("allEven = " + t.allEven());
        System.out.println("allEvenIteratively = " + t.allEvenIteratively());

        // Throws stack overflow
//      intListLoop();
        // So does this!
//      tailToHeadTest();
        insertTest();
    }

    public static void insertTest() {
        IntList start = makeIntListRandomly(5);
        System.out.println("Insertion test, this is the list to start: " + start);

        IntList insert = makeIntListRandomly(1);
        System.out.println("Inserting " + insert);
        start.insert(insert);

        System.out.println("New list: " + start);
    }

    public static void tailToHeadTest() {
        System.out.println("Running a tail-to-head test: ");
        IntList tailHead = makeIntListRandomly(10);

        tailHead.attachTailToHead();

        tailHead.contains(5);
    }

    public static void intListLoop() {
        System.out.println("Running a loop test:");
        IntList loop1 = new IntList(1, null);
        IntList loop2 = new IntList(2, null);
        IntList loop3 = new IntList(3, null);

        loop1.setNext(loop2);

        System.out.println(loop1);
        loop2.setNext(loop3);
        System.out.println(loop1);
        loop3.setNext(loop1);
        System.out.println(loop1);

    }
}

/*
 *  --------- ADD YOUR CODE BELOW THIS LINE ---------------
 */
