package com.wilutions.byps.test.api.ver;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Example class with elements that belong to different versions.
 */
public class Evolve implements Serializable {

	private static final long serialVersionUID = -1316080799619480380L;

	// First version, no "since" tag.
	
	public boolean bool1;
	public byte byte1;
	public char char1;
	public short short1;
	public int int1;
	public long long1;
	public float float1;
	public double double1;
	
	public boolean[] bools1;
	public byte[] bytes1;
	public char[] chars1;
	public short[] shorts1;
	public int[] ints1;
	public long[] longs1;
	public float[] floats1;
	public double[] doubles1;
	
	public String str1;
	public Object obj1;
	public Evolve2 evo1;
	
	public List<Integer> list1;
	public Set<Integer> set1;
	public Map<Integer, Integer> map1;
	
	// ---------------------------------------------------------------------
	// Second version, since=2
	
	/**
	 * @since 2
	 */
	public boolean bool2;
	/**
	 * @since 2
	 */
	public byte byte2;
	/**
	 * @since 2
	 */
	public char char2;
	/**
	 * @since 2
	 */
	public short short2;
	/**
	 * @since 2
	 */
	public int int2;
	/**
	 * @since 2
	 */
	public long long2;
	/**
	 * @since 2
	 */
	public float float2;
	/**
	 * @since 2
	 */
	public double double2;
	
	/**
	 * @since 2
	 */
	public boolean[] bools2;
	/**
	 * @since 2
	 */
	public byte[] bytes2;
	/**
	 * @since 2
	 */
	public char[] chars2;
	/**
	 * @since 2
	 */
	public short[] shorts2;
	/**
	 * @since 2
	 */
	public int[] ints2;
	/**
	 * @since 2
	 */
	public long[] longs2;
	/**
	 * @since 2
	 */
	public float[] floats2;
	/**
	 * @since 2
	 */
	public double[] doubles2;
	
	/**
	 * @since 2
	 */
	public String str2;
	/**
	 * @since 2
	 */
	public Object obj2;
	/**
	 * @since 2
	 */
	public Evolve2 evo2;
	/**
	 * @since 2
	 */
	public List<Integer> list2;
	/**
	 * @since 2
	 */
	public Set<Integer> set2;
	/**
	 * @since 2
	 */
	public Map<Integer, Integer> map2;


	// ---------------------------------------------------------------------
	// Third version, since=3
	
	/**
	 * @since 3
	 */
	public boolean bool3;
	/**
	 * @since 3
	 */
	public byte byte3;
	/**
	 * @since 3
	 */
	public char char3;
	/**
	 * @since 3
	 */
	public short short3;
	/**
	 * @since 3
	 */
	public int int3;
	/**
	 * @since 3
	 */
	public long long3;
	/**
	 * @since 3
	 */
	public float float3;
	/**
	 * @since 3
	 */
	public double double3;
	
	/**
	 * @since 3
	 */
	public boolean[] bools3;
	/**
	 * @since 3
	 */
	public byte[] bytes3;
	/**
	 * @since 3
	 */
	public char[] chars3;
	/**
	 * @since 3
	 */
	public short[] shorts3;
	/**
	 * @since 3
	 */
	public int[] ints3;
	/**
	 * @since 3
	 */
	public long[] longs3;
	/**
	 * @since 3
	 */
	public float[] floats3;
	/**
	 * @since 3
	 */
	public double[] doubles3;
	
	/**
	 * @since 3
	 */
	public String str3;
	/**
	 * @since 3
	 */
	public Object obj3;
	/**
	 * @since 3
	 */
	public Evolve2 evo3;
	
	/**
	 * @since 3
	 */
	public List<Integer> list3;
	/**
	 * @since 3
	 */
	public Set<Integer> set3;
	/**
	 * @since 3
	 */
	public Map<Integer, Integer> map3;
}	
