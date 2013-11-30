package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.security.SecureRandom;
import java.util.Random;

import byps.BTargetId;

public class HTargetIdFactory {
	
	public HTargetIdFactory(int serverId) {
		this.serverId = serverId;
	}

	BTargetId createTargetId() {
		
		long v1 = getRandomLong();
		long v2 = getRandomLong();
		
		return new BTargetId(serverId, v1, v2);
	}

	public int getServerId() {
		return serverId;
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
