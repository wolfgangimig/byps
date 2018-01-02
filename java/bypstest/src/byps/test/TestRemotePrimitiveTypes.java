package byps.test;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BAsyncResult;
import byps.BException;
import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.RemotePrimitiveTypesAsync;

/**
 * Tests for interface functions with primitive types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemotePrimitiveTypes {
	
	BClient_Testser client;
	RemotePrimitiveTypesAsync remote;
	private Log log = LogFactory.getLog(TestRemotePrimitiveTypes.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getRemotePrimitiveTypes();
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	/**
	 * Send/receive primitive data types.
	 * Tests with bool, byte, char, int, String etc.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testRemotePrimitiveTypes() throws RemoteException {
		log.info("testRemotePrimitiveTypes(");
		
		remote.setBool(true);
		TestUtils.assertEquals(log, "bool", true, remote.getBool());
		remote.setBool(false);
		TestUtils.assertEquals(log, "bool", false, remote.getBool());
		remote.setByte((byte)11);
		TestUtils.assertEquals(log, "byte", (byte)11, remote.getByte());
		remote.setChar('€');
		TestUtils.assertEquals(log, "char", '€', remote.getChar());
		remote.setShort((short)1234);
		TestUtils.assertEquals(log, "short", (short)1234, remote.getShort());
		remote.setInt(5678);
		TestUtils.assertEquals(log,  "int", 5678, remote.getInt());
		remote.setLong(890L);
		TestUtils.assertEquals(log, "long", 890L, remote.getLong());
		remote.setFloat(1.2f);
		TestUtils.assertEquals(log,  "float", 1.2f, remote.getFloat());
		remote.setDouble(1.8);
		TestUtils.assertEquals(log,  "double", 1.8, remote.getDouble());
		remote.setString("ABC");
		TestUtils.assertEquals(log,  "String", "ABC", remote.getString());
    remote.setDate(new Date(0));
    TestUtils.assertEquals(log,  "date", new Date(0), remote.getDate());
    remote.setDate(null);
    TestUtils.assertEquals(log,  "null-date", null, remote.getDate());
		
		PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
		remote.setPrimitiveTypes(pt);
		TestUtils.assertEquals(log,  "PrimitiveTypes", pt, remote.getPrimitiveTypes());
		
		log.info(")testRemotePrimitiveTypes");
	}
	
	/**
	 * Send/receive an object of class PrimitiveTypes as Java type Object.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testRemotePrimitvieTypesSendAsObjectType()  throws RemoteException {
		log.info("testRemotePrimitvieTypesSendAsObjectType(");
		
		PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
		remote.setObject(pt);
		TestUtils.assertEquals(log,  "Object", pt, remote.getObject());
		
		log.info(")testRemotePrimitvieTypesSendAsObjectType");
	}
	
	/**
	 * Send all primitive types in one call.
	 * 
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testRemotePrimitiveTypesSendAll() throws RemoteException {
		log.info("testRemotePrimitiveTypesSendAll(");
		
		PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
		PrimitiveTypes pt2  =TestUtils.createObjectPrimitiveTypes();
		remote.sendAllTypes(true, 'Q', (short)34, 56, 45, 7.4f, 9.8, "23", pt, pt2);
		
		TestUtils.assertEquals(log, "bool", true, remote.getBool());
		TestUtils.assertEquals(log, "char", 'Q', remote.getChar());
		TestUtils.assertEquals(log, "short", (short)34, remote.getShort());
		TestUtils.assertEquals(log,  "int", 56, remote.getInt());
		TestUtils.assertEquals(log, "long", 45L, remote.getLong());
		TestUtils.assertEquals(log,  "float", 7.4f, remote.getFloat());
		TestUtils.assertEquals(log,  "double", 9.8, remote.getDouble());
		TestUtils.assertEquals(log,  "String", "23", remote.getString());
		TestUtils.assertEquals(log,  "PrimtitiveTypes", pt, remote.getPrimitiveTypes());
		TestUtils.assertEquals(log,  "Object", pt2, remote.getObject());

		log.info(")testRemotePrimitiveTypesSendAll");
	}
	
	/**
	 * Send/receive an two references to the same object.
	 * The received references must also point to the same object.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testPrimitiveTypesReferenceToOtherObject() throws RemoteException {	
		log.info("testPrimitiveTypesReferenceToOtherObject(");

		PrimitiveTypes obj1 = new PrimitiveTypes();
		obj1.intVal = 123;
		// two references to the same object
		obj1.objVal = obj1.objVal2 = new PrimitiveTypes(); 
				
		remote.setPrimitiveTypes(obj1);
		PrimitiveTypes objR = remote.getPrimitiveTypes();
		
		TestUtils.assertEquals(log,  "PrimitiveTypes", obj1, objR);
		// two references to the same object
		TestUtils.assertTrue(log, "this.objVal != this.objVal2", objR.objVal == objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToOtherObject");
	}
	
	/**
	 * Send/receive an object with a reference to itself
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testPrimitiveTypesReferenceToSelf() throws RemoteException {	
		log.info("testPrimitiveTypesReferenceToSelf(");

		PrimitiveTypes obj1 = new PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = obj1; // two references to itself 
		
		remote.setPrimitiveTypes(obj1);
		PrimitiveTypes objR = remote.getPrimitiveTypes();
		
		TestUtils.assertTrue(log, "this != this.objVal", objR == objR.objVal); // self reference
		TestUtils.assertTrue(log, "this != this.objVal2", objR == objR.objVal2); // self reference
		
		log.info(")testPrimitiveTypesReferenceToSelf");
	}

	/**
	 * Tests asynchronous invocation.
	 * @throws InterruptedException
	 */
  @Test
  public void testRemoteAsync() throws InterruptedException {
    log.info("testRemoteAsync(");
    
    final boolean ret[] = new boolean[1];
    final Throwable ex[] = new Throwable[1];
    
    remote.setBool(true, new BAsyncResult<Object>() {
      public void setAsyncResult(Object ignored, Throwable exception) {
        
        remote.getBool( (Boolean result, Throwable ex2) -> {
            ret[0] = result;
            ex[0] = ex2;
          }
        );
      }
    });
    
    Thread.sleep(1000);
    if (ex[0] != null) {
      TestUtils.fail(log, ex[0].toString());
    }
    TestUtils.assertEquals(log, "wrong bool", true, ret[0]);
    
    log.info(")testRemoteAsync");
  }
  
  /**
   * Tests asynchronous invocation with null as asyncResult parameter.
   * A null can be passed, if the result is not of interest.
   * @throws InterruptedException
   */
  @Test
  public void testRemoteAsyncNull() throws InterruptedException {
    log.info("testRemoteAsyncNull(");
    
    remote.setBool(true, null);
    Thread.sleep(1000);
    
    log.info(")testRemoteAsyncNull");
  }
  
}
