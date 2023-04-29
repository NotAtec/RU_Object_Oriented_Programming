package snake;

import java.util.LinkedList;
import java.util.List;

/**
 * Snake consists of segments, where this head segment keeps track of the other body segments
 */
public class Snake extends Segment {

    public interface SnakeSegmentListener {
        public void onNewSegment(Segment segment);
    }

    private Direction direction = Direction.RIGHT;

    private final World world;

    private final LinkedList<Segment> body = new LinkedList<>();

    private final List<SnakeSegmentListener> listeners = new LinkedList<>();

    public Snake(int x, int y, World world) {
        super(x, y);
        this.world = world;
        body.push(this);        
    }

    public void createHead() {
        for (SnakeSegmentListener l : listeners) {
            l.onNewSegment(this);
        }
    }

    public void move() {
        int newX = getX() + direction.getDX();
        int newY = getY() + direction.getDY();

        if (isAt(newX, newY) || outOfBounds(newX, newY)) {
            world.getTimeline().stop();
            return;
        }

        if (newX == world.getFood().getX() && newY == world.getFood().getY()) {
            world.moveFoodRandomly();
            int[] xy = { body.getLast().getX(), body.getLast().getY() };

            this.nextPos();
            Segment newSeg = new Segment(xy[0], xy[1]);
            body.push(newSeg);
            listeners.forEach(l -> l.onNewSegment(newSeg));
            return;
        }

        this.nextPos();  
    }

    public void addListener(SnakeSegmentListener listener) {
        listeners.add(listener);
    }

    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public boolean isAt(int x, int y) {
        for (Segment segment : body) {
            if (segment.getX() == x && segment.getY() == y) {
                return true;
            }
        }

        return false;
    }

    public Direction getDirection() {
        return direction;
    }

    private boolean outOfBounds(int x, int y) {
        return x < 0 || x >= world.getSize() || y < 0 || y >= world.getSize();
    }

    private void nextPos() {
        for (Segment segment : body) {
            segment.setPosition(segment.getX() + direction.getDX(), segment.getY() + direction.getDY());
        }
    }
}
