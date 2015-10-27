
package lect51;

public class ModNCounter2 extends Counter{
    
    private int modulus;
    
    public ModNCounter2(int modulus) {
        super();
        this.modulus = modulus;
    }
    
    @Override
    public int getValue() {
        return (super.getValue() % modulus);
    }
    
}
