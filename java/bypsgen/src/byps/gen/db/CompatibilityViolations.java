package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CompatibilityViolations implements Iterable<CompatibilityViolation> {

	@Override
	public Iterator<CompatibilityViolation> iterator() {
		return lst.iterator();
	}
	
	public void add(String msg) {
		log.debug(msg);
		lst.add(new CompatibilityViolation(msg));
	}
	
	public int size() {
		return lst.size();
	}

	private List<CompatibilityViolation> lst = new ArrayList<CompatibilityViolation>();
	private Logger log = LoggerFactory.getLogger(CompatibilityViolations.class);
}
