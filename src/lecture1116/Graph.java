package lecture1116;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private boolean[][] edges;

  public Graph(int vertexCount) {
    edges = new boolean[vertexCount][vertexCount];
  }

  public void addEdge(int from, int to) {
    edges[from][to] = true;
  }

  public void removeEdge(int from, int to) {
    edges[from][to] = false;
  }

  public boolean hasEdge(int from, int to) {
    return edges[from][to];
  }

  public List<Integer> neighbors(int from) {
    ArrayList<Integer> neighbors = new ArrayList<>();
    for (int to = 0; to < edges[from].length; ++to) {
      if (hasEdge(from, to)) {
        neighbors.add(to);
      }
    }
    return neighbors;
  }

  
}
