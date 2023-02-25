package geometric;

import java.util.Comparator;

/*
*  Comparator class that defines an order on Geometrics based on the lowest y-coordinate
 * @author Jeroen Brinkhorst (s1101799) and Floris Reuvers (s1096976)
 */

public class BottomComparator implements Comparator<Geometric> {
    @Override
    public int compare(Geometric o1, Geometric o2) {
        return Double.compare(o1.bottomBorder(), o2.bottomBorder());
    }
}
