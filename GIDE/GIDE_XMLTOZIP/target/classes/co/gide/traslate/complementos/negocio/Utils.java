package co.gide.traslate.complementos.negocio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;



public abstract class Utils {

	public static final String SHA384 = "SHA-384";
	public static final String SHA1 = "SHA-1";
	public static final String SHA256 = "SHA-256";
	
	 public static final String getSHAValue(String source, String algorithm) throws Exception
	    {       
	       DigestOutputStream digestOutputStream = null;
	       ByteArrayInputStream inputstream = null;                 
	       
	       try 
	       {   
	    	    inputstream = new ByteArrayInputStream(source.getBytes());
	            ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
	            MessageDigest hash = MessageDigest.getInstance(algorithm);            
	            digestOutputStream = new DigestOutputStream(outputstream, hash);            
	            IOUtils.copy(inputstream, digestOutputStream);                 
	            return Hex.encodeHexString(digestOutputStream.getMessageDigest().digest());
	        }               
	        catch (SecurityException e)
	        {	        	                       
	            throw new Exception("Error inesperado de seguridad: ");         
	        }
	        catch (Exception e) 
	        {	                                 
	            throw new Exception("Error al calcular el valor hash de archivo: ");
	        }
	        finally 
	        {   
	            IOUtils.closeQuietly(inputstream);          
	            IOUtils.closeQuietly(digestOutputStream);
	        }
	    }
	 
}
