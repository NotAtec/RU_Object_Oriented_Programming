package quadtrees;

import java.io.Writer;

public class BlackNode implements QuadTreeNode {

  public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
    bitmap.fillArea(x, y, width, false);
  }

  public void writeNode(Writer out) {

  }
}
