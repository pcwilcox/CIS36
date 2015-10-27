package shapes;

public class Sphere extends ThreeDimensionalShape {

    private double radius;
    private Point center;

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return this.center;
    }

    @Override
    public String toString() {
        String details = "Sphere: " + this.getID() + ", Center: " + this.center + ", Radius: " + this.radius + ", Volume: " + this.getVolume();
        return details;
    }

    public boolean equals(Sphere otherSphere) {

        return (this.center.equals(otherSphere.getCenter()) && this.radius == otherSphere.getRadius());

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

    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(radius, 3));
    }

    Sphere() {
        this.shapeID = nextShape();
    }

    Sphere(Point newCenter) {
        this.shapeID = nextShape();
        this.center = new Point(newCenter);
    }

    Sphere(Point newCenter, double newRadius) {
        this.shapeID = nextShape();
        this.center = new Point(newCenter);
        this.radius = Math.abs(newRadius);
    }

    @Override
    public void move(int x, int y, int z) {
        this.center.move(x, y, z);
    }
}
