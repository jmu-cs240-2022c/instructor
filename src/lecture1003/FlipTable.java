package lecture1003;

public class FlipTable {
  public static void main(String[] args) {
    Queue<String> queue = new Queue<>();
    queue.enqueue("H");
    queue.enqueue("T");

    int n = 51;
//    int dequeueCount = Math.pow(2, n + 1) - 2;
    int dequeueCount = (1 << (n + 1)) - 2;

    for (int i = 0; i < dequeueCount; ++i) {
      String sequenceSoFar = queue.dequeue();
      System.out.println(sequenceSoFar);
      queue.enqueue(sequenceSoFar + "H");
      queue.enqueue(sequenceSoFar + "T");
    }
  }
}
