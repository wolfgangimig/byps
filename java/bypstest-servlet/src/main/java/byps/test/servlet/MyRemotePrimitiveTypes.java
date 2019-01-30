package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.BSkeleton_RemotePrimitiveTypes;

public class MyRemotePrimitiveTypes extends BSkeleton_RemotePrimitiveTypes {
	
	public boolean boolVal;
	public byte byteVal;
	public char charVal;
	public short shortVal;
	public int intVal;
	public long longVal;
	public float floatVal;
	public double doubleVal;
	public String stringVal;
	public Object objectVal;
	public PrimitiveTypes primitiveTypesVal;
	public Date dateVal;

	public void setBool(boolean v) throws RemoteException {
		this.boolVal = v;
	}
	
	public boolean getBool() throws RemoteException {
		return this.boolVal;
	}
	
	@Override
	public void setByte(byte v) throws RemoteException {
		this.byteVal = v;
	}
	
	@Override
	public byte getByte() throws RemoteException {
		return byteVal;
	}
	
	@Override
	public void setChar(char v) throws RemoteException {
		charVal = v;
	}
	
	@Override
	public char getChar() throws RemoteException {
		return charVal;
	}
	
	@Override
	public void setShort(short v) throws RemoteException {
		shortVal = v;
	}
	
	@Override
	public short getShort() throws RemoteException {
		return shortVal;
	}
	
	@Override
	public void setInt(int v) throws RemoteException {
		intVal = v;
	}
	
	@Override
	public int getInt() throws RemoteException {
		return intVal;
	}
	
	@Override
	public void setLong(long v) throws RemoteException {
		longVal = v;
	}
	
	@Override
	public long getLong() throws RemoteException {
		return longVal;
	}
	
	@Override
	public void setFloat(float v) throws RemoteException {
		floatVal = v;
	}
	
	@Override
	public float getFloat() throws RemoteException {
		return floatVal;
	}

	@Override
	public void setDouble(double v) throws RemoteException {
		doubleVal = v;
	}
	
	@Override
	public double getDouble() throws RemoteException {
		return doubleVal;
	}
	
	@Override
	public void setString(String v) throws RemoteException {
		stringVal = v;
	}
	
	@Override
	public String getString() throws RemoteException {
		return stringVal;
	}
	
	@Override
	public void setObject(Object v) throws RemoteException {
		objectVal = v;
	}
	
	@Override
	public Object getObject() throws RemoteException {
		return objectVal;
	}
	
	@Override
	public void setPrimitiveTypes(PrimitiveTypes v) throws RemoteException {
		primitiveTypesVal = v;
	}
	
	@Override
	public PrimitiveTypes getPrimitiveTypes() throws RemoteException {
		return primitiveTypesVal;
	}
	
	@Override
	public void sendAllTypes(boolean b, char c, short s, int i, long l,
			float f, double d, String str, PrimitiveTypes pt, Object o)
			throws RemoteException {
		this.boolVal = b;
		this.charVal  =c;
		this.doubleVal = d;
		this.floatVal = f;
		this.intVal = i;
		this.longVal = l;
		this.shortVal = s;
		this.stringVal = str;
		this.objectVal = o;
		this.primitiveTypesVal = pt;
	}
	
	public void throwException() throws RemoteException 
	{
	  throw new BException(BExceptionC.INTERNAL, "throwException() was called");
	}

  @Override
  public void setDate(Date v) throws RemoteException {
    dateVal = v;
  }

  @Override
  public Date getDate() throws RemoteException {
    return dateVal;
  }

	@Override
	public Date makeDate(int year, int month, int day, int hour, int minute, int second, int millisecond) throws RemoteException {
	  if (year != 0) {
      GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
      calendar.set(Calendar.YEAR, year);
      calendar.set(Calendar.MONTH, month-1);
      calendar.set(Calendar.DAY_OF_MONTH, day);
      calendar.set(Calendar.HOUR_OF_DAY, hour);
      calendar.set(Calendar.MINUTE, minute);
      calendar.set(Calendar.SECOND, second);
      calendar.set(Calendar.MILLISECOND, millisecond);
      return calendar.getTime();
	  }
	  else {
	    return null;
	  }
	}
	
	@Override
	public int[] parseDate(Date date) throws RemoteException {
	  if (date != null) {
      GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
      calendar.setTime(date);
        
      final int year = calendar.get(Calendar.YEAR);
      final int month = calendar.get(Calendar.MONTH) + 1;
      final int day = calendar.get(Calendar.DAY_OF_MONTH);
      final int hour = calendar.get(Calendar.HOUR_OF_DAY);
      final int minute = calendar.get(Calendar.MINUTE);
      final int second = calendar.get(Calendar.SECOND);
      final int millis = calendar.get(Calendar.MILLISECOND);
  
      return new int[] { year, month, day, hour, minute, second, millis };
	  }
	  else {
	    return null;
	  }
	}
	
	
	@Override
  public void getDeferredValueFromServer(int param1, String param2, BAsyncResult<Integer> asyncResult) {
    asyncResult.setAsyncResult(intVal, null); 
  }
}
