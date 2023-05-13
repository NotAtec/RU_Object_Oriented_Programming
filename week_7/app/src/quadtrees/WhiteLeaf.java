package quadtrees;

import java.io.Writer;
import java.io.IOException;

public class WhiteLeaf implements QuadTreeNode{

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        for (int x1 = x; x1 < x + width; x1++) {
            for (int y1 = y; y1 < y + width; y1++) {
                bitmap.setBit(x1, y1, true);
            }
        }
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.append("01");
        } catch(IOException e) {
            // TODO: handle exception
        }
    }
    
}