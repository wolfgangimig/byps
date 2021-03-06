package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteClassAsync DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteClassAsync:68
public interface RemoteArrayTypes1dimAsync extends BRemote, 
	RemoteArrayTypes1dim {
	/**
	 * @consumes multipart/form-data
	 * @param ci ClientInfo object with language, country and ticket
	 * @param sord Indexing information or null.
	 * @param sordZ Elements of <code>sord</code> to be stored into the database.
	 * @param document Document object previously returned from <code>checkinDocBegin</code>
	 * @param unlockZ Unlock the object.
	 * <p>
	 * See <code>checkinDocBegin</code>, if you want to checkin new document or attachment version(s).
	 * </p>
	 * <p>
	 * Changing the document or attachment work version, version number, comment, flags or status:
	 * <code><br/><br/>
	 * Document doc = new Document();<br/>
	 * doc.objId = an object ID or GUID<br/>
	 * doc.docs = new DocVersion[] {new DocVersion()};<br/>
	 * doc.docs[0].id = a document ID;<br/>
	 * doc.docs[0].workVersion = true;<br/>
	 * doc.docs[0].version = "2.0";<br/>
	 * doc.docs[0].comment = "new comment";<br/>
	 * doc.docs[0].milestone = true;<br/>
	 * doc.docs[0].deleted = false;<br/>
	 * ix.checkinDocEnd(ci, null, null, doc, LOCK.NO);<br/>
	 * </code>
	 * </p>
	 * <p>
	 * If the supplied sord has <code>sord.type==LBT_DOCUMENT</code>, sord.type will be detected from
	 * the file extension of the given work version.
	 * </p>
	 * <p>
	 * If the document is only to be unlocked, see <code>checkinSord</code>.
	 * </p>
	 * @return Complete Document information - in particular the document ID.
	 * @see SordC SordC
	 * @see #checkinDocBegin checkinDocBegin
	 * @see #checkinDocsEnd checkinDocsEnd
	 * Checks in an uploaded document.
	 * @throws RemoteException Exception with message text of format "[ELOIX:number] text". The number is one of the constants defined in IXExceptionC. Exception with message text of format "[ELOIX:number] text".
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setBool(boolean[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setBool(boolean[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setByte(byte[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setByte(byte[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setChar(char[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setChar(char[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setShort(short[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setShort(short[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setInt(int[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setInt(int[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setLong(long[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setLong(long[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setFloat(float[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setFloat(float[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setDouble(double[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setDouble(double[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setString(java.lang.String[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setString(java.lang.String[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setPrimitiveTypes(byps.test.api.prim.PrimitiveTypes[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setPrimitiveTypes(byps.test.api.prim.PrimitiveTypes[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setObject(java.lang.Object[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setObject(java.lang.Object[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public void setDate(java.util.Date[] v) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void setDate(java.util.Date[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public boolean[] getBool() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getBool(final BAsyncResult<boolean[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public byte[] getByte() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getByte(final BAsyncResult<byte[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public char[] getChar() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getChar(final BAsyncResult<char[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public short[] getShort() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getShort(final BAsyncResult<short[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public int[] getInt() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getInt(final BAsyncResult<int[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public long[] getLong() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getLong(final BAsyncResult<long[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public float[] getFloat() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getFloat(final BAsyncResult<float[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public double[] getDouble() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getDouble(final BAsyncResult<double[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public java.lang.String[] getString() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getString(final BAsyncResult<java.lang.String[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public byps.test.api.prim.PrimitiveTypes[] getPrimitiveTypes() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getPrimitiveTypes(final BAsyncResult<byps.test.api.prim.PrimitiveTypes[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public java.lang.Object[] getObject() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getObject(final BAsyncResult<java.lang.Object[]> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:396
	public java.util.Date[] getDate() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:440
	public void getDate(final BAsyncResult<java.util.Date[]> asyncResult) ;
	
	
}
