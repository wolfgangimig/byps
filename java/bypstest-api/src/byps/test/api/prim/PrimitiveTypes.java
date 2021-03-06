package byps.test.api.prim;

import java.util.Date;

import byps.BClient;
import byps.BValueClass;

/**
 * Example class with primitive types like boolean, int, String.
 */
public class PrimitiveTypes extends BValueClass implements InterfaceToIgnore {
	
	private static final long serialVersionUID = 1000L;
	
	/**
	 * Boolean value. 
	 * Serialized as one byte with value 1 for true and value 0 for false.
	 */
	public boolean boolVal;
	/**
	 * One byte.
	 */
	public byte byteVal;
	/**
	 * One wide (2 byte) character.
	 * Serialized as short integer in binary serialization and as string when serializing in JSON format.
	 */
	public char charVal;
	public short shortVal;
	public int intVal;
	public long longVal;
	public float floatVal;
	public double doubleVal;
	public String stringVal;
	public Date dateVal;
	
	/**
	 * This element can refer a an arbitrary type that implements Serializable.
	 * It cannot hold an array, List, ArrayList, etc. 
	 */
	public Object objVal; 
	public Object objVal2;
	
	/**
	 * In CSharp, value is a keyword in property setter functions.
	 * But it must not be a problem to name a member by value.
	 */
	public boolean value;
	
	
	public transient Object temp;

	
  /**
   * This value is read in its getter function.
   */
	protected int deferredValue;

  public int getDeferredValue() {
    if (deferredValue == 0) {
      BClient.lazyLoadMember(bypsClient, this, 1);
    }
    return deferredValue;
  }

  public void setDeferredValue(int v) {
    this.deferredValue = v;
  }

	
  @Override
  public String toString() {
    return "PrimitiveTypes [boolVal=" + boolVal + ", byteVal=" + byteVal + ", charVal=" + charVal + ", shortVal=" + shortVal + ", intVal=" + intVal
        + ", longVal=" + longVal + ", floatVal=" + floatVal + ", doubleVal=" + doubleVal + ", stringVal=" + stringVal + ", dateVal=" + dateVal
        //+ ", objVal=" + objVal + ", objVal2=" + objVal2 + ", value=" + value // do not add this members, otherwise testPrimitiveTypesReferenceToSelf causes StackOverflowException. 
        + "]";
  }

  @Override
  public void ignoreThisInterface() {
    // ignore
    
  }
	
	
}
