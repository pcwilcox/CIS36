package shapes;

public class Line extends OneDimensionalShape {
    
    private Point start;
    private Point end;
    
    public Point getStart() {
        return this.start;
    }
    
    public void setStart(int x, int y, int z) {
        this.start.move(x, y, z);
    }
    
    public void setStart(Point p) {
        this.start.move(p);
    }
    
    public Point getEnd() {
        return this.end;
    }
    
    public void setEnd(int x, int y, int z) {
        this.end.move(x, y, z);
    }
    
    public void setEnd(Point p) {
        this.end.move(p);
    }
    
    @Override
    public void move(int x, int y, int z) {
        this.start.move(x, y, z);
        this.end.move(x, y, z);
    }
    
    @Override
    public String toString() {
        String details = "Line: " + this.getID() + "\n Start: " + this.start + ", End: " + this.end + "\n Length: " + this.getLength();
        return details;
    }
    
    @Override
    public double getLength() {
        double xDif = Math.pow((end.getX() - start.getX()), 2);
        double yDif = Math.pow((end.getY() - start.getY()), 2);
        double zDif = Math.pow((start.getZ() - end.getZ()), 2);
        return Math.sqrt(xDif + yDif + zDif);
    }
    
    Line() {
        this.shapeID = nextShape();
        this.start = new Point();
        this.end = new Point();
    }
    
    Line(Point otherStart, Point otherEnd) {
        this.shapeID = nextShape();
        this.start = new Point(otherStart);
        this.end = new Point(otherEnd);
    }
    
    Line(Line otherLine) {
        this.shapeID = nextShape();
        this.start = new Point(otherLine.start);
        this.end = new Point(otherLine.end);
    }
}
