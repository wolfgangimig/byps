package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.util.HashMap;
import java.util.Map;

public class BObjMap {
	
	public void put(Object obj, Integer pos) {
	  int key = System.identityHashCode(obj);
		map.put(key, pos);
	}
	
	public Integer get(Object obj) {
	  int key = System.identityHashCode(obj);
		return map.get(key);
	}
	
	public void clear() {
		map.clear();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
	
	public int size() {
	  return map.size();
	}
	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
}