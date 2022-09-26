package lecture0829;

import java.util.ArrayList;

public class ArrayListCode {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < 500000; ++i) {
      numbers.add(0, i);
    }

    while (!numbers.isEmpty()) {
      numbers.remove(0);
    }
  }
}
