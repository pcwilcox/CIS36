package lect61.staticBindingExample;

public class Superclass {
        
    public void describe() {
        System.out.println("I'm a " + getName());
    }
    
    public  String getName() {
        return("superclass");
    }
    
    
    public void print() {
        System.out.println("super");
    }
    
}
