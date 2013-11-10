package byps.test.servlet;

import java.util.Date;

import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.BSkeleton_RemoteArrayTypes1dim;

public class MyRemoteArrayTypes1dim extends BSkeleton_RemoteArrayTypes1dim {
	
	public boolean[] boolean1;
	public byte[] byte1;
	public char[] char1;
	public short[] short1;
	public int[] int1;
	public long[] long1;
	public float[] float1;
	public double[] double1;
	public String[] string1;
	public PrimitiveTypes[] primitiveTypes1;
	public Object[] object1;
	public Date[] date1;

	@Override
	public void setBool(boolean[] v) throws RemoteException {
		boolean1 = v;
	}

	@Override
	public void setByte(byte[] v) throws RemoteException {
		byte1 = v;
	}

	@Override
	public void setChar(char[] v) throws RemoteException {
		char1 = v;
	}

	@Override
	public void setShort(short[] v) throws RemoteException {
		short1 = v;
	}

	@Override
	public void setInt(int[] v) throws RemoteException {
		int1 = v;
	}

	@Override
	public void setLong(long[] v) throws RemoteException {
		long1 = v;
	}

	@Override
	public void setFloat(float[] v) throws RemoteException {
		float1 = v;
	}

	@Override
	public void setDouble(double[] v) throws RemoteException {
		double1 = v;
	}

	@Override
	public void setString(String[] v) throws RemoteException {
		string1 = v;
	}

	@Override
	public void setPrimitiveTypes(PrimitiveTypes[] v) throws RemoteException {
		primitiveTypes1 = v;
	}

	@Override
	public void setObject(Object[] v) throws RemoteException {
		object1 = v;
	}

	@Override
	public boolean[] getBool() throws RemoteException {
		return boolean1;
	}

	@Override
	public byte[] getByte() throws RemoteException {
		return byte1;
	}

	@Override
	public char[] getChar() throws RemoteException {
		return char1;
	}

	@Override
	public short[] getShort() throws RemoteException {
		return short1;
	}

	@Override
	public int[] getInt() throws RemoteException {
		return int1;
	}

	@Override
	public long[] getLong() throws RemoteException {
		return long1;
	}

	@Override
	public float[] getFloat() throws RemoteException {
		return float1;
	}

	@Override
	public double[] getDouble() throws RemoteException {
		return double1;
	}

	@Override
	public String[] getString() throws RemoteException {
		return string1;
	}

	@Override
	public PrimitiveTypes[] getPrimitiveTypes() throws RemoteException {
		return primitiveTypes1;
	}

	@Override
	public Object[] getObject() throws RemoteException {
		return object1;
	}

  public Date[] getDate() {
    return date1;
  }

  public void setDate(Date[] date1) {
    this.date1 = date1;
  }

}
