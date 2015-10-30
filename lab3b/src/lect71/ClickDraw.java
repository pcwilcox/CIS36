package lect71;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// This program accepts clicks and draws them connected by lines.
public class ClickDraw extends MouseListenerDrawer {
    
    // Declaration of an ArrayList of Point objects goes here.
    ArrayList<Point> points;
    
    public ClickDraw ( ) {
        // Initialization of an ArrayList of Point objects goes here.
        points = new ArrayList<>();
    }
    
    
    public void mousePressed (MouseEvent event) {
        Point p = new Point (event.getX ( ), event.getY ( ));
        
        if (!removedIfExists(p)) {
            points.add(p);
        }
        
        repaint ( );
    }
    
    
    private boolean removedIfExists(Point p) {
        for (Point p_exists : points) {
            if (closeTo(p, p_exists)) {
                points.remove(p_exists);
                return true;
            }
        }
        return false;
    }
    

    public void paintComponent (Graphics g) {
        erase(g);
        
//        for (Point p : points) {
//            drawPoint(g, p);
//        }
        int lastIndex = points.size() - 1;
        for (int i=0; i<points.size(); i++) {
            Point p = points.get(i);
            // move drawPoint() here
            drawPoint(g, p);
            if (i != lastIndex) {
                drawLine(g,p,points.get(i+1));
            }
        }

    }
    
    
    private void drawPoint(Graphics g, Point p) {
        g.fillOval(p.x-5, p.y-5, 10, 10);
    }
    
    private void drawLine(Graphics g, Point p1, Point p2) {
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    
    private boolean closeTo (Point p1, Point p2) {
        return Math.abs (p1.x-p2.x) < 4 && Math.abs (p1.y-p2.y) < 4;
    }
       
    
    
    public static void main(String[] args) {
        ClickDraw me = new ClickDraw();
    }

}