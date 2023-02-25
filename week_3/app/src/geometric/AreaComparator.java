package geometric;
import java.util.Comparator;

public class AreaComparator implements Comparator<Geometric> {
    @Override
    public int compare(Geometric o1, Geometric o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
