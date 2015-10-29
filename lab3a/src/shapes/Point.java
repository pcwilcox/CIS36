package shapes;

public class Point extends ZeroDimensionalShape {

    private double x;
    private double y;
    private double z;

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        String details = "Point: " + this.getID() + "\n X: " + this.x + ", Y: " + this.y + ", Z: " + this.z;
        return details;
    }

    @Override
    public void move(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void move(Point p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }

    public boolean equals(Point otherPoint) {
        return (this.x == otherPoint.getX() && this.y == otherPoint.getY() && this.z == otherPoint.getZ());
    }

    Point() {
        this.shapeID = nextShape();
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Point(Point otherPoint) {
        this.shapeID = nextShape();
        this.x = otherPoint.getX();
        this.y = otherPoint.getY();
        this.z = otherPoint.getZ();
    }

    Point(double x, double y, double z) {
        this.shapeID = nextShape();
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
