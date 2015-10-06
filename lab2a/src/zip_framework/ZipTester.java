package zip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ZipTester {

    public static void main(String[] args) {
        test1();
        test2();
        // write more tests, please!
        //test3();
        //test4();

        // condier using getArrayFromUser() and getArrayListFromUser()
    }

    public static void test1() {
        int[] a = {1, 2, 3};
        int[] b = {11, 12, 13};
        int[] correct = {1, 11, 2, 12, 3, 13};
        testZip(a, b, correct);
    }

    public static void test2() {
        ArrayList<Integer> a = makeArrayList(1, 2, 3);
        ArrayList<Integer> b = makeArrayList(11, 12, 13);
        ArrayList<Integer> correct = makeArrayList(1, 11, 2, 12, 3, 13);
        testZip(a, b, correct);
    }
    
    
    
    
    
    ///////////////////////
    // some helper methods you might use

    // creates an ArrayList<Integer> from the arguments passed in.  Uses Java's variables number of parameters
    public static ArrayList<Integer> makeArrayList(int... array) {
        ArrayList<Integer> alist = new ArrayList<>();
        for (int x : array) {
            alist.add(x);    // autoboxing
        }
        return alist;
              
    }
    
    
    
    // Reports on running 'zip' on two arrays, comparing with known correctAnswer.
    public static void testZip(int[] a1, int[] a2, int[] correctAnswer) {
        int[] answer = Zip.zip(a1, a2);
        if (Arrays.equals(answer, correctAnswer)) {
            // got it right
            System.out.println("CORRECT: zip " + Arrays.toString(a1) + " + " + Arrays.toString(a2));
        } else {
            System.err.println("INCORRECT: zip " + Arrays.toString(a1) + " + " + Arrays.toString(a2) + " got incorrect answer " + Arrays.toString(answer));
        }
    }

    public static void testZip(ArrayList<Integer> a1, ArrayList<Integer> a2, ArrayList<Integer> correctAnswer) {
        ArrayList<Integer> answer = Zip.zip(a1, a2);
        if (answer.equals(correctAnswer)) {
            // got it right
            System.out.println("CORRECT: zip " + a1 + " + " + a2);
        } else {
            System.err.println("INCORRECT: zip " + a1 + " + " + a2 + " got incorrect answer " + answer);            
        }
    }

    
    
    
    
    // This method lets the user input a sequence of integers and returns as ArrayList
    public static ArrayList<Integer> getArrayListFromUser() {
        Scanner keyboardInput = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter some numbers, with white space or returns between entries.  Enter empty line to finish.");
        boolean quit = false;
        do {
            System.out.print("Index " + numbers.size() + ": ");
            String input = keyboardInput.nextLine();    // get an entire line
            if (input.isEmpty()) {
                quit = true;                            // quit if the line is empty
            } else {
                Scanner stringInput = new Scanner(input);  // otherwise, process line of input using *another* scanner
                while (stringInput.hasNextInt()) {
                    int num = stringInput.nextInt();
                    numbers.add(num);
                }
            }
        } while (!quit);
        System.out.println(" -- got array of length " + numbers.size());
        return numbers;
    }

    // This method lets the user input an seequence of integers and returns as an array.
    public static int[] getArrayFromUser() {
        ArrayList<Integer> numbers = getArrayListFromUser();
        // convert ArrayList<Integer> to int[]
        int[] output = new int[numbers.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = numbers.get(i);
        }
        return output;
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
