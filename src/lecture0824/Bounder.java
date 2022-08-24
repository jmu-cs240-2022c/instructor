package lecture0824;

public class Bounder<T extends Comparable<T>> {
  private T min;
  private T max;

  public Bounder() {
    min = null;
    max = null;
  }

  public void add(T value) {
    if (min == null) {
      min = value;
      max = value;
    } else if (value.compareTo(min) < 0) {
      min = value;
    } else if (value.compareTo(max) > 0) {
      max = value;
    }
  }

  public T min() {
    return min;
  }

  public T max() {
    return max;
  }

  public static void main(String[] args) {
    Bounder<String> bounder = new Bounder<>();
//    bounder.add(19.0);
//    bounder.add(7.0);
//    bounder.add(21.0);
//    bounder.add(11.0);
    bounder.add("fun");
    bounder.add("divertido");
    bounder.add("pants");
    System.out.println(bounder.min());
    System.out.println(bounder.max());
  }
}
