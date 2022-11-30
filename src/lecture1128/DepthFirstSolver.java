package lecture1128;

import java.awt.*;
import java.util.ArrayDeque;

public class DepthFirstSolver {
  public static void main(String[] args) {
    Maze maze = new Maze(30, 20, 103);
    MazeFrame frame = new MazeFrame(maze);

    ArrayDeque<Point> frontier = new ArrayDeque<>();
    frontier.addLast(new Point(1, 1));

    while (!frontier.isEmpty() && !maze.isEscaped()) {
      Point current = frontier.removeLast();

      maze.visitCell(current.x, current.y);
      frame.repaintNow();

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
      }

      if (maze.isUnvisited(current.x + 1, current.y)) {
        frontier.addLast(new Point(current.x + 1, current.y));
      }

      if (maze.isUnvisited(current.x - 1, current.y)) {
        frontier.addLast(new Point(current.x - 1, current.y));
      }

      if (maze.isUnvisited(current.x, current.y + 1)) {
        frontier.addLast(new Point(current.x, current.y + 1));
      }

      if (maze.isUnvisited(current.x, current.y - 1)) {
        frontier.addLast(new Point(current.x, current.y - 1));
      }
    }
  }
}
