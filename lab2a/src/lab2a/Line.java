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

    public Point getStart() {
        return p1;
    }

    public Point getEnd() {
        return p2;
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

    public boolean equals(Line otherLine) {
        return (otherLine.pointOnLine(p1) && otherLine.pointOnLine(p2));
    }

    Line(Point start, Point end) {
        p1 = new Point();
        p2 = new Point();

        p1.x = start.x;
        p1.y = start.y;

        p2.x = end.x;
        p2.y = end.y;
        toBeFlipped = false;
    }
}
