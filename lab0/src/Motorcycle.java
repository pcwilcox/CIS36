/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class Motorcycle {
    String make;
    String color;
    boolean engineState;
    
    void startEngine() {
        if (engineState == true) {
            System.out.println("The engine is already on.");
        } else {
            engineState = true;
            System.out.println("The engine is now on.");
        }
    }
    
    void showAtts() {
        System.out.println("This motorcycle is a " + color + " " + make);
        if (engineState == true) {
            System.out.println("The engine is on.");
        } else {
            System.out.println("The engine is off.");
        }
    }
    
    void stopEngine() {
        if (engineState == false) {
            System.out.println("The engine is already off.");
        } else {
            engineState = false;
            System.out.println("The engine is now off.");
        }
    }
}
