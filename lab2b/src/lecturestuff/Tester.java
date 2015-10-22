package lect61.selfTestPolymorphism;

public class Tester {
    
    public static void main(String[] args) {
        
        System.out.println("Q1");
        Superclass obj1 = new Subclass();
        obj1.print();
        
        System.out.println("Q2");
        //Subclass obj2 = new Superclass();
        
        System.out.println("Q3");
        Superclass obj3 = new Superclass();
        //((Subclass) obj3).print();
        
        System.out.println("Q4");
        Subclass obj4 = new Subclass();
        ((Superclass) obj4).print();
        
        
    }
    
}
