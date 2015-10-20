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
        linesShown = new ArrayList<>();
        linesHidden = new ArrayList<>();
    }

    // This gets called whenever the user presses their mouse button in the window
    @Override
    public void mousePressed(MouseEvent event) {
        // where did the user click?
        Point p_clicked = new Point(event.getX(), event.getY());

        if (closed == true) {

            for (Point posPoint : points) {
                if (closeTo(p_clicked, posPoint) == true) {
                    p_clicked = posPoint;
                }

            }
            lineFlip(p_clicked);
            repaint();
        } else if ((points.size() > 0) && (closeTo(p_clicked, points.get(0)) == true)) {
            closed = true;
            repaint();
        } else {
            points.add(p_clicked);
            // always redraw the screen
            repaint();
        }

    }

    private void lineFlip(Point p) {
        // draw linesShown

        for (Line line : linesShown) {
            if (line.pointOnLine(p) == true) {
                line.setFlip(true);
            }
        }

        for (Line line : linesHidden) {
            if (line.pointOnLine(p) == true) {
                line.setFlip(true);
            }
        }

        for (int i = 0; i < linesShown.size(); i++) {
            if (linesShown.get(i).getFlip() == true) {
                linesHidden.add(linesShown.get(i));
                linesHidden.get(linesHidden.size() - 1).setFlip(false);
                linesShown.remove(i);
                i--;
            }
        }

        for (int i = 0; i < linesHidden.size(); i++) {
            if (linesHidden.get(i).getFlip() == true) {
                linesShown.add(linesHidden.get(i));
                linesShown.get(linesShown.size() - 1).setFlip(false);
                linesHidden.remove(i);
                i--;
            }
        }

    }

    // This gets called whenever Java needs to draw to the window.  
    //   Basic method: first erase the window, then redraw it.  Simple!
    @Override
    public void paintComponent(Graphics g) {
        // erase the window
        erase(g);

        // draw points
        for (Point p : points) {
            drawPoint(g, p, Color.red);
        }

        // add lines until the system is closed
        if (closed == false && points.size() > 1) {
            int thisPoint = points.size() - 1;
            int lastPoint = points.size() - 2;
            Point lineStart = points.get(lastPoint);

            Point lineEnd = points.get(thisPoint);

            Line newLine = new Line(lineStart, lineEnd);
            linesShown.add(newLine);

            for (int i = 0; i < points.size() - 2; i++) {
                Line otherLine = new Line(points.get(i), points.get(thisPoint));
                linesHidden.add(otherLine);
            }
        }

        if (closed == true) {
            int lastPoint = points.size() - 1;
            Point lineStart = points.get(lastPoint);
            Point lineEnd = points.get(0);

            Line newLine = new Line(lineStart, lineEnd);
            linesShown.add(newLine);
            for (int i = 0; i < linesHidden.size(); i++) {
                if (newLine.equals(linesHidden.get(i)) == true) {
                    linesHidden.remove(i);
                }
            }
        }

        // draw visible lines
        for (Line showLine : linesShown) {

                drawLine(g, showLine.getStart(), showLine.getEnd(), Color.black);
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
