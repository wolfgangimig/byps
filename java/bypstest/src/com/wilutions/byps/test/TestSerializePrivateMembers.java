package com.wilutions.byps.test;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.priv.PrivateMembers;

/**
 *
 */
public class TestSerializePrivateMembers {
	
	BTransport transport = TestUtils.createTransport();
	private Log log = LogFactory.getLog(TestSerializePrivateMembers.class);
	
	
	@Test
	public void testPrivateMembers() throws BException {
		log.info("testPrivateMembers(");
		
		PrivateMembers obj = new PrivateMembers();
		obj.setStringVal("");
		
		// Test with null values
		internalTestPrivateMembers(obj);

		// Assign some values
		obj.setBoolVal(true);
		obj.setByteVal((byte)33);
		obj.setCharVal('A');
		obj.setDoubleVal(2.2);
		obj.setFloatVal(3.4f);
		obj.setIntVal(56);
		obj.setLongVal(78);
		obj.setPprotInt(90);
		obj.setProtInt(101);
		obj.setShortVal((short)220);
		obj.setStringVal("330");
		obj.setArrBool(new boolean[] {true,false,true});
		obj.setArrInt(new int[] {1,2,3,4});
		obj.setArrPrimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() });
		obj.setArrString(new String[] {"ABC", "DEF"});
		obj.setListBool(Arrays.asList(false, true, false));
		obj.setListInt(Arrays.asList(1,2,3,4));
		obj.setListPrimitiveTypes(Arrays.asList(TestUtils.createObjectPrimitiveTypes()));
		obj.setListString(Arrays.asList("€€€", "EEE"));
		obj.setPrimitiveTypes(TestUtils.createObjectPrimitiveTypes());
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		map.put(123, Arrays.asList("abc","def"));
		obj.setMapIntListString(map);

		internalTestPrivateMembers(obj);

		log.info(")testPrivateMembers");
	}

	private void internalTestPrivateMembers(PrivateMembers obj) throws BException {
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		Object objR = (Object)bin.load();
	
		TestUtils.assertEquals(log, "obj.class", obj.getClass(), objR.getClass());
		
		TestUtils.assertEquals(log, "obj", obj, objR);
	}
	
}
