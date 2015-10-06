package lab2a;

public class Zip {
    public static void main(String[] args) {
        
        int[] left = {1, 2, 3};
        int[] right = {11, 12, 13};
        
        int[] zipped = zipArray(left, right);
        for (int i = 0; i < zipped.length; i++) {
            System.out.print(zipped[i] + " ");
        }
    }
    
    public static int[] zipArray(int[] arrayFirst, int[] arraySecond) {
        int[] arrayReturn = new int[arrayFirst.length + arraySecond.length];
        
        for (int i = 0, left = 0, right = 0; i < arrayReturn.length; i++) {
            if (left == right && left < arrayFirst.length) {
                arrayReturn[i] = arrayFirst[left];
                left++;
            } else if (right < left && right < arraySecond.length) {
                arrayReturn[i] = arraySecond[left];
                right++;
            }
        }
        return arrayReturn;
    }
}
