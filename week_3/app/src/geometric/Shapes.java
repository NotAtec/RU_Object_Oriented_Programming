package geometric;
import java.util.Arrays;

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

    public Geometric[] getShapes() {
        return shapes;
    }

    public Geometric find(int i) {
        return shapes[i];
    }

    public void sortShapesByArea() {
        Arrays.sort(shapes, 0, itemCount, new AreaComparator());
    }

    public void sortShapesByLeftMostPoint() {
        Arrays.sort(shapes, 0, itemCount, new XComparator());
    }

    public void sortShapesByBottomPoint() {
        Arrays.sort(shapes, new YComparator());
    }
}
