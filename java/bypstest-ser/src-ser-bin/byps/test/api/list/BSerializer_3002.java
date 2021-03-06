package byps.test.api.list;

/*
 * Serializer for byps.test.api.list.ListListTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=3

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_3002 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_3002();
	
	public BSerializer_3002() {
		super(3002);
	}
	
	public BSerializer_3002(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final ListListTypes obj = (ListListTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.int2, false, byps.test.api.BSerializer_1746702954.instance);
		bout.writeObj(obj.int24, false, byps.test.api.BSerializer_1865834185.instance);
		bout.writeObj(obj.int3, false, byps.test.api.BSerializer_1633500852.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final ListListTypes obj = (ListListTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new ListListTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.int2 = (java.util.List<java.util.List<java.lang.Integer>>)bin.readObj(false, byps.test.api.BSerializer_1746702954.instance);
		obj.int24 = (java.util.List<java.util.List<int[][][][]>>)bin.readObj(false, byps.test.api.BSerializer_1865834185.instance);
		obj.int3 = (java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>)bin.readObj(false, byps.test.api.BSerializer_1633500852.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final ListListTypes obj = (ListListTypes)(obj1);		
		
	}
	
}
