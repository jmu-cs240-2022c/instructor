import java.util.LinkedList;

public class HashTable<K, V> {
  private LinkedList<KeyValuePair>[] pairs;
  private int size;

  @SuppressWarnings("unchecked")
  public HashTable() {
    pairs = (LinkedList<KeyValuePair>[]) new LinkedList[10];
  }

private int indexFor(K key) {
  int hashcode = key.hashCode();
  int index = (hashcode & 0x7FFFFFFF) % pairs.length;
  return index;
}

  void put(K key, V value) {
    int index = indexFor(key);
    if (pairs[index] == null) {
      pairs[index] = new LinkedList<>();
    }
    pairs[index].add(new KeyValuePair(key, value));
  }

  V get(K key) {
    int index = indexFor(key);
    if (pairs[index] != null) {
      for (KeyValuePair pair : pairs[index]) {
        if (pair.key.equals(key)) {
          return pair.value;
        }
      }
    }
    return null;
  }

  boolean has(K key) {
    int index = indexFor(key);
    return false;
  }

  V remove(K key) {
    int index = indexFor(key);
    return null;
  }

  private class KeyValuePair {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    HashTable<String, String> capitals = new HashTable<>();
    capitals.put("Virginia", "Richmond");
    capitals.put("Vermont", "Montpelier");

    System.out.println(capitals.get("Virginia"));
    System.out.println(capitals.get("Vermont"));
  }
}
