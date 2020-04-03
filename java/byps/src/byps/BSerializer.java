package byps;

public abstract class BSerializer {
	
	public final int typeId;	
	
	/**
	 * Store objects without reference and type information.
	 * The object members are directly written into the output buffer.
	 * This member is true, if the class for which this BSerializer
	 * is created is tagged with @inline.
	 */
	public final boolean inlineInstance;
	
	protected BSerializer(int typeId, boolean inlineInstance) {
		this.typeId = typeId;
		this.inlineInstance = inlineInstance;
	}
	
	protected BSerializer(int typeId) {
		this.typeId = typeId;
		this.inlineInstance = false;
	}
	
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
	}
			
	/**
	 * Create and read an object.
	 */
	public abstract Object read(final Object obj1, final BInput bin1, final long version) throws BException;
	
  /**
   * Assign the BClient object of BInput to the given object.
   * @param obj Object to be prepared
   * @param ser Serializer for the object or null
   * @throws BException
   */
	public void prepareForLazyLoading(final Object obj, final BInput bin, final long version) throws BException {
	}
}
