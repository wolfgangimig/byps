package com.wilutions.byps.test.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.srvr.BSkeleton_ServerIF;
import com.wilutions.byps.test.api.srvr.BStub_ClientIF;
import com.wilutions.byps.test.api.srvr.ClientIF;

public class MyServerIF extends BSkeleton_ServerIF {
	
	private Log log = LogFactory.getLog(MyServerIF.class);
	private MySession sess;
	private ClientIF partner;
	private static Map<Integer, ClientIF> clientMap = new TreeMap<Integer,ClientIF>();
	
	public MyServerIF(MySession sess) {
		this.sess = sess;
	}
	
	private ClientIF getClientIF() {
		if (log.isDebugEnabled()) log.debug("getClientIF(");
		ClientIF clientIF = null;
		if (partner != null) {
			if (log.isDebugEnabled()) log.debug("return partner=" + partner);
			clientIF = partner;
		}
		else {
			if (log.isDebugEnabled()) log.debug("return my client side");
			clientIF = (ClientIF)sess.getClientR().getStub((int)BStub_ClientIF.serialVersionUID);
		}
		if (log.isDebugEnabled()) log.debug(")getClientIF=" + clientIF);
		return clientIF;
	}

	@Override
	public int callClientIncrementInt(int v) throws BException,
			InterruptedException {
		if (log.isDebugEnabled()) log.debug("callClientIncrementInt(" + v);
		ClientIF clientIF = getClientIF();
		if (log.isDebugEnabled()) log.debug("inrementInt ...");
		int w = clientIF.incrementInt(v);
		if (log.isDebugEnabled()) log.debug("incrementInt OK");
		if (log.isDebugEnabled()) log.debug(")callClientIncrementInt=" + w);
		return w;
	}

	@Override
	public ClientIF getPartner() {
		if (log.isDebugEnabled()) log.debug("getPartner: " + partner);
		return partner;
	}

	@Override
	public void setPartner(ClientIF partner) {
		if (log.isDebugEnabled()) log.debug("setPartner: " + partner);
		this.partner = partner;
		
	}
	
	@Override
	public void putStreamsOnClient(List<InputStream> streams) throws BException, InterruptedException {
		ClientIF clientIF = getClientIF();
		clientIF.putStreams(streams, 0);
	}
		
	@Override
	public List<InputStream> getStreamsFromClient() throws BException,InterruptedException {
		ClientIF clientIF = getClientIF();
		List<InputStream> streams = clientIF.getStreams(0);
		ArrayList<InputStream> retStreams = new ArrayList<InputStream>();
		for (int i = 0; i < streams.size(); i++) {
			try {
				InputStream istrm = streams.get(i);
				BContentStream rstrm = ((BContentStream)istrm).cloneInputStream();
				retStreams.add(rstrm);
			} catch (IOException e) {
				throw new BException(BException.IOERROR, e.getMessage(), e);
			}
			
		}
		return retStreams;
	}
	
	@Override
	public void registerWithClientMap(int id) throws BException,
			InterruptedException {
		if (log.isDebugEnabled()) log.debug("registerWithClientMap(" + id);
		clientMap.put(id, getClientIF());
		if (log.isDebugEnabled()) log.debug(")registerWithClientMap");
	}
	
	@Override
	public ClientIF getClient(int id) throws BException, InterruptedException {
		return clientMap.get(id);
	}
	
	@Override
	public Set<Integer> getClientIds() throws BException, InterruptedException {
		return clientMap.keySet();
	}
	
	@Override
	public int callClientParallel(int nbOfCalls) throws BException,
			InterruptedException {
		if (log.isDebugEnabled()) log.debug("callClientParallel(" + nbOfCalls);
		final ClientIF clientIF = getClientIF();
		final AtomicInteger ret = new AtomicInteger(0);
		ExecutorService tpool = Executors.newCachedThreadPool();
		for (int i = 0; i < nbOfCalls; i++) {
			Runnable run = new Runnable() {
				public void run() {
					try {
						if (log.isDebugEnabled()) log.debug("clientIF.incrementInt(");
						int v = clientIF.incrementInt(0);
						if (log.isDebugEnabled()) log.debug(")clientIF.incrementInt");
						ret.addAndGet(v);
					}
					catch (Exception e) {
						log.error(e);
					}
				}
			};
			tpool.execute(run);
		}
		tpool.shutdown();
		tpool.awaitTermination(10, TimeUnit.SECONDS);
		if (log.isDebugEnabled()) log.debug(")callClientParallel");
		return ret.get();
	}
}
