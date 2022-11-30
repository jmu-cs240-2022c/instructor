package lecture1128;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Maze {
  private final int[][] waymap;
  private int[][] grid;
  private final Random generator;

  private boolean isEscaped;

  public static final int EAST = 0;
  public static final int WEST = 1;
  public static final int SOUTH = 2;
  public static final int NORTH = 3;

  public static final int VISITED = 2;
  public static final int UNVISITED = 1;
  public static final int WALL = 0;

  private static final int[] DX;
  private static final int[] DY;
  private static final int[] OPPOSITES;

  static {
    DX = new int[4];
    DX[EAST] = 1;
    DX[WEST] = -1;
    DX[NORTH] = 0;
    DX[SOUTH] = 0;

    DY = new int[4];
    DY[EAST] = 0;
    DY[WEST] = 0;
    DY[NORTH] = -1;
    DY[SOUTH] = 1;

    OPPOSITES = new int[4];
    OPPOSITES[EAST] = WEST;
    OPPOSITES[WEST] = EAST;
    OPPOSITES[NORTH] = SOUTH;
    OPPOSITES[SOUTH] = NORTH;
  }

  public Maze(int width, int height, long seed) {
    waymap = new int[height][width];
    generator = new Random(seed);
    isEscaped = false;
    carveFrom(0, 0);
  }

  public boolean isEscaped() {
    return isEscaped;
  }

  private void carveFrom(int x, int y) {
    ArrayList<Integer> directions = new ArrayList<Integer>();
    directions.add(EAST);
    directions.add(WEST);
    directions.add(SOUTH);
    directions.add(NORTH);

    Collections.shuffle(directions, generator);

    for (Integer direction : directions) {
      int newX = x + DX[direction];
      int newY = y + DY[direction];

      if (newX >= 0
          && newX < waymap[0].length
          && newY >= 0
          && newY < waymap.length
          && waymap[newY][newX] == 0) {
        waymap[y][x] |= (1 << direction);
        waymap[newY][newX] |= (1 << OPPOSITES[direction]);
        carveFrom(newX, newY);
      }
    }

    grid = getGrid();
  }

  public int getWidth() {
    return waymap[0].length * 2 + 1;
  }

  public int getHeight() {
    return waymap.length * 2 + 1;
  }

  public boolean isWall(int c, int r) {
    return grid[r][c] == 0;
  }

  public boolean isUnvisited(int c, int r) {
    return grid[r][c] == 1;
  }

  public boolean isVisited(int c, int r) {
    return grid[r][c] == 2;
  }

  public int[][] getGrid() {
    int[][] grid = new int[getHeight()][getWidth()];

    for (int r = 0; r < waymap.length; ++r) {
      int pr = r * 2 + 1;
      for (int c = 0; c < waymap[r].length; ++c) {
        int pc = c * 2 + 1;
        grid[pr][pc] = UNVISITED;

        if ((waymap[r][c] & (1 << EAST)) != 0) {
          grid[pr][pc + 1] = UNVISITED;
        }

        if ((waymap[r][c] & (1 << SOUTH)) != 0) {
          grid[pr + 1][pc] = UNVISITED;
        }
      }
    }

    return grid;
  }

  public void visitCell(int c, int r) {
    if (grid[r][c] != WALL) {
      if (r == getHeight() - 2 && c == getWidth() - 2) {
        isEscaped = true;
      }
      grid[r][c] = VISITED;
    } else {
      throw new RuntimeException("You can't visit the wall at " + c + "," + r + "!");
    }
  }

  public int getUnvisitedNeighborsCount(int c, int r) {
    int nUnvisited = 0;
    if (r > 0 && isUnvisited(c, r - 1)) {
      ++nUnvisited;
    }
    if (r < getHeight() - 1 && isUnvisited(c, r + 1)) {
      ++nUnvisited;
    }
    if (c > 0 && isUnvisited(c - 1, r)) {
      ++nUnvisited;
    }
    if (c < getWidth() - 1 && isUnvisited(c + 1, r)) {
      ++nUnvisited;
    }
    return nUnvisited;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    int[][] pixels = getGrid();
    for (int r = 0; r < pixels.length; ++r) {
      for (int c = 0; c < pixels[r].length; ++c) {
        sb.append(pixels[r][c] == 0 ? "*" : " ");
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}