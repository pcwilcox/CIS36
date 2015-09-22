/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1c;

/**
 *
 * @author Student
 */
public class NameTest {
    public static void main(String[] args) {
        Name johnson = new Name("Johnson");
        
        System.out.println("Hello, my name is " + johnson.name());
        
        Name jill = new Name("Jane", "Deere", 2);
        
        System.out.print("Hello, my name is " + jill.name() + " and I am a ");
        
        if(jill.gender() == 2) {
            System.out.println("girl.");
        } else {
            System.out.println("boy.");
        }
        
        Name sam = new Name("Sam", "Houston", 1);
        
        System.out.println("My name is " + sam.name() + " and my initials are " + sam.initials() + ".");
        
        Name jessica = new Name("Jessica", "Simpson", 2);
        
        System.out.println("My name is " + jessica.name() + " and I like pig latin, so call me " + jessica.pigLatinName() + ".");
        
        Name steven = new Name("Steven", "Tyler", 2);
        
        System.out.println("My name is " + steven.name() + " and I like pig latin, so call me " + steven.pigLatinName() + ".");
        
        Name ermey = new Name("R Lee", "Ermey", 1);
        
        System.out.println(ermey.rollCallName() + " reporting!");
    }
}
