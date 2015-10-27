package shapes;

public abstract class Shape {

    private static int nextShapeID = 0;
    protected int shapeID;

    public abstract void move(int x, int y, int z);

    public int getID() {
        return shapeID;
    }

    public static int nextShape() {
        return nextShapeID++;
    }

}
