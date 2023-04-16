package quadtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {

  private QuadTreeNode root;

  public QTree(Reader input) {
    root = readQTree(input);
  }

  public QTree(Bitmap bitmap) {
    root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
  }

  public void fillBitmap(Bitmap bitmap) {
    root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
  }

  public void writeQTree(Writer sb) {
    root.writeNode(sb);
  }

  private static QuadTreeNode readQTree(Reader input) {
    char c = readNext(input);
    if (c == '0') {
      c = readNext(input);
      QuadTreeNode q;
      if (c == '0') {
        q = new BlackNode();
      } else {
        q = new WhiteNode();
      }
      return q;
    }

    GreyNode root = new GreyNode();
    GreyNode current = root;
    int x = 0;

    c = readNext(input);

    while (c != 'e' && c != ' ') {
      if (c == '0') {
        c = readNext(input);
        QuadTreeNode q;
        if (c == '0') {
          q = new BlackNode();
        } else {
          q = new WhiteNode();
        }

        current.setChildX(x, q);
        x = (x + 1) % 4;
      } else {
        current = new GreyNode();
        x = 0;
      }

      c = readNext(input);
    }

    return root;
  }

  public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
    int newWidth = width / 2;
    int[] xValues = {x, x + width / 2, x + width / 2, x};
    int[] yValues = {y, y, y + width / 2, y + width / 2};
    int count = 0;
    QuadTreeNode root = new GreyNode();
    QuadTreeNode current;
    boolean flag = true;

    if (bitmap.getBit(x, y)) {
      for (int i = 0; i < width - 1; i++) {
        for (int j = 0; i < width - 1; j++) {
          if (!bitmap.getBit(i, j)) {
            root = new GreyNode();
            flag = false;
          }
        }
      }
      if (flag) {
        root = new WhiteNode();
      }
    }

    if (!bitmap.getBit(x, y)) {
      for (int i = 0; i < width - 1; i++) {
        for (int j = 0; i < width - 1; j++) {
          if (bitmap.getBit(i, j)) {
            root = new GreyNode();
            flag = false;
          }
        }
      }
      if (flag) {
        root = new BlackNode();
      }
    }

    return root;
  }

  private static char readNext(Reader input) {
    int i;
    try {
      i = input.read();
    } catch (IOException e) {
      i = -2;
    }

    char c = ' ';
    if (i == -1) {
      c = 'e';
    } else if (i != -2) {
      c = (char) i;
    }

    return c;
  }
}
