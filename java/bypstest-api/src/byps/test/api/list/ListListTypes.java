package byps.test.api.list;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class ListListTypes implements Serializable {

	private static final long serialVersionUID = 3002L;
	
	public List<List<Integer>> int2;
	public List<Map<Integer,List<TreeSet<Integer>>>> int3;
	public List<List<int[][][][]>> int24;

}
