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
    public void move(double x, double y, double z) {
        this.center.move(x, y, z);
    }

    @Override
    public String toString() {
        String details = "Circle: " + this.getID() + "\n Center: " + this.center + "\n Radius: " + this.radius + "\n Area: " + this.getArea();
        return details;
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));
    }

    Circle() {
        this.shapeID = nextShape();
        this.center = new Point();
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
    
    Circle(Circle otherCircle) {
        this.shapeID = nextShape();
        this.center = new Point(otherCircle.center);
        this.radius = otherCircle.radius;
    }
}
