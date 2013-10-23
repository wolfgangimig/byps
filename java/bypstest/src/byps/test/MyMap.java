package byps.test;

import java.util.TreeMap;

@SuppressWarnings({ "serial" })
public class MyMap<K,V> extends TreeMap<K,V> {

	public MyMap<K,V> add(K key, V value) {
		this.put(key, value);
		return this;
	}
}
