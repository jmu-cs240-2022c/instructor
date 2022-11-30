package lecture1128;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.HashSet;

public class BreadFirstSolver {
  public static void main(String[] args) {
    Maze maze = new Maze(30, 20, 103);
    MazeFrame frame = new MazeFrame(maze);

    ArrayDeque<Point> frontier = new ArrayDeque<>();
    frontier.offer(new Point(1, 1));

    while (!frontier.isEmpty() && !maze.isEscaped()) {
      Point current = frontier.poll();

      maze.visitCell(current.x, current.y);
      frame.repaintNow();

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
      }

      if (maze.isUnvisited(current.x + 1, current.y)) {
        frontier.offer(new Point(current.x + 1, current.y));
      }

      if (maze.isUnvisited(current.x - 1, current.y)) {
        frontier.offer(new Point(current.x - 1, current.y));
      }

      if (maze.isUnvisited(current.x, current.y + 1)) {
        frontier.offer(new Point(current.x, current.y + 1));
      }

      if (maze.isUnvisited(current.x, current.y - 1)) {
        frontier.offer(new Point(current.x, current.y - 1));
      }
    }
  }
}
