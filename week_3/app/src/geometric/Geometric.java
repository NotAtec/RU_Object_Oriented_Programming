package geometric;

public interface Geometric extends Comparable<Geometric> {
    public double getArea();

    public double leftBorder();
    public double rightBorder();
    public double topBorder();
    public double bottomBorder();

    public void move(double dx, double dy);

    @Override
    default int compareTo(Geometric other) {
        return Double.compare(getArea(), other.getArea());
    }
}
