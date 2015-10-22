package lect61;

import java.awt.Point;
import java.util.ArrayList;

public class Explore {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        Object p = new Point(3, 4);
        System.out.println(p.toString());
        ((Point) p).move(4, 6);
        System.out.println(p.toString());
    }

    public static void test2() {
        ArrayList<Object> container = new ArrayList<>();
        container.add(new Point(4, 3));
        container.add(new Counter());
        container.add(new Object());

        for (Object o : container) {
            System.out.println(o.toString());
        }

    }

    public static void test3() {

        Number n = new Number();
        
    }

}
