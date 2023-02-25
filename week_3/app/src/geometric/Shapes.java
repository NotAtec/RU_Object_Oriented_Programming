package geometric;
import java.util.Arrays;

/**
 * We can store different kinds of geometric shaps
 * in an array with this shapes class.
 * @author Jeroen Brinkhorst (s1101799) and Floris Reuvers (s1096976)
 */

public class Shapes {
    private Geometric[] shapes = new Geometric[CAPACITY];
    private int itemCount = 0;
    private static final int CAPACITY = 10;
    private String name;

    public Shapes(String name){
        this.name = name;
    }

   public void addShape(Geometric shape) {
        if(itemCount < CAPACITY) {
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

    public void sortShapesByArea() {
        Arrays.sort(shapes, 0, itemCount);
    }

    public void sortShapesByLeftMostPoint() {
        Arrays.sort(shapes, 0, itemCount, new LeftComparator());
    }

    public void sortShapesByBottomPoint() {
        Arrays.sort(shapes, 0, itemCount, new BottomComparator());
    }

}
