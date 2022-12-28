package lecture1128;

import java.util.*;

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

  public List<Integer> topologicalSort() {
    LinkedList<Integer> order = new LinkedList<>();
    HashSet<Integer> visiteds = new HashSet<>();

    for (int i = 0; i < edges.length; ++i) {
      if (!visiteds.contains(i)) {
        depthTraverse(i, visiteds, order);
      }
    }

    return order;
  }

  public List<Integer> topologicalSort2() {
    ArrayList<Integer> order = new ArrayList<>();
    HashSet<Integer> visiteds = new HashSet<>();

    for (int i = 0; i < edges.length; ++i) {
      if (!visiteds.contains(i)) {
//        depthTraverse(i, visiteds, order);
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
          int vertex = stack.pop();
          visiteds.add(vertex);
          for (int neighbor : neighbors(vertex)) {
            if (!visiteds.contains(neighbor)) {
              stack.push(neighbor);
            }
          }
          order.add(vertex);
        }
      }
    }

    Collections.reverse(order);
    return order;
  }

  public void depthTraverse(int vertex, HashSet<Integer> visiteds, LinkedList<Integer> order) {
    visiteds.add(vertex);
    for (int neighbor : neighbors(vertex)) {
      if (!visiteds.contains(neighbor)) {
        depthTraverse(neighbor, visiteds, order);
      }
    }
    order.addFirst(vertex);
  }

  public static void main(String[] args) {
    Graph g = new Graph(6);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(4, 2);
    g.addEdge(1, 3);
    g.addEdge(5, 0);
    System.out.println(g.topologicalSort2());
  }
}
