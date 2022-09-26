package lecture0926;

import org.w3c.dom.Node;

public class LinkedList<T> {
  private Node head;
  private Node tail;
  private int size;

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public void append(T item) {
    Node newNode = new Node(item, null);
    ++size;
    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
  }

  public void prepend(T item) {
    Node newNode = new Node(item, head);
    ++size;
    if (head == null) {
      tail = newNode;
    }
    head = newNode;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node node = head;
    for (int currentIndex = 0; currentIndex < index; ++currentIndex) {
      node = node.next;
    }
    return node.item;
  }

  class Node {
    T item;
    Node next;

    Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    LinkedList<String> beatles = new LinkedList<>();
    beatles.append("Ringo");
    beatles.append("George");
    beatles.append("Paul");
    beatles.append("John");
    beatles.prepend("Pete");

    System.out.println(beatles.get(0));
    System.out.println(beatles.get(1));
    System.out.println(beatles.get(2));
    System.out.println(beatles.get(3));
    System.out.println(beatles.get(4));

  }
}
