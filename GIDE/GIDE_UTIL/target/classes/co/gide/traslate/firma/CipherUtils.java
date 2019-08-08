package co.gide.traslate.firma;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class CipherUtils
{

//	static Log log = LogFactory.getLog(CipherUtils.class);

	private static byte[] key = {
		0x49 ,0x4E ,0x44 ,0x52 ,0x41 ,0x50 ,0x41 ,0x53 ,0x53 ,0x43 ,0x49 ,0x50 ,0x48 ,0x45 ,0x52 ,0x31		
	};//"INDRAPASSCIPHER1";

	public static String encrypt(String strToEncrypt)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			final String encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
			return encryptedString;
		}
		catch (Exception e)
		{
//			log.error("Error while encrypting", e);
		}
		return null;

	}

	public static String decrypt(String strToDecrypt)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
			return decryptedString;
		}
		catch (Exception e)
		{
//			log.error("Error while decrypting", e);

		}
		return null;
	}

}