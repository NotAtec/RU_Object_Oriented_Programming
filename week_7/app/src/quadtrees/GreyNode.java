package quadtrees;

import java.io.IOException;
import java.io.Writer;

public class GreyNode implements QuadTreeNode {
  private QuadTreeNode[] children = new QuadTreeNode[4];

  public GreyNode() {
  }

  public void setChildX(int x, QuadTreeNode q) {
    children[x] = q;
  }

  public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
    int newWidth = width / 2;
    int[] xValues = {x, x + width / 2, x + width / 2, x};
    int[] yValues = {y, y, y + width / 2, y + width / 2};
    int count = 0;

    for (QuadTreeNode qtn : children) {
      qtn.fillBitmap(xValues[count], yValues[count], newWidth, bitmap);
      count++;
    }
  }

  public void writeNode(Writer out) {
    try {
      out.append("1");
      for (QuadTreeNode qtn : children) {
        qtn.writeNode(out);
      }
    } catch (IOException e) {
      // TODO: handle exception
    }
    
  }

}
