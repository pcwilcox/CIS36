package shapes;

public class Line extends OneDimensionalShape {

    private Point start;
    private Point end;

    Line() {
        this.shapeID = nextShape();
    }

    Line(Point otherStart, Point otherEnd) {
        this.shapeID = nextShape();
        this.start = new Point(otherStart);
        this.end = new Point(otherEnd);
    }

    @Override
    public void move(int x, int y, int z) {
        this.start.move(x, y, z);
        this.end.move(x, y, z);
    }

    @Override
    public double getLength() {
        return Math.sqrt(Math.pow((start.getX() - end.getX()), 2) + Math.pow((start.getY() - end.getY()), 2) + Math.pow((start.getZ() - end.getZ()), 2));
    }

}
