package byps.test.api.cons;

import java.io.Serializable;

public class HebrewC implements Serializable {

  private final static long serialVersionUID = 1770673942L;
	
	protected final static String aleph = "\u05D0";
	protected final static String beth = "\u05D1";
	
	public final static HebrewZ ALEPH = new HebrewZ(aleph);
	public final static HebrewZ BETH = new HebrewZ(beth);
	
}
