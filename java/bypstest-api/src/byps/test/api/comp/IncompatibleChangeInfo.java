package byps.test.api.comp;

import java.io.Serializable;

/**
 * Class with incompatible changes.
 * This class has in API version 793 an int member.
 * In version 794, this member was changed to String.
 * Serializing this API from 793 to 794 cause an exception. 
 * @since 793
 */
public class IncompatibleChangeInfo implements Serializable {
  private final static long serialVersionUID = 1107425749L;

  public int intValueChangedToString;
  
}
