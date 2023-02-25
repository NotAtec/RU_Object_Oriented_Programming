package geometric;

public class Shapes {
    private Geometric[] shapes = new Geometric[CAPACITY];
    private int itemCount = 0;
    private static final int CAPACITY = 10;

    public Shapes() {}

    public void addShape(Geometric shape) {
        if (itemCount < CAPACITY) {
            shapes[itemCount++] = shape;
        }
    }

    public void removeShapeByIndex(int index) {
        if(index < 0 || index > itemCount) {
            return;
        }

        shapes[index] = null;
        itemCount--;

        //close gap

        for(int i = index; i < itemCount; i++) {
            shapes[i] = shapes[i+1];
        }
    }


}
