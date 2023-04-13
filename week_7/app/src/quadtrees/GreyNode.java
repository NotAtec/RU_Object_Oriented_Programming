package quadtrees;

import java.io.Writer;

public class GreyNode implements QuadTreeNode {
  private QuadTreeNode[] children;


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

  }

}
