package lecture1024;

import org.w3c.dom.Node;

public class TreeMap<K extends Comparable<K>, V> {
  private Node root;

  public TreeMap() {
    root = null;
  }

  public void put(K key, V value) {
    root = put(key, value, root);
  }

  private Node put(K key, V value, Node node) {
    if (node == null) {
      return new Node(key, value);
    } else {
      int order = key.compareTo(node.key);
      if (order == 0) {
        node.value = value;
      } else if (order < 0) {
        node.left = put(key, value, node.left);
      } else {
        node.right = put(key, value, node.right);
      }
      return node;
    }
  }

  public V get(K key) {
    return get(key, root);
  }

  private V get(K key, Node node) {
    if (node == null) {
      return null;
    } else {
      int order = key.compareTo(node.key);
      if (order == 0) {
        return node.value;
      } else if (order < 0) {
        return get(key, node.left);
      } else {
        return get(key, node.right);
      }
    }
  }

  private class Node {
    K key;
    V value;
    Node left;
    Node right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    TreeMap<String, Integer> namesToPets = new TreeMap<>();
    namesToPets.put("Annalise", 2);
    namesToPets.put("Hannah", 0);
    System.out.println(namesToPets.get("Annalise"));
    System.out.println(namesToPets.get("Hannah"));
    System.out.println(namesToPets.get("Hannah"));
  }
}
