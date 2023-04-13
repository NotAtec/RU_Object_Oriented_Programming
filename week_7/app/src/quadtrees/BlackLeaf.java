package quadtrees;

import java.io.Writer;

public class BlackLeaf implements QuadTreeNode{

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        for (int x1 = x; x1 < x + width; x1++) {
            for (int y1 = y; y1 < y + width; y1++) {
                bitmap.setBit(x1, y1, false);
            }
        }
    }

    @Override
    public void writeNode(Writer out) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeNode'");
    }
    
}
