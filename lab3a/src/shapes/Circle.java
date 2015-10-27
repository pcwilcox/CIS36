package shapes;

public class Circle extends TwoDimensionalShape {

    private double radius;
    private Point center;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        if (newRadius < 0) {
            System.out.println("Radius cannot be less than 0.");
        } else {
            this.radius = newRadius;
        }
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));
    }

    Circle() {
        this.shapeID = nextShape();
    }

    Circle(Point newCenter) {
        this.shapeID = nextShape();
        this.center = new Point(newCenter);
    }

    Circle(Point newCenter, double newRadius) {
        this.shapeID = nextShape();
        this.center = new Point(newCenter);
        this.radius = Math.abs(newRadius);
    }

    @Override
    public void move(int x, int y, int z) {
        this.center.move(x, y, z);
    }
}
