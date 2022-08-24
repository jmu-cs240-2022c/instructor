package lecture0824;

import java.util.ArrayList;
import java.util.Iterator;

public class Ranger implements Iterable<Integer> {
  private int min;
  private int max;

  public Ranger(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public Iterator<Integer> iterator() {
    return new Iterator<>() {
      private int soon = min;

      @Override
      public boolean hasNext() {
        return soon <= max;
      }

      @Override
      public Integer next() {
        if (hasNext()) {
          int now = soon;
          ++soon;
          return now;
        } else {
          throw new IllegalStateException();
        }
      }
    };
  }

  public static void main(String[] args) {
    Ranger r = new Ranger(1, 10);
    for (int x : r) {
      System.out.println(x);
    }
//    ArrayList<Integer> xs = new ArrayList<>();
//    xs.add(1);
//    xs.add(5);
//    xs.add(10);
//    for (int x : xs) {
//      System.out.println(x);
//    }
//
//    Iterator<Integer> it = xs.iterator();
//    while (it.hasNext()) {
//      int x = it.next();
//      System.out.println(x);
//    }
  }
}
