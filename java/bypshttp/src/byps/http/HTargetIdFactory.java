package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BTargetId;
import byps.RemoteException;

public class HTargetIdFactory {
	
	public HTargetIdFactory(int serverId) {
		this.serverId = serverId;
		this.key = generateKey();
		this.targetId_signature = getRandomLong();
		byte[] iv = new byte[16];
		rand.nextBytes(iv);
		ivkey = new IvParameterSpec(iv);
	}
	
	private static SecretKey generateKey() {
    try {
      KeyGenerator kgen = KeyGenerator.getInstance("AES");
      kgen.init(128);
      return kgen.generateKey();
    } catch (NoSuchAlgorithmException e) {
    }
    return null;
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
	
	public boolean isEncrypted(BTargetId targetId) {
	  return targetId.getSignature() != 0;
	}
	
	public BTargetId encryptTargetId(BTargetId targetId, boolean encryptNotDecrypt) throws RemoteException {
	  
	  BTargetId ret = targetId;
	  final boolean encrypted = isEncrypted(targetId);
	  
	  if (encryptNotDecrypt ^ encrypted) {
	    
  	  ByteBuffer buf = ByteBuffer.allocate(32);
  	  
  	  if (encryptNotDecrypt) {
  	    targetId = new BTargetId(targetId, targetId_signature);
  	  }
  	  
  	  targetId.write(buf, BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID);
  	  
      try {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
        cipher.init(encryptNotDecrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, key, ivkey);
        byte[] bytes = cipher.doFinal(buf.array());
        
        ByteBuffer obuf = ByteBuffer.wrap(bytes);
        ret = BTargetId.read(obuf, BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID);
        
      } catch (Exception e) {
        throw new BException(BExceptionC.INTERNAL, "Failed to encrypt/decrypt targetId", e);
      }
      
      if (!encryptNotDecrypt) {
        if (ret.getSignature() != targetId_signature) {
          throw new BException(BExceptionC.INTERNAL, "Failed to decrypt targetId, might be a encrypted by other server.");
        }
        ret = new BTargetId(ret, 0);
      }
      
	  }
	  
    return ret;
	}

  protected final SecretKey key;
  private final IvParameterSpec ivkey;
	protected Random rand;
	protected long randBestBefore;
	private final int serverId;
	private final long targetId_signature;
}
