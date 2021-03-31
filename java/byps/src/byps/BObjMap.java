package byps;

import java.util.ArrayList;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BObjMap {

	public void put(Object obj, Integer pos) {
		int key = System.identityHashCode(obj);
		map
		    .computeIfAbsent(key, k -> new ArrayList<>(3))
		    // BYPS-53: to identify the object's position correctly we remember the
		    // reference to the object itself
		    .add(new ObjectEntry(obj, pos));
	}

	public Integer get(Object obj) {
		int key = System.identityHashCode(obj);

		List<ObjectEntry> l = map.get(key);
		if (l == null)
			return null;

		// BYPS-53: search the list for the the given object
		for (ObjectEntry h : l) {
			// explicitly check for object identity in case of identityHashCode collisions
			if (h != null && h.obj == obj)
				return h.position;
		}

		return null;
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

	/**
	 * Maps the identity hash code of an object to its position in the pointer
	 * table.
	 *
	 * BYPS-53: Use a {@link List} as value to not override the position of an other
	 * object with the same identity hash code. Using System.identityHashCode as key
	 * caused collisions (there were around 260 collisions per 1000000 objects in a
	 * synthetic test). Thus we use some kind of a multi-valued map to avoid
	 * overriding values.
	 */
	private Map<Integer, List<ObjectEntry>> map = new HashMap<>();

	/**
	 * Container to map an object's reference to a position. Used as Type in the
	 * enclosing class' map.
	 */
	private class ObjectEntry {
		/** Reference to the {@link Object} stored in {@link BObjMap#map} */
		private final Object obj;
		private final Integer position;

		private ObjectEntry(Object obj, Integer position) {
			this.obj = obj;
			this.position = position;
		}
	}
}