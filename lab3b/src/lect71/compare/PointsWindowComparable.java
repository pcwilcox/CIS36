package lect71.compare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PointsWindowComparable extends JPanel implements MouseListener {

    public static int WIDTH = 700;
    public static int HEIGHT = 500;
    ArrayList<ComparablePoint> points = new ArrayList<>();

    public PointsWindowComparable() {
        JFrame easel = new JFrame();
        easel.setSize(WIDTH, HEIGHT);
        easel.add(this);
        easel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        easel.setVisible(true);
    }

    private void sort() {
        System.out.println("sorting...");
        Collections.sort(points);
    }

    /// standard stuff.  
    public void paintComponent(Graphics g) {
        // erase
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // draw points connected by lines
        int lastIndex = points.size() - 1;
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            drawPoint(g, p);
            if (i != lastIndex) {
                drawLine(g, p, points.get(i + 1));
            }
        }
    }

    private void drawPoint(Graphics g, Point p) {
        g.setColor(Color.red);
        g.fillOval(p.x - 5, p.y - 5, 10, 10);
    }

    private void drawLine(Graphics g, Point p1, Point p2) {
        g.setColor(Color.blue);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    
    
    
    //// mouse listener
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isShiftDown()) {
            sort();
        } else {
            ComparablePoint p = new ComparablePoint(e.getX(), e.getY());
            points.add(p);
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    Observable obs = new Observable() {

    };

    public static void main(String[] args) {
        PointsWindowComparable d = new PointsWindowComparable();
    }

    
    
    
    
}
