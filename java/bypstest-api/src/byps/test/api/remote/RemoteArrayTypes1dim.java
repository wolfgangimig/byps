package byps.test.api.remote;

import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;

/**
 * Interface with functions using 1-dimensional arrays.
 * 
 *
 */
@Path("arrays")
public interface RemoteArrayTypes1dim extends BRemote {
  
  public final static long serialVersionUID = 123123;
	
  /**
   * Checks in an uploaded document.
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
   * @param ci ClientInfo object with language, country and ticket
   * @param sord Indexing information or null.
   * @param sordZ Elements of <code>sord</code> to be stored into the database.
   * @param document Document object previously returned from <code>checkinDocBegin</code>
   * @param unlockZ Unlock the object.
   * @return Complete Document information - in particular the document ID.
   * @throws RemoteException Exception with message text of format "[ELOIX:number] text". The number is one of the constants defined in IXExceptionC. Exception with message text of format "[ELOIX:number] text".
   * @see SordC SordC
   * @see #checkinDocBegin checkinDocBegin
   * @see #checkinDocsEnd checkinDocsEnd
   * @consumes multipart/form-data
   */
	public void setBool(boolean[] v) throws RemoteException;
  
	public void setByte(byte[] v) throws RemoteException;
	public void setChar(char[] v) throws RemoteException;
	public void setShort(short[] v) throws RemoteException;
	public void setInt(int[] v) throws RemoteException;
	public void setLong(long[] v) throws RemoteException;
	public void setFloat(float[] v) throws RemoteException;
	public void setDouble(double[] v) throws RemoteException;
	public void setString(String[] v) throws RemoteException;
	public void setPrimitiveTypes(PrimitiveTypes[] v) throws RemoteException;
	public void setObject(Object[] v) throws RemoteException;
	public void setDate(Date[] v) throws RemoteException;

	@GET
	@Path("boolpath")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean[] getBool() throws RemoteException;
	
	public byte[] getByte() throws RemoteException;
	public char[] getChar() throws RemoteException;
	public short[] getShort() throws RemoteException;
	public int[] getInt() throws RemoteException;
	public long[] getLong() throws RemoteException;
	public float[] getFloat() throws RemoteException;
	public double[] getDouble() throws RemoteException;
	public String[] getString() throws RemoteException;
	public PrimitiveTypes[] getPrimitiveTypes() throws RemoteException;
	public Object[] getObject() throws RemoteException;
	public Date[] getDate() throws RemoteException;
}
