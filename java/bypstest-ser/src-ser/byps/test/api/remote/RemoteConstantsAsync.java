package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteClassAsync DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteClassAsync:68
public interface RemoteConstantsAsync extends BRemote, 
	RemoteConstants {
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:359
	public void compare_HebrewC(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:403
	public void compare_HebrewC(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:359
	public boolean compare_AllTypesC(boolean bool1s, boolean bool2s, char char1s, java.lang.String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, java.lang.String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[][][][] arrInt4, java.lang.String[] arrStrings, java.lang.String[][][][] arrStrings4, byps.test.api.cons.AllTypesZ[][] arrAll) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:403
	public void compare_AllTypesC(boolean bool1s, boolean bool2s, char char1s, java.lang.String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, java.lang.String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[][][][] arrInt4, java.lang.String[] arrStrings, java.lang.String[][][][] arrStrings4, byps.test.api.cons.AllTypesZ[][] arrAll, final BAsyncResult<Boolean> asyncResult) ;
	
	
}
