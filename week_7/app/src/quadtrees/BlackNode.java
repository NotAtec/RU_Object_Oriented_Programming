package quadtrees;

import java.io.Writer;
import java.io.IOException;

public class BlackNode implements QuadTreeNode {

  public BlackNode() {
    
  }

  public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
    bitmap.fillArea(x, y, width, false);
  }

  public void writeNode(Writer out) {
    try {
      out.append("00");
    } catch (IOException e) {
      // TODO: handle exception
    }
  }
}
