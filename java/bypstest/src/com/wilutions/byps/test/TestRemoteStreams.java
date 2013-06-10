package com.wilutions.byps.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.TreeMap;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.BWire;
import com.wilutions.byps.http.HConstants;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.remote.RemoteStreams;

/**
 * Tests for interface functions with stream types.
 * This test requires the webapp bypstest-srv to be started. 
 */
public class TestRemoteStreams {
	
	BClient_Testser client;
	RemoteStreams remote;
	private Log log = LogFactory.getLog(TestRemoteStreams.class);

	@Before
	public void setUp() throws BException, InterruptedException {
		client = TestUtilsHttp.createClient();
		remote = client.remoteStreams;
	}
	
	@After
	public void tearDown() throws InterruptedException {
		if (client != null) {
			client.done();
		}
	}
	
	/**
	 * Send and receive a stream.
	 * It's sent by HTTP chunked encoding.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testRemoteStreamsOneStream() throws InterruptedException, IOException {
		log.info("testRemoteStreamsOneStream(");
		
		String str = "hello";
		InputStream istrm = new ByteArrayInputStream(str.getBytes());
		remote.setImage(istrm);
		
		InputStream istrmR = remote.getImage();
		ByteBuffer buf = BWire.bufferFromStream(istrmR);
		String strR = new String(buf.array(), buf.position(), buf.remaining());
		TestUtils.assertEquals(log, "stream", str, strR);
		
		remote.setImage(null);
		TestUtils.checkTempDirEmpty(client);
		
		log.info(")testRemoteStreamsOneStream");
	}
	
	/**
	 * Send and receive many streams.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testRemoteStreamsManyStreams() throws InterruptedException, IOException {
		log.info("testRemoteStreamsOneStreams(");
		Map<Integer, InputStream> streams = new TreeMap<Integer, InputStream>();
		for (int i = 0; i < 10; i++) {
			String str = "hello-" + i;
			InputStream istrm = new ByteArrayInputStream(str.getBytes());
			streams.put(i, istrm);
		}
		remote.setImages(streams, -1);
		TreeMap<Integer, InputStream> istrmsR = remote.getImages();
		
		TestUtils.assertEquals(log, "streams", streams, istrmsR); // Does not compare streams.
		for (int i = 0; i < 10; i++) {
			InputStream istrmR = istrmsR.get(i);
			ByteBuffer buf = BWire.bufferFromStream(istrmR);
			String strR = new String(buf.array(), buf.position(), buf.remaining());
			TestUtils.assertEquals(log, "stream", "hello-" + i, strR);
		}
		
		log.info(")testRemoteStreamsOneStreams");
	}
	
	
	/**
	 * Wrapper class for ByteArrayInputStream.
	 * - helps to check that all streams are closed after the request
	 * - helps to check that an Exception thrown in read() is correctly handled.
	 */
	private class MyInputStream extends BContentStream {
		
		private volatile boolean isClosed;
		boolean throwEx;
		boolean throwError;
		byte[] buf;
		int idx;
		
		/**
		 * Constructor
		 * @param buf	Buffer to read from
		 * @param throwEx	true, if an IOException has to be thrown
		 * @param throwError	true, if an IllegalStateException has to be thrown
		 */
		public MyInputStream(byte[] buf, boolean throwEx, boolean throwError) {
			this.buf = buf;
			this.throwEx = throwEx;
			this.throwError = throwError;
		}
		
		@Override
		public void close() throws IOException {
			isClosed = true;
			super.close();
		}
		
		@Override
		public int read() throws IOException {
			if (throwEx) {
				throw new IOException("Test Exception");
			}
			if (throwError) {
				throw new IllegalStateException("Test Error");
			}
			if (idx < buf.length) {
				return ((int)buf[idx++]) & 0xFF;
			}
			return -1;
		}

		@Override
		public String getContentType() {
			return null;
		}

		@Override
		public long getContentLength() {
			return buf.length;
		}
	}

	/**
	 * All the input streams sent are closed by the transport layer. 
	 * Streams not requested from the server must be closed too.
	 * @throws InterruptedException 
	 * @throws BException 
	 */
	@Test
	public void testRemoteStreamsCloseStreamAfterSend() throws BException, InterruptedException {
		log.info("testRemoteStreamsCloseStreamAfterSend(");
		int count = 100;
		
		for (int i = 0; i < count; i++) {
			internalTestRemoteStreamsClosed();
			
			String logLine = "testRemoteStreamsCloseStreamAfterSend-" + i;
			client.transport.wire.getTestAdapter().printServerLog(logLine);
		}

		log.info(")testRemoteStreamsCloseStreamAfterSend");
	}

	protected void internalTestRemoteStreamsClosed() throws BException,
			InterruptedException {
		int nbOfStreams = 10;
		Map<Integer, InputStream> mystreams = new TreeMap<Integer, InputStream>();
		for (int i = 0; i < nbOfStreams; i++) {
			String str = "hello-" + i;
			MyInputStream mystrm = new MyInputStream(str.getBytes(), false, false);
			mystreams.put(i, mystrm);
		}
		remote.setImages(mystreams, 1);
		
		for (int i = 0; i < nbOfStreams; i++) {
			MyInputStream istrm = (MyInputStream)mystreams.get(i);
			TestUtils.assertEquals(log, "InputStream["+i+"].isClosed, istrm=" + istrm, true, istrm.isClosed);
		}
	}
	

	/**
	 * Handle an Exception thrown in InputStream.read correctly.
	 * The Exception must be encapsulated in an BException.
	 * It must be passed to the caller. 
	 * All streams have to be closed.
	 * The server must have received an exception too.
	 * This function tests the handling of an IOException and IllegalStateException.
	 * All messages must have been finished after a while when the client connection has been closed.
	 * @throws InterruptedException
	 * @throws IOException 
	 * @see MyInputStream
	 */
	@Test
	public void testRemoteStreamsThrowExceptionOnRead() throws InterruptedException, IOException {
		log.info("testRemoteStreamsThrowExceptionOnRead(");
		
		for (int i = 0; i < 100; i++) {
			internalTestThrowExOnRead(true, false);
			internalTestThrowExOnRead(false, true);
		}
		
		client.transport.wire.cancelAllRequests();
		
		try {
			// There should be no active messages on the server after the client side has been finished.
			long[] messageIds = null;
			int keepMessageSeconds = ((int)HConstants.KEEP_MESSAGE_AFTER_FINISHED / 1000);
			int cleanupSeconds = (int)HConstants.CLEANUP_MILLIS/1000;
			int waitUntilMessagesExpired = 2 * Math.max(cleanupSeconds, keepMessageSeconds) + 1;
			for (int retry = 0; retry <  waitUntilMessagesExpired; retry++) {
				messageIds = client.transport.wire.getTestAdapter().getAcitveMessagesOnServer(false);
				if (messageIds.length == 0) break;
				Thread.sleep(1000);
			}
			TestUtils.assertEquals(log, "active messages: ", new long[0], messageIds);
		}
		finally {
			client.done();
			client = null;
		}
		log.info(")testRemoteStreamsThrowExceptionOnRead");

	}

	private void internalTestThrowExOnRead(boolean throwEx, boolean throwError) throws InterruptedException, IOException {
		log.info("internalTestThrowExOnRead(throwEx=" + throwEx + ", throwError=" + throwError);
		
		Map<Integer, InputStream> streams = new TreeMap<Integer, InputStream>();
		for (int i = 0; i < 3; i++) {
			String str = "hello-" + i;
			InputStream istrm = new MyInputStream(str.getBytes(), i == 1 && throwEx, i == 1 && throwError);
			streams.put(i, istrm);
			log.info("strm[" + i + "]=" + str);
		}
		
		// An exception is thrown in HWireClient.
		try {
			log.info("setImages...");
			remote.setImages(streams, -1);
			Assert.fail("Exception expected");
		}
		catch (BException e) {
			log.info("setImages ex=" + e + ", OK");
			String expectedMessage = throwEx ? "Test Exception" : "Test Error";
			String expectedDetails = throwEx ? "java.io.IOException: Test Exception" : "java.lang.IllegalStateException: Test Error";
			TestUtils.assertEquals(log, "Exception Code", BException.IOERROR, e.code);
			TestUtils.assertEquals(log, "Exception Message", expectedMessage, e.msg);
			TestUtils.assertEquals(log, "Exception Details", expectedDetails, e.details);
		}
		
		// The server must have received an exception too
		try {
			log.info("throwLastException...");
			remote.throwLastException();
			Assert.fail("Exception from server expected");
		}
		catch (BException e) {
			log.info("throwLastException OK, ex=" + e);
			TestUtils.assertEquals(log, "Exception Code", BException.IOERROR, e.code);
		}
		
		// All streams must have been closed
		log.info("streams must be closed");
		int nbOfClosed = 0;
		int keepMessageSeconds = ((int)HConstants.KEEP_MESSAGE_AFTER_FINISHED / 1000) + 1;
		for (int retry = 0; retry < 10 * keepMessageSeconds; retry++) {
			for (int i = 0; i < streams.size(); i++) {
				MyInputStream istrm = (MyInputStream)streams.get(i);
				log.info("InputStream[" + i + "].isClosed=" + istrm.isClosed);
				if (istrm.isClosed) nbOfClosed++;
			}
			if (nbOfClosed == streams.size()) break;
			nbOfClosed = 0;
			Thread.sleep(100);
		}
		for (int i = 0; i < streams.size(); i++) {
			MyInputStream istrm = (MyInputStream)streams.get(i);
			TestUtils.assertEquals(log, "InputStream[" + i + "].isClosed, stream=" + istrm, true, istrm.isClosed);
		}
		
		log.info(")internalTestThrowExOnRead");
	}
	
	/**
	 * Test for cloning streams inside the server.
	 * The server can read a stream as long as the request (message with ByteBuffer) is not finished.
	 * If streams have to be stored in member variables of the server objects, 
	 * they have to be cloned. 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testRemoteStreamsCloneStream() throws InterruptedException, IOException {
		log.info("testRemoteStreamsCloneStream(");
		
		// Use byte array as buffer
		internalTestCloneStream(1);
		internalTestCloneStream(0);
		internalTestCloneStream(HConstants.INCOMING_STREAM_BUFFER / 2);
		internalTestCloneStream(HConstants.INCOMING_STREAM_BUFFER - 1);
		internalTestCloneStream(HConstants.INCOMING_STREAM_BUFFER);
		
		// Use file as buffer
		internalTestCloneStream(HConstants.INCOMING_STREAM_BUFFER + 1);
		internalTestCloneStream(HConstants.INCOMING_STREAM_BUFFER * 2);
		
		log.info(")testRemoteStreamsCloneStream");
	}

	protected void internalTestCloneStream(long nbOfBytes) throws BException,
			InterruptedException, IOException {
		
		log.info("start upload");
		InputStream istrm = new TestUtils.MyContentStream(nbOfBytes);
		remote.setImage(istrm);
		
		for (int loop = 0; loop < 5; loop++) {
			
			// remote.getImage() clones the stream.
			log.info("start download");
			InputStream istrmR = remote.getImage();
			
			log.info("compare streams");
			istrm = new TestUtils.MyContentStream(nbOfBytes);
			TestUtils.assertEquals(log, "stream[" + loop + "]", istrm, istrmR);
		}
		
		remote.setImage(null);
		TestUtils.checkTempDirEmpty(client);

	}

	
	/**
	 * Check that streams larger than 2GB can be transferred.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testRemoteStreamsLargeStream() throws InterruptedException, IOException {
		log.info("testRemoteStreamsLargeStream(");
		
		long nbOfBytes = 3L * 1000L * 1000L * 1000L;
		
		log.info("start upload");
		InputStream istrm = new TestUtils.MyContentStream(nbOfBytes);
		remote.setImage(istrm);
		
		log.info("start download");
		InputStream istrmR = remote.getImage();
		
		log.info("compare streams");
		istrm = new TestUtils.MyContentStream(nbOfBytes);
		TestUtils.assertEquals(log, "", istrm, istrmR);
		
		remote.setImage(null);
		TestUtils.checkTempDirEmpty(client);
		
		log.info(")testRemoteStreamsLargeStream");
	}

	
}
