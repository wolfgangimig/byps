package com.wilutions.byps;

import java.nio.ByteBuffer;

public class BTargetId {
	
	public final long v1;
	public final long v2;
	
	public BTargetId(long v1, long v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public BTargetId() {
		v1 = v2 = 0;
	}
	
	public boolean isZero() {
		return v1 == 0 && v2 == 0;
	}
	
	public void write(ByteBuffer buf) {
		buf.putLong(v1);
		buf.putLong(v2);
	}
	
	public static BTargetId read(ByteBuffer buf) {
		long v1 = buf.getLong();
		long v2 = buf.getLong();
		return new BTargetId(v1,v2);
	}
	
	private static void longToHex(StringBuilder builder, long v) {
		String h = Long.toHexString(v);
		final String _0 = "0000000000000000";
		builder.append(_0.substring(0, 16-h.length())).append(h);
	}
	
	private static long hexToLong(String s, int offs) {
		// Long.parseLong(s, 16) throws NumberFormatException, for s = Long.toString(negative value);
		long v = 0;
		for (int i = 0; i < 16; i+=2) {
			int n = Integer.parseInt(s.substring(offs + i, offs + i + 2), 16);
			v = (v << 8) + (n & 0xFF);
		}
		return v;
	}
	
	@Override
	public String toString() {
		if (isZero()) return "";
		StringBuilder builder = new StringBuilder();
		longToHex(builder, v1);
		longToHex(builder, v2);
		return builder.toString();
	}
	
	public static BTargetId parseString(String s) {
		if (s.length() < 32) return new BTargetId();
		long v1 = hexToLong(s, 0);
		long v2 = hexToLong(s, 16);
		return new BTargetId(v1,v2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (v1 ^ (v1 >>> 32));
		result = prime * result + (int) (v2 ^ (v2 >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BTargetId other = (BTargetId) obj;
		if (v1 != other.v1)
			return false;
		if (v2 != other.v2)
			return false;
		return true;
	}
}
