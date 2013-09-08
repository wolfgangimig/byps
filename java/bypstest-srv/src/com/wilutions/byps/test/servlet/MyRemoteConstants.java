package com.wilutions.byps.test.servlet;

import java.util.Arrays;

import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.cons.AllTypesC;
import com.wilutions.byps.test.api.cons.AllTypesZ;
import com.wilutions.byps.test.api.cons.HebrewC;
import com.wilutions.byps.test.api.cons.HebrewZ;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteConstants;

public class MyRemoteConstants extends BSkeleton_RemoteConstants {
	
	private <T> void compare(T lhs, T rhs) throws BException {
		if (!lhs.equals(rhs)) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
	}
	
	private void compareArray(Object[] lhs, Object[] rhs) throws BException {
		if (!Arrays.equals(lhs, rhs)) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
	}

	private void compareArray(int[] lhs, int[] rhs) throws BException {
		if (!Arrays.equals(lhs, rhs)) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
	}

	private void compareArray4(int[][][][] lhs, int[][][][] rhs) throws BException {
		if (lhs.length != rhs.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
		for (int i3 = 0; i3 < lhs.length; i3++) {
			int[][][] lhs2 = lhs[i3];
			int[][][] rhs2 = rhs[i3];
			if (lhs2.length != rhs2.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
			for (int i2 = 0; i2 < lhs.length; i2++) {
				int[][] lhs1 = lhs2[i2];
				int[][] rhs1 = rhs2[i2];
				if (lhs1.length != rhs1.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
				for (int i1 = 0; i1 < lhs.length; i1++) {
					int[] lhs0 = lhs1[i1];
					int[] rhs0 = rhs1[i1];
					if (!Arrays.equals(lhs0, rhs0)) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
				}
			}
		}
	}

	private void compareArray4(String[][][][] lhs, String[][][][] rhs) throws BException {
		if (lhs.length != rhs.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
		for (int i3 = 0; i3 < lhs.length; i3++) {
			String[][][] lhs2 = lhs[i3];
			String[][][] rhs2 = rhs[i3];
			if (lhs2.length != rhs2.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
			for (int i2 = 0; i2 < lhs.length; i2++) {
				String[][] lhs1 = lhs2[i2];
				String[][] rhs1 = rhs2[i2];
				if (lhs1.length != rhs1.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
				for (int i1 = 0; i1 < lhs.length; i1++) {
					String[] lhs0 = lhs1[i1];
					String[] rhs0 = rhs1[i1];
					if (!Arrays.equals(lhs0, rhs0)) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
				}
			}
		}
	}

	private void compareArray2(Object[][] lhs, Object[][] rhs) throws BException {
		if (lhs.length != rhs.length) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
		for (int i1 = 0; i1 < lhs.length; i1++) {
			Object[] lhs0 = lhs[i1];
			Object[] rhs0 = rhs[i1];
			if (!Arrays.equals(lhs0, rhs0)) throw new BException(BExceptionC.INTERNAL, "Wrong constant");
		}
	}

	@Override
	public void compare_HebrewC(HebrewZ ALEPH, HebrewZ BETH) throws RemoteException {
		compare(HebrewC.ALEPH, ALEPH);
		compare(HebrewC.BETH, BETH);
	}

	@Override
	public boolean compare_AllTypesC(boolean bool1s, boolean bool2s,
			char char1s, String stringNull, char char2s, short short1s,
			int int1s, long long1s, float float1s, double double1s,
			String string1s, AllTypesZ ALL, int[] arrInt, int[][][][] arrInt4,
			String[] arrStrings, String[][][][] arrStrings4,
			AllTypesZ[][] arrAll) throws RemoteException {
		

		compare(AllTypesC.bool1s, bool1s);
		compare(AllTypesC.bool2s, bool2s);
		compare(AllTypesC.char1s, char1s);
		compare("", stringNull); // AllTypesC.stringNull=null -> "" (null Strings are equal to empty Strings)
		compare(AllTypesC.char2s, char2s);
		compare(AllTypesC.short1s, short1s);
		compare(AllTypesC.int1s, int1s);
		compare(AllTypesC.long1s, long1s);
		compare(AllTypesC.float1s, float1s);
		compare(AllTypesC.double1s, double1s);
		compare(AllTypesC.string1s, string1s);
		compare(AllTypesC.ALL, ALL);
		compareArray(AllTypesC.arrInt, arrInt);
		compareArray4(AllTypesC.arrInt4, arrInt4);
		compareArray(AllTypesC.arrStrings, arrStrings);
		compareArray4(AllTypesC.arrStrings4, arrStrings4);
		compareArray2(AllTypesC.arrALL, arrAll);

		return true;
	}

}
