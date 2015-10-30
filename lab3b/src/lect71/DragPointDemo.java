package lect71;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Note: implements *2* listeners.  See the javadoc for each to understand which
 * method definitions below are used for which implementation
 * 
 */
public class DragPointDemo extends JPanel implements MouseMotionListener, MouseListener {

    static int i = 0;
    
    public static int WIDTH = 700;
    public static int HEIGHT = 500;

    public int pointRadius = 5;
    Point p = new Point(100, 100);

    public DragPointDemo() {
        JFrame easel = new JFrame();
        easel.setSize(WIDTH, HEIGHT);
        easel.add(this);
        easel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener (this);
        addMouseMotionListener(this);
        easel.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p.x = e.getX();
        p.y = e.getY();
        repaint();
        System.out.println("moved " + i++);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pointRadius += 10;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    public void paintComponent(Graphics g) {
        // erase
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // draw point
        g.setColor(Color.red);
        g.fillOval(p.x - pointRadius, p.y - pointRadius, pointRadius * 2, pointRadius * 2);
        // draw bullseye
        g.drawLine(p.x, 0, p.x, HEIGHT);
        g.drawLine(0, p.y, WIDTH, p.y);
    }

    public static void main(String[] args) {
        DragPointDemo d = new DragPointDemo();
    }

}
