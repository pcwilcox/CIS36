package shapes;

public class Sphere extends ThreeDimensionalShape {

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

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(int x, int y, int z) {
        this.move(x, y, z);
    }

    public void setCenter(Point p) {
        this.center.move(p);
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(radius, 3));
    }

    @Override
    public void move(int x, int y, int z) {
        this.center.move(x, y, z);
    }

    @Override
    public String toString() {
        String details = "Sphere: " + this.getID() + "\n Center: " + this.center + "\n Radius: " + this.radius + "\n Volume: " + this.getVolume();
        return details;
    }

    public boolean equals(Sphere otherSphere) {

        return (this.center.equals(otherSphere.getCenter()) && this.radius == otherSphere.getRadius());

    }

    Sphere() {
        this.shapeID = nextShape();
        this.center = new Point();
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
    
    Sphere(Sphere s) {
        this.shapeID = nextShape();
        this.center = new Point(s.center);
        this.radius = s.radius;
    }

}
