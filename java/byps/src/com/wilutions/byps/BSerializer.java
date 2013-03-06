package com.wilutions.byps;



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
	
	/**
	 * Größe des Objekts.
	 * Wenn das Objekt keine Pointer enhält, kann 0 zurückgegeben werden. (String)
	 * @param bout
	 * @return
	 * @throws BException
	 */
	public int size(final Object obj1, final BBinaryModel bmodel) throws BException {
		return 0;
	}
	
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
	}
			
	/**
	 * Create and read an object.
	 */
	public abstract Object read(final Object obj1, final BInput bin1, final int version) throws BException;
	
}
