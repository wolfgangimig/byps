package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.util.HashMap;

public class BObjMap {
	
	public void put(Object obj, Integer pos) {
		map.put(new Key(obj), pos);
	}
	
	public Integer get(Object obj) {
		kinst.obj = obj;
		return map.get(kinst);
	}
	
	public void clear() {
		map.clear();
	}

	private static class Key {
		Object obj;
		Key(Object obj) { 
			this.obj = obj;
		}
		@Override
		public int hashCode() {
			return System.identityHashCode(obj);
		}
		@Override
		public boolean equals(Object key) {
			return this.obj == ((Key)key).obj;
		}
		@Override
		public String toString() {
			return String.valueOf(System.identityHashCode(obj));
		}
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
	
	private HashMap<Key, Integer> map = new HashMap<Key, Integer>();
	private Key kinst = new Key(null);
}