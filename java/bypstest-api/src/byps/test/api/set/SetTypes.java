package byps.test.api.set;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import byps.test.api.prim.PrimitiveTypes;

public class SetTypes implements Serializable {

	private static final long serialVersionUID = 5001L;
	
	public Set< Boolean> boolean1;
	public HashSet< Byte> byte1;
	public TreeSet< Character> char1;
	public Set< Short> short1;
	public Set< Integer> int1;
	public Set< Long> long1;
	public Set< Float> float1;
	public Set< Double> double1;
	public Set< String> string1;
	public Set< PrimitiveTypes> primitiveTypes1;
	public Set< byte[]> byte2;
	public Set< int[]> int2;
	public Set<Object> obj1;
	public Set<Date> date1;

}
