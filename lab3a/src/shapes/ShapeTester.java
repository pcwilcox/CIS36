package shapes;

import java.util.ArrayList;

public class ShapeTester {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        
        shapes.add(new Point(1, 2, 3));
        shapes.add(new Point(123, 18347, 82));
        shapes.add(new Line(new Point(1, 2, 3), new Point(8, 9, 10)));
        shapes.add(new Line(new Point(17, 18, 19), new Point(22, 21, 20)));
        shapes.add(new Circle(new Point(5, 6, 7), 10));
        shapes.add(new Circle(new Point(17, 18, 19), 22));
        shapes.add(new Sphere(new Point(0, -1, -2), 18));
        shapes.add(new Sphere(new Point(-173, 8472, 82457), 18));
        
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        
    }
       

}
