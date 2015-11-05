/*
 * lab3c
 * recursion
 * intList.java
 * Created by Pete Wilcox on Nov 4, 2015
 * petercwilcox@gmail.com
 * Copyright © 2015 Pete Wilcox. All rights reserved.
 */
package recursion;

import java.util.Random;

public class IntList {

    public class IntNode {

        private int value;
        private IntNode next = null;

        IntNode(int value, IntNode next) {
            this.value = value;
            this.next = next;
        }

        public IntNode makeRandomNode(int count) {
            Random r = new Random();

            if (count > 0) {
                return new IntNode(r.nextInt(100), makeRandomNode(count - 1));
            } else {
                return null;
            }
        }

        @Override
        public String toString() {
            return "(" + this.toStringHelper() + ")";
        }

        public String toStringHelper() {
            if (this.next == null) {
                return Integer.toString(value);
            } else {
                return Integer.toBinaryString(value) + ", " + next.toStringHelper();
            }
        }

        public int length() {
            if (next == null) {
                return 1;
            } else {
                return 1 + next.length();
            }
        }

        public boolean contains(int target) {
            if (value == target) {
                return true;
            } else if (next == null) {
                return false;
            } else {
                return next.contains(target);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Make a linked list of some stuff, let's say 50.");

        //IntList t = 
    }

}
