package byps;

import java.nio.ByteBuffer;

/**
 * This class identifies a client.
 * Target IDs are generated during protocol negotiation.
 * They are internally used in the generated code an in the communication layer.
 */
public class BTargetId {
  
  /**
   * Server ID
   */
  public final int serverId;
	
	/**
	 * First ID value.
	 */
	public final long v1;
	
	/**
	 * Second ID value.
	 */
	public final long v2;
	
	/**
	 * Constructor.
	 * @param v1
	 * @param v2
	 */
	public BTargetId(int serverId, long v1, long v2) {
	  this.serverId = serverId;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	/**
	 * Default constructor.
	 */
	public BTargetId() {
	  serverId = 0;
		v1 = v2 = 0;
	}
	
	/**
	 * Returns true, if the ID is zero.
	 * @return true, if the ID is zero.
	 */
	public boolean isZero() {
		return serverId == 0 && v1 == 0 && v2 == 0;
	}
	
	/**
	 * Serialize the object into a buffer.
	 * @param buf Destination buffer.
	 */
	public void write(ByteBuffer buf) {
	  buf.putInt(serverId);
		buf.putLong(v1);
		buf.putLong(v2);
	}
	
	/**
	 * Deserialize a target ID from a buffer.
	 * @param buf Source buffer
	 * @return target ID
	 */
	public static BTargetId read(ByteBuffer buf) {
    int serverId = buf.getInt();
		long v1 = buf.getLong();
		long v2 = buf.getLong();
		return new BTargetId(serverId,v1,v2);
	}
	
	/**
	 * Print the target ID into a String.
	 * @return target ID as String.
	 */
	@Override
	public String toString() {
		if (isZero()) return "";
		StringBuilder builder = new StringBuilder();
		builder.append(serverId).append(".");
		builder.append(v1).append(".");
		builder.append(v2);
		return builder.toString();
	}
	
	/**
	 * Create a target ID from String.
	 * @param s String representation
	 * @return target ID
	 */
	public static BTargetId parseString(String s) {
	  int serverId = 0;
	  long v1 = 0, v2 = 0;
	  int p = s.indexOf('.');
	  if (p >= 0) {
	    serverId = Integer.parseInt(s.substring(0,p));
	    p++;
	    int e = s.indexOf('.', p);
	    if (e >= 0) {
	      v1 = Long.parseLong(s.substring(p, e));
	      e++;
	      v2 = Long.parseLong(s.substring(e));
	    }
	  }
		return new BTargetId(serverId, v1,v2);
	}

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + serverId;
    result = prime * result + (int) (v1 ^ (v1 >>> 32));
    result = prime * result + (int) (v2 ^ (v2 >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    BTargetId other = (BTargetId) obj;
    if (serverId != other.serverId) return false;
    if (v1 != other.v1) return false;
    if (v2 != other.v2) return false;
    return true;
  }


}
