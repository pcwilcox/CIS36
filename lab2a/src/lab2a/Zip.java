package lab2a;

public class Zip {
    public static void main(String[] args) {
        
        int[] left = {};
        int[] right = {};
        
        int[] zipped = zipperInt(left, right);
        for (int i = 0; i < zipped.length; i++) {
            System.out.print(zipped[i] + " ");
        }
        if(zipped.length == 0) {
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
                if(j < left.length) {
                    zipped[i] = left[j];
                    j++;
                } else {
                    zipped[i] = right[k];
                    k++;
                }
                
            } else {
                // grab from right
                if(k < right.length) {
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
