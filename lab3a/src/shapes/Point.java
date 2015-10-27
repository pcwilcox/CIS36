package shapes;

public class Point extends ZeroDimensionalShape {

    private int x;
    private int y;
    private int z;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean equals(Point otherPoint) {
        return (this.x == otherPoint.getX() && this.y == otherPoint.getY() && this.z == otherPoint.getZ());
    }

    Point() {
        this.shapeID = nextShape();
    }

    @Override
    public void move(int x, int y, int z) {

    }

}
