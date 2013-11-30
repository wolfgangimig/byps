package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
public class CompatibilityViolation {
	
	public final String msg;
	
	public CompatibilityViolation(String msg) {
		this.msg = msg;
	}
	
	public String toString()
	{
		return msg;
	}
}
