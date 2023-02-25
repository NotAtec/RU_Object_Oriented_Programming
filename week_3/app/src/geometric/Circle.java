package geometric;

public class Circle implements Geometric {
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public double leftBorder() {
        return (x - r);
    }

    @Override
    public double rightBorder() {
        return (x + r);
    }

    @Override
    public double topBorder() {
        return (y + r);
    }

    @Override
    public double bottomBorder() {
        return (y - r);
    }

    public String toString() {
        return "This circle has x coordinate: " + this.x + ", y coordinate: " + this.y + ", and radius " + this.r + ".";
    }
}
