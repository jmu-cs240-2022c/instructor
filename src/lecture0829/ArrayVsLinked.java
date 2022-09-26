package lecture0829;

public class ArrayVsLinked {
  public static void main(String[] args) {
    Stopwatch timer = new Stopwatch();
    timer.start();
    LinkedListCode.main(args);
    double elapsedSeconds = timer.stop();
    System.out.println(elapsedSeconds);
  }
}
