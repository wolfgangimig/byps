package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.List;
import java.util.Map;
import java.util.Set;

import byps.RemoteException;
import byps.test.api.inl.Actor;
import byps.test.api.inl.Point2D;
import byps.test.api.remote.BSkeleton_RemoteInlineInstance;

public class MyRemoteInlineInstance extends BSkeleton_RemoteInlineInstance {

	Actor point2D;
	Point2D[] point2DArray1dim;
	Point2D[][][][] point2DArray4dim;
	List<Point2D> point2DList;
	List<List<Point2D>> point2DListList;
	Set<Point2D> point2DSet;
	Map<Integer, Point2D> point2DMap;

	@Override
	public Actor getActor() throws RemoteException {
		return point2D;
	}

	@Override
	public void setActor(Actor act) throws RemoteException {
		this.point2D = act;
	}

	@Override
	public Point2D[] getPoint2DArray1dim() throws RemoteException {
		return point2DArray1dim;
	}

	@Override
	public void setPoint2DArray1dim(Point2D[] point2DArray1dim) throws RemoteException {
		this.point2DArray1dim = point2DArray1dim;
	}

	@Override
	public Point2D[][][][] getPoint2DArray4dim() throws RemoteException {
		return point2DArray4dim;
	}

	@Override
	public void setPoint2DArray4dim(Point2D[][][][] point2DArray4dim) throws RemoteException {
		this.point2DArray4dim = point2DArray4dim;
	}

	@Override
	public List<Point2D> getPoint2DList() throws RemoteException {
		return point2DList;
	}

	@Override
	public void setPoint2DList(List<Point2D> point2DList) throws RemoteException {
		this.point2DList = point2DList;
	}

	@Override
	public List<List<Point2D>> getPoint2DListList() throws RemoteException {
		return point2DListList;
	}

	@Override
	public void setPoint2DListList(List<List<Point2D>> point2DListList) throws RemoteException {
		this.point2DListList = point2DListList;
	}


	@Override
	public Map<Integer, Point2D> getPoint2DMap() throws RemoteException {
		return point2DMap;
	}

	@Override
	public void setPoint2DMap(Map<Integer, Point2D> point2DMap) throws RemoteException {
		this.point2DMap = point2DMap;
	}

}
