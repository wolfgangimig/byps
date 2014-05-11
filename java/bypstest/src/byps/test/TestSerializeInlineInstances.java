package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.BException;
import byps.BInput;
import byps.BOutput;
import byps.BProtocolJson;
import byps.BTargetId;
import byps.BTransport;
import byps.test.api.inl.Actor;
import byps.test.api.inl.Matrix2D;
import byps.test.api.inl.Point2D;

/**
 * This class provides tests to check the 
 * serialization and deserialization of 
 * inline objects. Instances of inline
 * classes are written without type 
 * and reference information.
 * This implies that they cannot be null.
 * The serialization layer creates an instance by BSerializer.read(null, null, 0)
 * if a null value is passed.
 *
 */
public class TestSerializeInlineInstances {
	
	BTransport transport = TestUtils.createTransport();
	private Log log = LogFactory.getLog(TestSerializeInlineInstances.class);
	
	@Test
	public void testSerializeInlineInstance() throws BException {
		log.info("testSerializeInlineInstance(");
		
		Actor obj = new Actor();
		obj.position = new Matrix2D();
		obj.position._11 = 1.1f;
		obj.position._22 = 2.2f;
		obj.position._33 = 3.3f;
		obj.shape = new Point2D[3];
		for (int i = 0; i < obj.shape.length; i++) {
			obj.shape[i] = new Point2D();
			obj.shape[i].x = (short)i;
			obj.shape[i].y = (short)(i*i);
		}
		
		String jsonText = "{\"header\":{\"error\":0,\"flags\":0,\"bversion\":0,\"targetId\":\"1.1.2\",\"messageId\":\"123.\"},\"objectTable\":[null,{\"_typeId\":171948703,\"position\":{\"_11\":1.1,\"_12\":0.0,\"_13\":0.0,\"_21\":0.0,\"_22\":2.2,\"_23\":0.0,\"_31\":0.0,\"_32\":0.0,\"_33\":3.3},\"shape\":{\"*i\":-2}},[{\"x\":0,\"y\":0},{\"x\":1,\"y\":1},{\"x\":2,\"y\":4}]]}";
		internalTestSerializeInlineInstance(obj, jsonText);
		
		log.info(")testSerializeInlineInstance");
	}
	
	/**
	 * Inline instances must not be null.
	 * The serialization creates a new object, if a null value is found.
	 * @throws BException
	 */
	@Test
	public void testSerializeInlineInstanceNull() throws BException {
		log.info("testSerializeInlineInstance(");
		
		Actor obj = new Actor(); // Actor.position == null
		internalTestSerializeInlineInstance(obj, null);
		
		log.info(")testSerializeInlineInstance");
	}
	
	private void internalTestSerializeInlineInstance(Actor obj, String jsonText) throws BException {
		BOutput bout = transport.getOutput();
		bout.header.messageId = 123;
		bout.header.targetId = new BTargetId(1,1,2);
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		if (TestUtils.protocol == BProtocolJson.BINARY_MODEL && jsonText != null) { 
			try {
				String jsonTextR = new String(buf.array(), buf.position(), buf.limit(), "UTF-8");
				TestUtils.assertEquals(log, "jsonText", jsonText, jsonTextR);
			}
			catch (UnsupportedEncodingException ignored) {
			}
		}
		
		BInput bin = transport.getInput(null, buf);
		
		Object objR = (Object)bin.load();
	
		TestUtils.assertEquals(log, "obj.class", obj.getClass(), objR.getClass());
		
		if (obj.position == null) {
			obj.position = new Matrix2D();
		}
		
		TestUtils.assertEquals(log, "obj", obj, objR);
	}
	
	

}
