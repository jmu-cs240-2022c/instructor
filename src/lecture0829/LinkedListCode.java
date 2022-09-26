package lecture0829;

import java.util.LinkedList;

public class LinkedListCode {
  public static void main(String[] args) {
    LinkedList<Integer> numbers = new LinkedList<>();

    for (int i = 0; i < 500000; ++i) {
      numbers.add(0, i);
    }

    while (!numbers.isEmpty()) {
      numbers.remove(0);
    }
  }
}
