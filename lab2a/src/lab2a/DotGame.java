package lab2a;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// This program accepts clicks and draws them connected by lines.
// We'll talk about the "extends" keyword soon.
public class DotGame extends MouseListenerDrawer {

    private final int DOT_RADIUS = 5;  // make this bigger if it comes out tiny on your screen
    private ArrayList<Point> points;
    private boolean closed = false;
    private ArrayList<Line> linesShown;
    private ArrayList<Line> linesHidden;

    public DotGame() {
        points = new ArrayList<>();
    }

    // This gets called whenever the user presses their mouse button in the window
    public void mousePressed(MouseEvent event) {
        // where did the user click?
        Point p_clicked = new Point(event.getX(), event.getY());

        if (closed == true) {
            lineFlip(p_clicked);
        }

        if ((points.size() > 0) && (closeTo(p_clicked, points.get(0)) == true)) {
            closed = true;
            repaint();
        } else if (closed == false) {
            points.add(p_clicked);
            // always redraw the screen
            repaint();
        }

    }
    
    private void lineFlip(Point p) {
        
    }

    // This gets called whenever Java needs to draw to the window.  
    //   Basic method: first erase the window, then redraw it.  Simple!
    public void paintComponent(Graphics g) {
        // erase the window
        erase(g);

        if (closed == false && points.size() > 1) {
            int thisPoint = points.size() - 1;
            int lastPoint = points.size() - 2;
            
            Line newLine = new Line(points.get(lastPoint), points.get(thisPoint));
            linesShown.add(newLine);
        }
        // draw everything
        int lastIndex = points.size() - 1;
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            drawPoint(g, p, Color.red);
            if (i != lastIndex) {
                drawLine(g, p, points.get(i + 1));
                
            }

            if (closed == true && i == lastIndex) {
                drawLine(g, p, points.get(0));
            }
        }
    }

    ///////// point methods
    // returns true if the two points are "close".  Use this method to check
    //  if a point has been clicked on again
    private boolean closeTo(Point p1, Point p2) {
        return (distanceBetween(p1, p2) < DOT_RADIUS);
    }

    // returns the distance between two points
    private double distanceBetween(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    ///////// drawing methods
    // this one draws a black point
    private void drawPoint(Graphics g, Point p) {
        drawPoint(g, p, Color.black);
    }

    // this one draws a point with a certain color 
    private void drawPoint(Graphics g, Point p, Color c) {
        g.setColor(c);
        g.fillOval(p.x - DOT_RADIUS, p.y - DOT_RADIUS, DOT_RADIUS * 2, DOT_RADIUS * 2);
    }

    //draws a black line
    private void drawLine(Graphics g, Point p1, Point p2) {
        drawLine(g, p1, p2, Color.black);
    }

    // draws a line of a certain color
    private void drawLine(Graphics g, Point p1, Point p2, Color c) {
        g.setColor(c);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    public static void main(String[] args) {
        DotGame me = new DotGame();
    }

}
