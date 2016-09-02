package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.Serializable;



@SuppressWarnings("serial")
public class BMethodResult<T> implements Serializable {
	public T result;
	
	public String toString() {
	  if (result != null) {
	    if (result.getClass().isArray()) {
	      if (result instanceof Object[]) {
	        return java.util.Arrays.toString((Object[])result);
	      }
        else if (result instanceof int[]) {
          return java.util.Arrays.toString((int[])result);
        }
        else if (result instanceof long[]) {
          return java.util.Arrays.toString((long[])result);
        }
        else if (result instanceof boolean[]) {
          return java.util.Arrays.toString((boolean[])result);
        }
        else if (result instanceof double[]) {
          return java.util.Arrays.toString((double[])result);
        }
        else if (result instanceof short[]) {
          return java.util.Arrays.toString((short[])result);
        }
        else if (result instanceof byte[]) {
          return java.util.Arrays.toString((byte[])result);
        }
        else if (result instanceof char[]) {
          return java.util.Arrays.toString((char[])result);
        }
        else if (result instanceof float[]) {
          return java.util.Arrays.toString((float[])result);
        }
        else {
          return result.toString();
        }
	    }
	    else {
	      return result.toString();
	    }
	  }
	  else {
	    return "(void)";
	  }
	}
}
