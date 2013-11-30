package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BBufferJson;
import byps.BException;
import byps.BInputJson;
import byps.BOutputJson;
import byps.BRegistry;
import byps.BSerializer;
import byps.BValueClass;



public class JSerializer_22 extends JSerializer_Object {

	public final static BSerializer instance = new JSerializer_22();

	public JSerializer_22() {
		super(BRegistry.TYPEID_VALUECLASS);
	}

	public JSerializer_22(int typeId) {
		super(typeId);
	}

	@Override
	protected void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BValueClass obj = (BValueClass)obj1;
		bbuf.putLong("changedMembers", obj.changedMembers);
	}

	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final long v = bin.currentObject.getLong("changedMembers");
		BValueClass obj = (BValueClass)obj1;
		if (obj == null) {
			obj = new BValueClass();
			bin.onObjectCreated(obj);
		}
		obj.setChangedMember(v);
		return obj;
	}

}
