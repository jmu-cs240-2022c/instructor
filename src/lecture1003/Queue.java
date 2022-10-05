package lecture1003;

import java.util.LinkedList;

public class Queue<T> {
  private LinkedList<T> items;

  public Queue() {
    items = new LinkedList<>();
  }

  public int size() {
    return items.size();
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public void enqueue(T item) {
    items.addFirst(item);
  }

  public T dequeue() {
    return items.removeLast();
  }

  public T peek() {
    return items.getLast();
  }
}
