package lab2a;

import java.util.ArrayList;

public class Zip {

    public static void main(String[] args) {

        zipperIntTester();
        zipperListTester();
    }

    public static void zipperListTester() {
        System.out.println("Testing with null (ListTest1):");
        zipperListTest1(); //null
        System.out.println("Testing with right null (ListTest2):");
        zipperListTest2(); // [1, 2, 3, 4, 5, 6], [null]
        System.out.println("Testing with two arrays (ListTest3):");
        zipperListTest3(); // [1, 2, 3] [4, 5, 6]
        System.out.println("Testing with left null (ListTest4):");
        zipperListTest4(); // [null], [1, 2, 3, 4, 5, 6]
    }

    public static void zipperListTest1() {
        ArrayList<Integer> zipped = zipperList(null, null);
        System.out.println(zipped.toString());
    }

    public static void zipperListTest2() {
        ArrayList<Integer> left = new ArrayList();
        for (int i = 0; i < 6; i++) {
            left.add(i + 1);
        }
        ArrayList<Integer> zipped = zipperList(left, null);
        System.out.println(zipped.toString());
    }

    public static void zipperListTest4() {
        ArrayList<Integer> right = new ArrayList();
        for (int i = 0; i < 6; i++) {
            right.add(i + 1);
        }
        ArrayList<Integer> zipped = zipperList(null, right);
        System.out.println(zipped.toString());
    }

    public static void zipperListTest3() {
        ArrayList<Integer> left = new ArrayList();
        ArrayList<Integer> right = new ArrayList();
        
        for (int i = 0; i < 12; i += 2) {
            left.add(i);
            right.add(i + 1);
        }
        
        ArrayList<Integer> zipped = zipperList(left, right);
        System.out.println(zipped.toString());
    }

    public static void zipperIntTester() {
        System.out.println("Testing with null:");
        zipperIntTest1(); //null
        System.out.println("Testing with right null:");
        zipperIntTest2(); // [1, 2, 3, 4, 5, 6], [null]
        System.out.println("Testing with two arrays:");
        zipperIntTest3(); // [1, 2, 3] [4, 5, 6]
        System.out.println("Testing with left null:");
        zipperIntTest4(); // [null], [1, 2, 3, 4, 5, 6]

    }

    public static void zipperIntTest1() {

        int[] left = {};
        int[] right = {};

        int[] zipped = zipperInt(left, right);
        for (int i = 0; i < zipped.length; i++) {
            System.out.print(zipped[i] + " ");
            System.out.println("");
        }
        if (zipped.length == 0) {
            System.out.println("null");
        }
    }

    public static void zipperIntTest2() {
        int[] left = {1, 2, 3, 4, 5, 6};
        int[] right = {};

        int[] zipped = zipperInt(left, right);
        for (int i = 0; i < zipped.length; i++) {
            System.out.print(zipped[i] + " ");
            System.out.println("");
        }
        if (zipped.length == 0) {
            System.out.println("null");
        }
    }

    public static void zipperIntTest3() {

        int[] left = {1, 2, 3};
        int[] right = {4, 5, 6};

        int[] zipped = zipperInt(left, right);
        for (int i = 0; i < zipped.length; i++) {
            System.out.print(zipped[i] + " ");
            System.out.println("");
        }
        if (zipped.length == 0) {
            System.out.println("null");
        }
    }

    public static void zipperIntTest4() {

        int[] left = {};
        int[] right = {1, 2, 3, 4, 5, 6};

        int[] zipped = zipperInt(left, right);
        for (int i = 0; i < zipped.length; i++) {
            System.out.print(zipped[i] + " ");
            System.out.println("");
        }
        if (zipped.length == 0) {
            System.out.println("null");
        }
    }

    public static int[] zipperInt(int[] left, int[] right) {
        if (left == null && right == null) {
            int[] zipped = new int[0];
            return zipped;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        int[] zipped = new int[left.length + right.length];

        int j = 0, k = 0;

        for (int i = 0; i < zipped.length; i++) {
            if (i % 2 == 0) {
                // grab from left
                if (j < left.length) {
                    zipped[i] = left[j];
                    j++;
                } else {
                    zipped[i] = right[k];
                    k++;
                }

            } else {
                // grab from right
                if (k < right.length) {
                    zipped[i] = right[k];
                    k++;
                } else {
                    zipped[i] = left[j];
                    j++;
                }
            }
        }
        return zipped;
    }

    public static ArrayList<Integer> zipperList(ArrayList<Integer> left, ArrayList<Integer> right) {
        if (left == null && right == null) {
            ArrayList<Integer> zipped = new ArrayList<>(0);
            return zipped;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        ArrayList<Integer> zipped = new ArrayList<>();

        int j = 0, k = 0;

        for (int i = 0; i < (left.size() + right.size()); i++) {
            if (i % 2 == 0) {
                // grab from left
                if (j < left.size()) {
                    zipped.add(left.get(j));
                    j++;
                } else {
                    zipped.add(right.get(k));
                    k++;
                }

            } else {
                // grab from right
                if (k < right.size()) {
                    zipped.add(right.get(k));
                    k++;
                } else {
                    zipped.add(left.get(j));
                    j++;
                }
            }
        }
        return zipped;
    }

}
