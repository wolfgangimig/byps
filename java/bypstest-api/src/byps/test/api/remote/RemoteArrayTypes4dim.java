package byps.test.api.remote;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;

/**
 * Interface with functions using 4-dimensional arrays.
 *
 */
public interface RemoteArrayTypes4dim extends BRemote {
	
	public void setBool(boolean[][][][] v) throws RemoteException;
	public void setByte(byte[][][][] v) throws RemoteException;
	public void setChar(char[][][][] v) throws RemoteException;
	public void setShort(short[][][][] v) throws RemoteException;
	public void setInt(int[][][][] v) throws RemoteException;
	public void setLong(long[][][][] v) throws RemoteException;
	public void setFloat(float[][][][] v) throws RemoteException;
	public void setDouble(double[][][][] v) throws RemoteException;
	public void setString(String[][][][] v) throws RemoteException;
	public void setPrimitiveTypes(PrimitiveTypes[][][][] v) throws RemoteException;
	public void setObject(Object[][][][] v) throws RemoteException;

	public boolean[][][][] getBool() throws RemoteException;
	public byte[][][][] getByte() throws RemoteException;
	public char[][][][] getChar() throws RemoteException;
	public short[][][][] getShort() throws RemoteException;
	public int[][][][] getInt() throws RemoteException;
	public long[][][][] getLong() throws RemoteException;
	public float[][][][] getFloat() throws RemoteException;
	public double[][][][] getDouble() throws RemoteException;
	public String[][][][] getString() throws RemoteException;
	public PrimitiveTypes[][][][] getPrimitiveTypes() throws RemoteException;
	public Object[][][][] getObject() throws RemoteException;

}
