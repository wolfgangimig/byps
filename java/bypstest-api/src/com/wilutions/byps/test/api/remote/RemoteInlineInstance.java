package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.inl.Actor;
import com.wilutions.byps.test.api.inl.Point2D;

/**
 * 
 */
public interface RemoteInlineInstance extends BRemote {
	
	public void setActor(Actor act) throws RemoteException;
	public Actor getActor() throws RemoteException;

	public void setPoint2DArray1dim(Point2D[] pointArray) throws RemoteException;
	public Point2D[] getPoint2DArray1dim() throws RemoteException;

	public void setPoint2DArray4dim(Point2D[][][][] pointArray) throws RemoteException;
	public Point2D[][][][] getPoint2DArray4dim() throws RemoteException;

	public void setPoint2DList(List<Point2D> pointList) throws RemoteException;
	public List<Point2D> getPoint2DList() throws RemoteException;
	
	public void setPoint2DListList(List<List<Point2D>> pointListList) throws RemoteException;
	public List<List<Point2D>> getPoint2DListList() throws RemoteException;
	
	public void setPoint2DMap(Map<Integer, Point2D> pointMap) throws RemoteException;
	public Map<Integer, Point2D> getPoint2DMap() throws RemoteException;
}
