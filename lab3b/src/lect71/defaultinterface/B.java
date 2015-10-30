package lect71.defaultinterface;

public interface B {

    default void doit() {
        System.out.println("Calling B.doit()");
    }

}
