
package lect71.compare;

import java.awt.Point;

public class ComparablePoint extends Point implements Comparable<Point> {
    
    public ComparablePoint(int x, int y) {
        super(x,y);
    }


    public int compareTo(Point p) {
        
        return this.y - p.y;
        
//        if (this.x == p.x) {
//            return 0;
//        } else if (this.x < p.x) {
//            return -1;
//        } else {
//            return 1;
//        }
    }
    


    
}
