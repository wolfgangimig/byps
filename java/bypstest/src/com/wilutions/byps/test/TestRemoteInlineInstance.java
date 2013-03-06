package com.wilutions.byps.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.inl.Actor;
import com.wilutions.byps.test.api.inl.Matrix2D;
import com.wilutions.byps.test.api.inl.Point2D;
import com.wilutions.byps.test.api.remote.RemoteInlineInstance;

public class TestRemoteInlineInstance {

	BClient_Testser client;
	RemoteInlineInstance remote;
	private Log log = LogFactory.getLog(TestRemoteInlineInstance.class);

	@Before
	public void setUp() throws BException, InterruptedException {
		client = TestUtilsHttp.createClient();
		remote = client.remoteInlineInstance;
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	private Actor createActor() {
		Actor obj = new Actor();
		obj.position = new Matrix2D();
		obj.shape = new Point2D[3];
		for (int i = 0; i < obj.shape.length; i++) {
			obj.shape[i] = new Point2D();
			obj.shape[i].x = (short)(i + 1);
			obj.shape[i].y = (short)(obj.shape[i].x * obj.shape[i].x);
		}
		return obj;
	}

	@Test
	public void testRemoteInlineInstance() throws BException, InterruptedException {
		log.info("testRemoteInlineInstance(");
		
		Actor actor = createActor();
		remote.setActor(actor);
		
		TestUtils.assertEquals(log, "actor", actor, remote.getActor());
		
		log.info(")testRemoteInlineInstance");
	}
	
	@Test
	public void testRemoteInlineInstanceArray1dim() throws BException, InterruptedException {
		log.info("testRemoteInlineInstanceArray1dim(");
		
		Actor[] actorArray = new Actor[] {createActor(), createActor()};
		remote.setActorArray1dim(actorArray);
		
		TestUtils.assertEquals(log, "actor", actorArray, remote.getActorArray1dim());
		
		log.info(")testRemoteInlineInstanceArray1dim");
	}

	@Test
	public void testRemoteInlineInstanceArray4dim() throws BException, InterruptedException {
		log.info("testRemoteInlineInstanceArray4dim(");
		
		Actor[][][][] actorArray = new Actor[][][][] {{{{createActor(), createActor()}}}};
		remote.setActorArray4dim(actorArray);
		
		TestUtils.assertEquals(log, "actor", actorArray, remote.getActorArray4dim());
		
		log.info(")testRemoteInlineInstanceArray4dim");
	}

	@Test
	public void testRemoteInlineInstanceList() throws BException, InterruptedException {
		log.info("testRemoteInlineInstanceList(");
		
		List<Actor> actorList = new ArrayList<Actor>();
		actorList.add(createActor());
		actorList.add(createActor());
		remote.setActorList(actorList);
		
		TestUtils.assertEquals(log, "actor", actorList, remote.getActorList());
		
		log.info(")testRemoteInlineInstanceList");
	}

	@Test
	public void testRemoteInlineInstanceListList() throws BException, InterruptedException {
		log.info("testRemoteInlineInstanceListList(");
		
		List<List<Actor>> actorListList = new ArrayList<List<Actor>>();
		ArrayList<Actor> actorList = new ArrayList<Actor>();
		actorListList.add(actorList);
		actorList.add(createActor());
		actorList.add(createActor());
		remote.setActorListList(actorListList);
		
		TestUtils.assertEquals(log, "actor", actorListList, remote.getActorListList());
		
		log.info(")testRemoteInlineInstanceListList");
	}

	@Test
	public void testRemoteInlineInstanceSet() throws BException, InterruptedException {
		log.info("testRemoteInlineInstanceSet(");
		
		Set<Actor> actorSet = new HashSet<Actor>();
		actorSet.add(createActor());
		actorSet.add(createActor());
		remote.setActorSet(actorSet);
		
		TestUtils.assertEquals(log, "actor", actorSet, remote.getActorSet());
		
		log.info(")testRemoteInlineInstanceSet");
	}

	@Test
	public void testRemoteInlineInstanceMap() throws BException, InterruptedException {
		log.info("testRemoteInlineInstanceMap(");
		
		Map<Integer, Actor> actorMap = new HashMap<Integer, Actor>();
		actorMap.put(11, createActor());
		actorMap.put(12, createActor());
		remote.setActorMap(actorMap);
		
		TestUtils.assertEquals(log, "actor", actorMap, remote.getActorMap());
		
		log.info(")testRemoteInlineInstanceMap");
	}

}
