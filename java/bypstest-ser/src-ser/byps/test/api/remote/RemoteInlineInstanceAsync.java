package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteClassAsync DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteClassAsync:68
public interface RemoteInlineInstanceAsync extends BRemote, 
	RemoteInlineInstance {
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setActor(byps.test.api.inl.Actor act) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setActor(byps.test.api.inl.Actor act, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public byps.test.api.inl.Actor getActor() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getActor(final BAsyncResult<byps.test.api.inl.Actor> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setPoint2DArray1dim(byps.test.api.inl.Point2D[] pointArray) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setPoint2DArray1dim(byps.test.api.inl.Point2D[] pointArray, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public byps.test.api.inl.Point2D[] getPoint2DArray1dim() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getPoint2DArray1dim(final BAsyncResult<byps.test.api.inl.Point2D[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setPoint2DArray4dim(byps.test.api.inl.Point2D[][][][] pointArray) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setPoint2DArray4dim(byps.test.api.inl.Point2D[][][][] pointArray, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public byps.test.api.inl.Point2D[][][][] getPoint2DArray4dim() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getPoint2DArray4dim(final BAsyncResult<byps.test.api.inl.Point2D[][][][]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setPoint2DList(java.util.List<byps.test.api.inl.Point2D> pointList) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setPoint2DList(java.util.List<byps.test.api.inl.Point2D> pointList, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public java.util.List<byps.test.api.inl.Point2D> getPoint2DList() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getPoint2DList(final BAsyncResult<java.util.List<byps.test.api.inl.Point2D>> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setPoint2DListList(java.util.List<java.util.List<byps.test.api.inl.Point2D>> pointListList) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setPoint2DListList(java.util.List<java.util.List<byps.test.api.inl.Point2D>> pointListList, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public java.util.List<java.util.List<byps.test.api.inl.Point2D>> getPoint2DListList() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getPoint2DListList(final BAsyncResult<java.util.List<java.util.List<byps.test.api.inl.Point2D>>> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setPoint2DMap(java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D> pointMap) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setPoint2DMap(java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D> pointMap, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D> getPoint2DMap() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getPoint2DMap(final BAsyncResult<java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>> asyncResult) ;
	
	
}
