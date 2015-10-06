package lab2a;

public class Zip {

    public static void main(String[] args) {

        zipperIntTester();
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
}
