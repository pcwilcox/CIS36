/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class MotorcycleTester {
    public static void main (String args[]) {
        Motorcycle m = new Motorcycle();
        m.make = "Yamaha RZ350";
        m.color = "blue";
        m.showAtts();
        
        System.out.println("_____");
        System.out.println("Starting engine...");
        m.startEngine();
        m.startEngine();
        
        System.out.println("_____");
        m.showAtts();
        
        System.out.println("______");
        m.stopEngine();
        m.stopEngine();
    }
}
