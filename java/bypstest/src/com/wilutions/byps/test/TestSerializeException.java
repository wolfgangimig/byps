package com.wilutions.byps.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.test.api.remote.FirstException;

/**
 * Tests serialization of Exception types.
 * 
 *
 */
public class TestSerializeException {

	private Log log = LogFactory.getLog(TestSerializeException.class);
	BTransport transport = TestUtils.createTransport();

	@Test
	public void testSerializeException() throws BException {
		log.info("testSerializeException(");
		FirstException ex = new FirstException();
		internalTestSerializeException(ex);
		
		ex.listOfStrings = new ArrayList<String>();
		ex.listOfStrings.add("String1");
		internalTestSerializeException(ex);
		
		log.info(")testSerializeException");
	}

	private void internalTestSerializeException(Object obj) throws BException {
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		Object objR = bin.load();
		
		TestUtils.assertEquals(log, "", obj, objR);
	}
	
}
