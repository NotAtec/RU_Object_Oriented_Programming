package geometric;

/*
*  Geometric interface that provides a default order based on surface area
 * @author Jeroen Brinkhorst (s1101799) and Floris Reuvers (s1096976)
 */

public interface Geometric extends Comparable<Geometric> {
    /**
     * Get area of the shape
     */
    public double getArea();

    /**
     * Get x-coordinate of the most left point of the shape
     */
    public double leftBorder();

    /**
     * Get x-coordinate of the most right point of the shape
     */
    public double rightBorder();

    /**
     * Get y-coordinate of the most top point of the shape
     */
    public double topBorder();

    /**
     * Get y-coordinate of the lowest point of the shape
     */
    public double bottomBorder();    
    

    /**
     * Moves geometric shape
     * @param dx: moved distance horizontally
     * @param dy: moved distance vertically
     */

    public void move(double dx, double dy);

    @Override
    default int compareTo(Geometric other) {
        return Double.compare(getArea(), other.getArea());
    }

}
