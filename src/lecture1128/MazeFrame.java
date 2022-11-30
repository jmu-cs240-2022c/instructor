package lecture1128;

import javax.swing.*;
import java.awt.*;

public class MazeFrame extends JFrame {
  private final Maze maze;
  private final MazePanel panel;

  public MazeFrame(Maze maze) {
    super("Maze");

    this.maze = maze;
    panel = new MazePanel();
    add(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000, 800);
    setVisible(true);
  }

  private class MazePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
      int width = getWidth() / maze.getWidth();
      int height = getHeight() / maze.getHeight();
      for (int r = 0; r < maze.getHeight(); ++r) {
        for (int c = 0; c < maze.getWidth(); ++c) {
          if (r == maze.getHeight() - 2
              && c == maze.getWidth() - 2) {
            g.setColor(Color.RED);
          } else if (maze.isUnvisited(c, r)) {
            g.setColor(Color.WHITE);
          } else if (maze.isVisited(c, r)) {
            g.setColor(Color.GRAY);
          } else {
            g.setColor(Color.BLUE);
          }
          g.fillRect(c * width, r * height, width, height);
        }
      }
    }
  }

  public void repaintNow() {
    panel.paintImmediately(0, 0, panel.getWidth(), panel.getHeight());
  }
}