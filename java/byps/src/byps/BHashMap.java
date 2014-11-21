package byps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Map class that supports concurrent access.
 *
 * @param <K>
 * @param <V>
 */
public class BHashMap<K, V> implements Serializable {
  
  private static final long serialVersionUID = BRegistry.TYPEID_MAP;
  private HashMap<K, V> map = new HashMap<K,V>();

  public BHashMap() {
  }
  
  public synchronized V get(K key) {
    return map.get(key);
  }
  
  public synchronized void put(K k, V v) {
    map.put(k, v);
  }
  
  public synchronized V remove(K k) {
    return map.remove(k);
  }
  
  public synchronized V putIfAbsent(K k, V v) {
    V c = map.get(k);
    if (c == null) {
      map.put(k, v);
    }
    return c;
  }
  
  public synchronized Collection<K> keys() {
    return new ArrayList<K>(map.keySet());
  }
  
  public synchronized Collection<V> values() {
    return new ArrayList<V>(map.values());
  }

  public synchronized void clear() {
    map.clear();
  }

  public synchronized int size() {
    return map.size();
  }
}
