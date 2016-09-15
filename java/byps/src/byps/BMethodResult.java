package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.Serializable;



@SuppressWarnings("serial")
public class BMethodResult<T> implements Serializable {
	public T result;
	
	public String toString() {
	  return BBuffer.resultToString(result);
	}
}
