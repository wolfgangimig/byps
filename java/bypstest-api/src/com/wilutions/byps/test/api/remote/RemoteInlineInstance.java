package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.inl.Actor;
import com.wilutions.byps.test.api.inl.Point2D;

/**
 * 
 */
public interface RemoteInlineInstance extends BRemote {
	
	public void setActor(Actor act) throws BException, InterruptedException;
	public Actor getActor() throws BException, InterruptedException;

	public void setPoint2DArray1dim(Point2D[] pointArray) throws BException, InterruptedException;
	public Point2D[] getPoint2DArray1dim() throws BException, InterruptedException;

	public void setPoint2DArray4dim(Point2D[][][][] pointArray) throws BException, InterruptedException;
	public Point2D[][][][] getPoint2DArray4dim() throws BException, InterruptedException;

	public void setPoint2DList(List<Point2D> pointList) throws BException, InterruptedException;
	public List<Point2D> getPoint2DList() throws BException, InterruptedException;
	
	public void setPoint2DListList(List<List<Point2D>> pointListList) throws BException, InterruptedException;
	public List<List<Point2D>> getPoint2DListList() throws BException, InterruptedException;
	
	public void setPoint2DMap(Map<Integer, Point2D> pointMap) throws BException, InterruptedException;
	public Map<Integer, Point2D> getPoint2DMap() throws BException, InterruptedException;
}
