package geometric;
import java.util.Comparator;

public class YComparator implements Comparator<Geometric>{
    @Override
    public int compare(Geometric o1, Geometric o2) {
        return Double.compare(o1.bottomBorder(), o2.bottomBorder());
    }
}
