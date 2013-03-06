package com.wilutions.byps.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BMessage;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BSyncResult;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BWire;
import com.wilutions.byps.test.api.strm.Stream1;

/**
 *
 */
public class TestSerializeStream {
	
	BTransport transport = TestUtils.createTransport();
	private Log log = LogFactory.getLog(TestSerializeStream.class);
	
	/**
	 * Serialize one stream.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testSerializeStream() throws InterruptedException, IOException {
		log.info("testSerializeStream(");
		
		byte[] bytes = new byte[] {1,2,3,4,5};
		
		Stream1 obj = new Stream1(); 
		obj.is1 = new ByteArrayInputStream(bytes);
		Stream1 objR = internaltestSerializeStream(obj);
		
		ByteBuffer ibuf = ByteBuffer.wrap(bytes);
		ByteBuffer obuf = BWire.bufferFromStream(objR.is1);
		TestUtils.assertEquals(log, "stream", ibuf, obuf);
		
		objR.is1.close();
		
		log.info(")testSerializeStream");
	}

	/**
	 * Serialize array of streams.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testSerializeArrayStream() throws InterruptedException, IOException {
		log.info("testSerializeArrayStream(");
		
		String[] contents = new String[] {"abcdefghij", "1234567" };
		
		Stream1 obj = new Stream1(); 
		obj.setArrStream(new InputStream[] {
			new ByteArrayInputStream(contents[0].getBytes()),
			new ByteArrayInputStream(contents[1].getBytes()),
		});
		
		Stream1 objR = internaltestSerializeStream(obj);
		
		for (int i = 0; i < contents.length; i++) {
			ByteBuffer ibuf = ByteBuffer.wrap(contents[i].getBytes());
			ByteBuffer obuf = BWire.bufferFromStream(objR.getArrStream()[i]);
			TestUtils.assertEquals(log, "stream[" + i + "]", ibuf, obuf);
			
			objR.getArrStream()[i].close();
		}
		
		log.info(")testSerializeArrayStream");
	}

	/**
	 * Serialize array of streams.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testSerializeListStream() throws InterruptedException, IOException {
		log.info("testSerializeListStream(");
		
		String[] contents = new String[] {"abcdefghij", "1234567" };
		
		Stream1 obj = new Stream1(); 
		obj.setListStream(Arrays.asList(
			(InputStream)new ByteArrayInputStream(contents[0].getBytes()),
			(InputStream)new ByteArrayInputStream(contents[1].getBytes())
			)
		);
		
		Stream1 objR = internaltestSerializeStream(obj);
		
		for (int i = 0; i < contents.length; i++) {
			ByteBuffer ibuf = ByteBuffer.wrap(contents[i].getBytes());
			ByteBuffer obuf = BWire.bufferFromStream(objR.getListStream().get(i));
			TestUtils.assertEquals(log, "stream[" + i + "]", ibuf, obuf);
			
			objR.getListStream().get(i).close();
		}
		
		log.info(")testSerializeListStream");
	}

	/**
	 * Serialize a map of streams.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testSerializeMapStream() throws InterruptedException, IOException {
		log.info("testSerializeMapStream(");
		
		String[] contents = new String[] {"abcdefghij", "1234567" };
		
		Stream1 obj = new Stream1(); 
		obj.mapStream = new TreeMap<Integer, InputStream>();
		obj.mapStream.put(0, new ByteArrayInputStream(contents[0].getBytes()));
		obj.mapStream.put(1, new ByteArrayInputStream(contents[1].getBytes()));
		
		Stream1 objR = internaltestSerializeStream(obj);
		
		for (int i = 0; i < contents.length; i++) {
			ByteBuffer ibuf = ByteBuffer.wrap(contents[i].getBytes());
			ByteBuffer obuf = BWire.bufferFromStream(objR.mapStream.get(i));
			TestUtils.assertEquals(log, "stream[" + i + "]", ibuf, obuf);
			
			objR.mapStream.get(i).close();
		}
		
		log.info(")testSerializeMapStream");
	}

	private Stream1 internaltestSerializeStream(Stream1 obj) throws BException, InterruptedException {
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		BSyncResult<BMessage> outerResult = new BSyncResult<BMessage>();
		transport.wire.send(bout.toMessage(), outerResult);
		
		BMessage omsg = outerResult.getResult();
		BInput bin = transport.getInput(null, omsg.buf);
		
		Stream1 objR = (Stream1)bin.load();
	
		TestUtils.assertEquals(log, "obj.class", obj.getClass(), objR.getClass());
		
		TestUtils.assertEquals(log, "obj", obj, objR);
		
		return objR;
	}
	
	

}
