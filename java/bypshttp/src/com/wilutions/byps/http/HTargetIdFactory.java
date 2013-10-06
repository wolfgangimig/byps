package com.wilutions.byps.http;

import java.security.SecureRandom;
import java.util.Random;

import com.wilutions.byps.BTargetId;

public class HTargetIdFactory {
	
	public HTargetIdFactory(int serverId) {
		this.serverId = serverId;
	}

	BTargetId createTargetId() {
		
		long v1 = ((long)serverId << 32) | (getRandomLong() & 0xFFFFFFFFL);
		long v2 = getRandomLong();
		
		return new BTargetId(v1, v2);
	}

	public static int getServerIdFromTargetId(BTargetId targetId) {
		return (int)(targetId.v1 >> 32);
	}
	
	public int getServerId() {
		return serverId;
	}
	
	public boolean isSameServer(BTargetId t1, BTargetId t2) {
		int s1 = getServerIdFromTargetId(t1);
		int s2 = getServerIdFromTargetId(t2);
		return s1 == s2;
	}
	
	protected long getRandomLong() {
	   	// https://www.cigital.com/justice-league-blog/2009/08/14/proper-use-of-javas-securerandom/
		if (randBestBefore < System.currentTimeMillis()) {
			try {
				rand = new SecureRandom();
				rand.nextBytes(new byte[1]);
			} catch (Throwable e) {
				throw new IllegalStateException(e);
			}
			randBestBefore = System.currentTimeMillis() + 601L * 1000L;
		}
		return rand.nextLong();
	}
	
	protected Random rand;
	protected long randBestBefore;
	private int serverId;
}
