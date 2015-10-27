package lect51;

public class Counter {

    private int myCount;

    public Counter() {
        myCount = 0;
    }

    public void increment() {
        myCount++;
    }

    public int getValue() {
        return myCount;
    }
    
    public void setValue(int newValue) {
        myCount = newValue;
    }    
}
