
package lect51;

public class ResettableCounter extends Counter {
    
    public void reset() {
        setValue(0);
    }

    public void increment() {
        System.out.println("I won't!");
    }
}
