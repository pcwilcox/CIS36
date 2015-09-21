/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1a;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class CircleArea {
    
    public static void main(String[] arg) {
        double radius;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the desired radius: ");
        
        radius = input.nextDouble();

        System.out.println("The area of a circle with radius " + radius + " is: " + (Math.PI * radius * radius));
        System.out.println("The circumference of a circle with radius " + radius + " is: " + (Math.PI * radius * 2));

        System.out.println("The volume of a sphere with radius " + radius + " is: " + ((4 * Math.PI * radius * radius * radius) / 3));
        System.out.println("The surface area of a sphere with radius " + radius + " is: " + (4 * Math.PI * radius * radius));
    }
    
}

    
