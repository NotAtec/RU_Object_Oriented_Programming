package geometric;

public class Rectangle implements Geometric {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public double leftBorder() {
        return x;
    }

    @Override
    public double rightBorder() {
        return (x + width);
    }

    @Override
    public double topBorder() {
        return (y + height);
    }

    @Override
    public double bottomBorder() {
        return y;
    }

    public String toString() {
        return "This rectangle has it's lower left corner at: (" + this.x + ", " + this.y + "). A width of: " + this.width + ", and a height of " + this.height + ".";
    }
}
