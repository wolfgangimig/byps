package byps.test.api.list;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import byps.test.api.prim.PrimitiveTypes;

public class ListTypes implements Serializable {

	private static final long serialVersionUID = 3001L;
	
	public List< Boolean> boolean1;
	public List< Byte> byte1;
	public List< Character> char1;
	public List< Short> short1;
	public List< Integer> int1;
	public List< Long> long1;
	public List< Float> float1;
	public List< Double> double1;
	public List< String> string1;
	public List< Date> date1;
	public List< PrimitiveTypes> primitiveTypes1;
	public List< byte[]> byte2;
	public List< int[]> int2;
	public List< int[][][][]> int4;
	public List<Object> obj1;
}