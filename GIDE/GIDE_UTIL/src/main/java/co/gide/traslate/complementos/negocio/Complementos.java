package co.gide.traslate.complementos.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Complementos implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 2583897961472435404L;
	private String secretKey = "acuseDeRecibo";

	public synchronized void crearZip(String archivoOrigen, String archivoDestino, String nombreDentroDelArchivo)
			throws FileNotFoundException, IOException {
		File infile = new File(archivoOrigen);
		File outfile = new File(archivoDestino);

		FileInputStream fis = new FileInputStream(infile);
		FileOutputStream fos = new FileOutputStream(outfile);
		ZipOutputStream zos = new ZipOutputStream(fos);

		byte[] buffer = new byte[1024];
		ZipEntry entry = new ZipEntry(nombreDentroDelArchivo);
		precalc(entry, fis.getChannel());
		zos.putNextEntry(entry);
		for (int bytesRead; (bytesRead = fis.read(buffer)) >= 0;) {
			zos.write(buffer, 0, bytesRead);
		}
		zos.closeEntry();

		FileInputStream fin = new FileInputStream(outfile);
		ZipInputStream zis = new ZipInputStream(fin);
		ZipEntry entry2 = zis.getNextEntry();
		entry2.getSize();
		entry2.getCompressedSize();
		entry2.getCrc();
		zis.closeEntry();

	}

	private static void precalc(ZipEntry entry, FileChannel fch) throws IOException {
		long uncompressed = fch.size();
		int method = entry.getMethod();
		CRC32 crc = new CRC32();
		Deflater def;
		byte[] drain;
		if (method != ZipEntry.STORED) {
			def = new Deflater(Deflater.DEFAULT_COMPRESSION, true);
			drain = new byte[1024];
		} else {
			def = null;
			drain = null;
		}
		ByteBuffer buf = ByteBuffer.allocate((int) Math.min(uncompressed, 4096));
		for (int bytesRead; (bytesRead = fch.read(buf)) != -1; buf.clear()) {
			crc.update(buf.array(), buf.arrayOffset(), bytesRead);
			if (def != null) {
				def.setInput(buf.array(), buf.arrayOffset(), bytesRead);
				while (!def.needsInput()) {
					def.deflate(drain, 0, drain.length);
				}
			}
		}
		entry.setSize(uncompressed);
		if (def != null) {
			def.finish();
			while (!def.finished()) {
				def.deflate(drain, 0, drain.length);
			}
			entry.setCompressedSize(def.getBytesWritten());
		}
		entry.setCrc(crc.getValue());
		fch.position(0);
	}

	public synchronized String retornarNitCompleto(String nit) {

		String newNit = nit;
		for (int i = nit.length(); i < 10; i++) {
			newNit = "0" + newNit;
		}
		return newNit;
	}

	public synchronized String retornarConsecutivoCompleto(String consecutivo) {

		String newConsecutivo = consecutivo;
		for (int i = consecutivo.length(); i < 10; i++) {
			newConsecutivo = "0" + newConsecutivo;
		}
		return newConsecutivo;
	}

	public synchronized static String completarDecimal(String cadena) {
		String vec[] = cadena.split(Pattern.quote("."));
		String complemento = "00";
		if (vec[1] != null && vec[1].length() == 0) {
			complemento = "00";
		} else if (vec[1] != null && vec[1].length() == 1) {
			complemento = vec[1] + "0";
		} else {
			complemento = vec[1];
		}
		return vec[0] + "." + complemento;
	}

	public synchronized static String competarDecimal_2(String cadena) {
		String vec[] = cadena.split(Pattern.quote("."));
		if (vec[0] != null && vec[0].length() == 0) {
			cadena = "0" + cadena;
		}
		return cadena;
	}

	public synchronized String Encriptar(String texto) {

		String base64EncryptedString = "";

		try {

			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] plainTextBytes = texto.getBytes("utf-8");
			byte[] buf = cipher.doFinal(plainTextBytes);
			byte[] base64Bytes = Base64.encodeBase64(buf);
			base64EncryptedString = new String(base64Bytes);

		} catch (Exception ex) {
			System.out.println("");
		}
		return base64EncryptedString;
	}

	public synchronized String Desencriptar(String textoEncriptado) throws Exception {

		String base64EncryptedString = "";

		try {
			byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");

			Cipher decipher = Cipher.getInstance("DESede");
			decipher.init(Cipher.DECRYPT_MODE, key);

			byte[] plainText = decipher.doFinal(message);

			base64EncryptedString = new String(plainText, "UTF-8");

		} catch (Exception ex) {
			System.out.println("" + ex);
		}
		return base64EncryptedString;
	}

}
