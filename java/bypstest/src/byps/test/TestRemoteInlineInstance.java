package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.inl.Actor;
import byps.test.api.inl.Matrix2D;
import byps.test.api.inl.Point2D;
import byps.test.api.remote.RemoteInlineInstance;

public class TestRemoteInlineInstance {

	BClient_Testser client;
	RemoteInlineInstance remote;
	private Logger log = LoggerFactory.getLogger(TestRemoteInlineInstance.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getRemoteInlineInstance();
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
		
		obj.position._11 = 11;
		obj.position._12 = 12;
		obj.position._13 = 13;
		obj.position._21 = 21;
		obj.position._22 = 22;
		obj.position._23 = 23;
		obj.position._31 = 31;
		obj.position._32 = 32;
		obj.position._33 = 33;
		
		obj.shape = new Point2D[3];
		for (int i = 0; i < obj.shape.length; i++) {
			obj.shape[i] = createPoint2D();
		}
		return obj;
	}
	
	short x = 1;
	private Point2D createPoint2D() {
		Point2D p = new Point2D();
		p.x = x++;
		p.y = (short)(x*x);
		return p;
	}

	@Test
	public void testRemoteInlineInstance() throws RemoteException {
		log.info("testRemoteInlineInstance(");
		
		Actor actor = createActor();
		remote.setActor(actor);
		
		TestUtils.assertEquals(log, "actor", actor, remote.getActor());
		
		log.info(")testRemoteInlineInstance");
	}
	
	@Test
	public void testRemoteInlineInstanceArray1dim() throws RemoteException {
		log.info("testRemoteInlineInstanceArray1dim(");
		
		Point2D[] point2DArray = new Point2D[] {createPoint2D(), createPoint2D()};
		remote.setPoint2DArray1dim(point2DArray);
		
		TestUtils.assertEquals(log, "point2D", point2DArray, remote.getPoint2DArray1dim());
		
		log.info(")testRemoteInlineInstanceArray1dim");
	}

	@Test
	public void testRemoteInlineInstanceArray4dim() throws RemoteException {
		log.info("testRemoteInlineInstanceArray4dim(");
		
		Point2D[][][][] point2DArray = new Point2D[][][][] {{{{createPoint2D(), createPoint2D()}}}};
		remote.setPoint2DArray4dim(point2DArray);
		
		TestUtils.assertEquals(log, "point2D", point2DArray, remote.getPoint2DArray4dim());
		
		log.info(")testRemoteInlineInstanceArray4dim");
	}

	@Test
	public void testRemoteInlineInstanceList() throws RemoteException {
		log.info("testRemoteInlineInstanceList(");
		
		List<Point2D> point2DList = new ArrayList<Point2D>();
		point2DList.add(createPoint2D());
		point2DList.add(createPoint2D());
		remote.setPoint2DList(point2DList);
		
		TestUtils.assertEquals(log, "point2D", point2DList, remote.getPoint2DList());
		
		log.info(")testRemoteInlineInstanceList");
	}

	@Test
	public void testRemoteInlineInstanceListList() throws RemoteException {
		log.info("testRemoteInlineInstanceListList(");
		
		List<List<Point2D>> point2DListList = new ArrayList<List<Point2D>>();
		ArrayList<Point2D> point2DList = new ArrayList<Point2D>();
		point2DListList.add(point2DList);
		point2DList.add(createPoint2D());
		point2DList.add(createPoint2D());
		remote.setPoint2DListList(point2DListList);
		
		TestUtils.assertEquals(log, "point2D", point2DListList, remote.getPoint2DListList());
		
		log.info(")testRemoteInlineInstanceListList");
	}

	@Test
	public void testRemoteInlineInstanceMap() throws RemoteException {
		log.info("testRemoteInlineInstanceMap(");
		
		Map<Integer, Point2D> point2DMap = new HashMap<Integer, Point2D>();
		point2DMap.put(11, createPoint2D());
		point2DMap.put(12, createPoint2D());
		remote.setPoint2DMap(point2DMap);
		
		TestUtils.assertEquals(log, "point2D", point2DMap, remote.getPoint2DMap());
		
		log.info(")testRemoteInlineInstanceMap");
	}

}
