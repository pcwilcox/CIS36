package lect71.defaultinterface;

public interface A {

    default void doit() {
        System.out.println("Calling A.doit()");
    }

}
