package lect51;

public class ModNCounter extends Counter {
    
    private int modulus;
    
    public ModNCounter(int modulus) {
        super();
        this.modulus = modulus;
    }
    
    @Override
    public void increment() {
        if (getValue() == (modulus - 1)) {
            setValue(0);
        } else {
            super.increment();
        }
    }
    
    

    
    
}
