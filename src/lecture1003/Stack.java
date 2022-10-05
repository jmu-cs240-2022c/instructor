package lecture1003;

import java.util.ArrayList;

public class Stack<T> {
  private ArrayList<T> items;

  public Stack() {
    items = new ArrayList<>();
  }

  public int size() {
    return items.size();
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public void push(T item) {
    items.add(item);
  }

  public T pop() {
    return items.remove(items.size() - 1);
  }

  public T peek() {
    return items.get(items.size() - 1);
  }
}
