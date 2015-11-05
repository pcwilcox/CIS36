/*
 * lab3c
 * recursion
 * PathCount.java
 * Created by Pete Wilcox on Nov 4, 2015
 * petercwilcox@gmail.com
 * Copyright © 2015 Pete Wilcox. All rights reserved.
 */
package recursion;

public class PathCount {

    public static int pathCount(int n, int k) {

        if (n == 0 || k == 0) {
            return 1;
        } else {
            return pathCount(n - 1, k) + pathCount(n, k - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("pathCount(3, 4): " + pathCount(3, 4));
    }
}
