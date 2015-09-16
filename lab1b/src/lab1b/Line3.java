package lab1b;

import java.awt.*;

public class Line3 {

    Point p1, p2;

    // returns the slope of the line.  This is a ratio of rise over run.
    double slope() {
        return ((p1.y - p2.y)/(p1.x - p2.x))
        
    }
    
    // returns true if the point given as parameters is on the line
    // algorithm: check that the lines between this point and our 
    //   other points have the same slope.
    boolean pointOnLine(int x, int y) {

    }
    
    
    // who remembers this stuff?  http://planetmath.org/anglebetweentwolines does.
    double angleTo(Line3 otherLine) {

    }

    
    
    // Use main() to test your Line1 class
    public static void main(String[] args) {
        System.out.println("testing Line3");
        // Set myLine to contain a reference to a new line object.
        Line3 myLine = new Line3();
        // Initialize myLine's x1 and y1 to the point (5, 10),
        // and initialize myLine's x2 and y2 to the point (45, 50).
        myLine.p1.x = 5;
        myLine.p1.y = 10;
        myLine.p2.x = 45;
        myLine.p2.y = 50;
        // Print the line's slope, which should be 1 (or, 45 degrees).
        System.out.println("Slope: " + myLine.slope());
        
        // check that (10,15) is on the line
        if(myLine.pointOnLine(10, 15)) {
            System.out.println(" on the line.");
        } else {
            System.out.println(" not on the line.");
        }
        
        // check that the angle between this line and another line
        //  defined by (5,10) and (10,20) is about 1/3
        
        Line3 otherLine = new Line3();
        otherLine.p1.x = 5;
        otherLine.p1.y = 10;
        otherLine.p2.x = 10;
        otherLine.p2.y = 20;
        
        System.out.println("Checking angle to other line: " + myLine.angleTo(otherLine));
    }
}
