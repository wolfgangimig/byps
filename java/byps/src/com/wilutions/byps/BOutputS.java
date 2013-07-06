package com.wilutions.byps;

import java.nio.ByteOrder;


public class BOutputS extends BOutputBin {
	
	public BOutputS(BTransport transport, int negotiatedVersion, ByteOrder negotiatedByteOrder) {
		super(transport, BMessageHeader.MAGIC_BINARY_STREAM, negotiatedVersion, negotiatedByteOrder);
	}
	
	public BOutputS(BTransport transport, BMessageHeader requestHeader) {
		super(transport, requestHeader);
	}

	@Override
	protected void storeObj(Object obj) throws BException {
		writeObj(obj, false, null);
	}
	
	@Override
	public void writeObj(Object obj, boolean isUnique, BSerializer ser) throws BException {
		
		if (ser != null && ser.inlineInstance) {
			
			// Inline objects must not be null
			if (obj == null) {
				obj = ser.read(null, null, 0); // create object
			}
			
			ser.write(obj, this, header.version);
			return;
		}

		if (obj != null) {

			BObjMap objMap = isUnique ? null : this.objMap;

			Integer id_o = objMap != null ? objMap.get(obj) : null; 
			if (id_o != null) {
				bbuf.putPointer(-id_o);
			}
			else {
				id_o = ++nextObjId;
				
				bbuf.putPointer(nextObjId);

				if (objMap != null) objMap.put(obj, id_o);
				
				if (ser == null) {
					ser = registry.getSerializer(obj, true);
				}
				
				bbuf.putTypeId(ser.typeId);
				
				ser.write(obj, this, header.version);
			}
		}
		else {
			// NULL-Referenz
			bbuf.putPointer(0);
		}
	}
	
	private int nextObjId;

}
