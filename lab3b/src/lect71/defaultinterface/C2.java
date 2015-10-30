package lect71.defaultinterface;

public class C2 implements A, B {
    
    public void doit() {
        B.super.doit();
    }
    
}
