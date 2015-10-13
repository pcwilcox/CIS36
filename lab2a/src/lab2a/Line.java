package lab2a;

import java.awt.*;

public class Line {

    private Point p1;
    private Point p2;
    private boolean toBeFlipped;

    
    public boolean pointOnLine(Point p) {

        return (pointMatch(p));
    }

    private boolean pointMatch(Point p) {
        if ((p.x == p1.x) && (p.y == p1.y)) {
            return true;
        } else if ((p.x == p2.x) && (p.y == p2.y)) {
            return true;
        } else {
            return false;
        }
    }

    
    public void setFlip(Boolean flip) {
        toBeFlipped = flip;
    }

    public boolean getFlip() {
        return toBeFlipped;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    Line(Point start, Point end) {
        p1.x = start.x;
        p1.y = start.y;

        p2.x = end.x;
        p2.y = end.y;
        toBeFlipped = false;
    }
}
