package byps.test.api.cons;

import java.io.Serializable;

/**
 * 
 * @author wolfgang
 * @since 795.0.0.0
 */
public class SordC implements Serializable {

  private static final long serialVersionUID = 632707056;

  private static long mbAllMembers = 2196631268005773311L;
  
  public static final SordZ mbAll = new SordZ(mbAllMembers);

  public long getMbAllMembers() {
    return mbAllMembers;
  }
}
