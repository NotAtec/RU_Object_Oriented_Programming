package quadtrees;

import java.io.IOException;
import java.io.Writer;

public class WhiteNode implements QuadTreeNode {

  public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
    bitmap.fillArea(x, y, width, true);
  }

  public void writeNode(Writer out) {
    try {
      out.append("01");
    } catch (IOException e) {
      // TODO: handle exception
    }
  }
}
