package lect61.staticBindingExample;

public class Tester {
    public static void main(String[] args) {
        teststatic();
        //testhandout();      
    }
    
    public static void teststatic() {
        // testing static binding of static methods
        Superclass sup = new Superclass();
        System.out.println("Superclass name is " + sup.getName());
        sup.describe();
        
        Subclass sub = new Subclass();
        System.out.println("Subclass name is " + sub.getName());
        sub.describe();   // uh oh, static binding of Superclass.getName();
    }
     
    public static void testhandout() {
        // testing polymorphism handout
        Superclass obj1 = new Subclass();
        obj1.print();
        
        //Subclass obj2 = new Superclass();
        
        Superclass obj3 = new Superclass();
        //((Subclass) obj3).print();

        
        Subclass obj4 = new Subclass();
        ((Superclass) obj4).print();

    }
            
}
