package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BBinaryModel;
import byps.BMessageHeader;
import byps.BProtocolJson;
import byps.BRegistry;
import byps.BSyncResult;
import byps.BTransportFactory;
import byps.BWire;
import byps.RemoteException;
import byps.http.HConstants;
import byps.http.HTransportFactoryClient;
import byps.http.HWireClient;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.BRegistry_Testser;
import byps.test.api.JRegistry_Testser;

public class TestUtilsHttp {

	private static final int READ_TIMEOUT = 60;

  private static Log log = LogFactory.getLog(TestUtilsHttp.class);
	
	//public static String url = "http://www.wilutions.com/bypstest-srv/bypsservlet";
	public static String url = "http://localhost:6080/bypstest-srv/bypsservlet";
	public static String url2 = "http://localhost:5080/bypstest-srv/bypsservlet";
	//public static String url = "http://srvtdev02:8020/bypstest-srv/bypsservlet";
	
	private static Executor tpool = Executors.newCachedThreadPool();
	
  public static BClient_Testser createClient() throws RemoteException {
    return createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, BApiDescriptor_Testser.VERSION, 1);
  }
  
  public static BClient_Testser createClient(int nbOfReverseRequests) throws RemoteException {
    return createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, BApiDescriptor_Testser.VERSION, nbOfReverseRequests);
  }
  
	public static BClient_Testser createClient(BBinaryModel protocolSpec, int flags, int bypsVersion, long appVersion, int nbOfReverseRequests) throws RemoteException {
		
		BRegistry registry = null;
		
		if (protocolSpec == BProtocolJson.BINARY_MODEL){
			registry = new JRegistry_Testser();
		}
		else {
			registry = new BRegistry_Testser();
		}
		
		System.setProperty("http.maxConnections", "100");
		
		// Define an API descriptor with an application version from static member appVersion.
		BApiDescriptor myDesc = new BApiDescriptor(
				BApiDescriptor_Testser.instance().name,
				BApiDescriptor_Testser.instance().basePackage,
				appVersion,
				BApiDescriptor_Testser.instance().uniqueObjects
				);
		
		myDesc.addRegistry(registry);

		BWire wire = new HWireClient(url, flags, READ_TIMEOUT, tpool);
		final BTransportFactory transportFactory = new HTransportFactoryClient(myDesc, wire, nbOfReverseRequests); 
		
		BClient_Testser client = BClient_Testser.createClient(transportFactory);

		BSyncResult<Boolean> syncResult = new BSyncResult<Boolean>();
		client.start(syncResult);
		
		syncResult.getResult();
		return client;
	}
	
	public static BClient_Testser createClient2() throws RemoteException {
		
		BWire wire = new HWireClient(url2, BWire.FLAG_DEFAULT, READ_TIMEOUT, tpool);
		
		final BTransportFactory transportFactory = new HTransportFactoryClient(
				BApiDescriptor_Testser.instance(), wire, 3); 
		
		BClient_Testser client = BClient_Testser.createClient(transportFactory);

		BSyncResult<Boolean> syncResult = new BSyncResult<Boolean>();
		client.start(syncResult);
		
		syncResult.getResult();
		return client;
		
	}
		
	public static ArrayList<InputStream> makeTestStreams() throws IOException {
		log.info("makeTestStreams(");
		ArrayList<InputStream> ret = new ArrayList<InputStream>();
    ret.add(new TestUtils.MyContentStream(11, true));
		ret.add(new TestUtils.MyContentStream(0, true));
		ret.add(new TestUtils.MyContentStream(1, true));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER-1, true));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER, true));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER+1, true));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER*2, true));
		ret.add(new TestUtils.MyContentStream(0, false));
		ret.add(new TestUtils.MyContentStream(1, false));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER-1, false));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER, false));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER+1, false));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER*2, false));
    ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER*100, false));
		if (TestUtils.TEST_LARGE_STREAMS) {
		  long contentLength = Double.valueOf(4.0e9).longValue();
			ret.add(new TestUtils.MyContentStream(contentLength, false));
		}
		log.info(")makeTestStreams=" + ret);
		return ret;
	}
	
}
