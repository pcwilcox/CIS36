package lect51;

public class Explore {

    public static void main(String[] args) {


//        ResettableCounter c = new ResettableCounter();
//        System.out.println("C: " + c.getValue());
//        c.increment();
//        c.increment();
//        System.out.println("C: " + c.getValue());
//        c.reset();
//        System.out.println("C: " + c.getValue());

        ModNCounter mnc = new ModNCounter(3);
        //mnc.setModule(3);
        System.out.println("value: " + mnc.getValue());
        for (int i=1; i<10; i++) {
            mnc.increment();
            System.out.println("i: " + i + ", value: " + mnc.getValue());
        }
    }

}
