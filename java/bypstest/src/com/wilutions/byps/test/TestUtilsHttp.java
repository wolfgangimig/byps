package com.wilutions.byps.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BException;
import com.wilutions.byps.BNegotiate;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.BSyncResult;
import com.wilutions.byps.BTransportFactory;
import com.wilutions.byps.BWire;
import com.wilutions.byps.http.HConstants;
import com.wilutions.byps.http.HTransportFactoryClient;
import com.wilutions.byps.http.HWireClient;
import com.wilutions.byps.test.api.BApiDescriptor_Testser;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.BRegistry_Testser;
import com.wilutions.byps.test.api.JRegistry_Testser;

public class TestUtilsHttp {

	private static Log log = LogFactory.getLog(TestUtilsHttp.class);
	
	public static String url = "http://localhost:6080/bypstest-srv/bypsservlet";
	//public static String url = "http://srvtdev02:8020/bypstest-srv/bypsservlet";
	
	private static Executor tpool = Executors.newCachedThreadPool();
	
	public static BClient_Testser createClient() throws BException, InterruptedException {
		return createClient(TestUtils.bmodel, BWire.FLAG_DEFAULT, BApiDescriptor_Testser.VERSION);
	}
	
	public static BClient_Testser createClient(BBinaryModel bmodel, int flags, int appVersion) throws BException, InterruptedException {
		
		String protocol = "";
		BRegistry registry = null;
		
		if (bmodel == BBinaryModel.JSON){
			protocol = BNegotiate.JSON;
			registry = new JRegistry_Testser(BBinaryModel.JSON);
		}
		else {
			protocol = BNegotiate.BINARY_STREAM;
			registry = new BRegistry_Testser(bmodel);
		}
		
		System.setProperty("http.maxConnections", "100");
		
		// Define an API descriptor with an application version from static member appVersion.
		BApiDescriptor myDesc = new BApiDescriptor(
				BApiDescriptor_Testser.instance.name,
				BApiDescriptor_Testser.instance.basePackage,
				BApiDescriptor_Testser.instance.bmodel,
				appVersion,
				BApiDescriptor_Testser.instance.uniqueObjects,
				protocol,
				registry
				);

		BWire wire = new HWireClient(url, flags, 600, tpool);
		final BTransportFactory transportFactory = new HTransportFactoryClient(myDesc, wire, 3); 
		
		BClient_Testser client = BClient_Testser.createClient(transportFactory);

		BSyncResult<BClient> syncResult = new BSyncResult<BClient>();
		client.start(syncResult);
		
		syncResult.getResult();
		return client;
	}
		
	public static ArrayList<InputStream> makeTestStreams() throws IOException {
		log.info("makeTestStreams(");
		ArrayList<InputStream> ret = new ArrayList<InputStream>();
		ret.add(new TestUtils.MyContentStream(0));
		ret.add(new TestUtils.MyContentStream(1));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER-1));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER+1));
		ret.add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER*2));
		ret.add(new TestUtils.MyContentStream(3L * 1000L * 1000L * 1000L));
		log.info(")makeTestStreams=" + ret);
		return ret;
	}
	
}
