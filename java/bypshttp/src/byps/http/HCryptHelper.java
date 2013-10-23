package byps.http;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HCryptHelper {

	public HCryptHelper() {
		internalGenerateKey();
	}

	private void internalGenerateKey() {

		KeyGenerator kgen = null;
		try {
			kgen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException ex) {
			throw new IllegalStateException(ex.toString());
		}

		if (!internalGenerateKeySize(kgen, 128)) {
			throw new IllegalStateException(
					"Cannot generate AES key with 128 bits.");
		}

	}

	private boolean internalGenerateKeySize(KeyGenerator kgen, int nBits) {

		boolean ret = false;
		kgen.init(nBits);

		// Generate the secret key specs.
		SecretKey skey = kgen.generateKey();
		byte[] rawKey = skey.getEncoded();
		m_skeySpec = new SecretKeySpec(rawKey, "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, m_skeySpec);
			ret = true;
		} catch (Exception e) {
			m_skeySpec = null;
		}

		return ret;
	}
	
	public Cipher getEncryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, m_skeySpec);
		return cipher;
	}

	public Cipher getDecryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, m_skeySpec);
		return cipher;
	}

//	public BTargetId encryptTargetId(BTargetId targetId) throws IllegalStateException {
//		String ret = "";
//		try {
//			Cipher cipher = Cipher.getInstance("AES");
//			cipher.init(Cipher.ENCRYPT_MODE, m_skeySpec);
//
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			OutputStream cos = new CipherOutputStream(bos, cipher);
//
//			targetId.
//			byte[] buf = plainText.getBytes("UTF-8");
//			cos.write(buf);
//
//			cos.flush();
//			cos.close();
//
//			ret = base64.encode(bos.toByteArray());
//		} catch (Exception ex) {
//			throw new IllegalStateException(ex.toString());
//		}
//		return "##AES##" + ret;
//	}
//
//	public void decryptTargetId(byte[] rtext) throws IllegalStateException {
//		String ret = "";
//
//		try {
//			Cipher cipher = Cipher.getInstance("AES");
//			cipher.init(Cipher.DECRYPT_MODE, m_skeySpec);
//
//			ByteArrayInputStream bis = new ByteArrayInputStream(rtext);
//			InputStream cis = new CipherInputStream(bis, cipher);
//
//			ByteArrayOutputStream bos = new ByteArrayOutputStream(rtext.length);
//			int len = -1;
//			byte[] buf = new byte[1000];
//			while ((len = cis.read(buf)) != -1) {
//				bos.write(buf, 0, len);
//			}
//
//			ret = new String(bos.toByteArray(), "UTF-8");
//
//		} catch (Exception ex) {
//			throw new IllegalStateException(ex.toString());
//		}
//
//	}

	/**
	 * Key data
	 */
	SecretKeySpec m_skeySpec;

}
