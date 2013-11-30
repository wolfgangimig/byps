package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.TreeMap;

@SuppressWarnings({ "serial" })
public class MyMap<K,V> extends TreeMap<K,V> {

	public MyMap<K,V> add(K key, V value) {
		this.put(key, value);
		return this;
	}
}
