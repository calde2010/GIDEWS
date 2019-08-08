package co.gide.traslate.complementos.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Compresses a file or directory into a Zip archive. Users of the class supply
 * the name of the file or directory as an argument.
 */

public class ZiperUtility {


	public static void zipiar(String fileName, String nombreFichero)
			throws IOException {
		ZipOutputStream os = new ZipOutputStream(new FileOutputStream(
				fileName.replace(".xml", ".zip")));

		os.setLevel(Deflater.DEFAULT_COMPRESSION);
		os.setMethod(Deflater.DEFLATED);
		File infile = new File(fileName);

		FileInputStream fis = new FileInputStream(infile);

		ZipEntry entrada = new ZipEntry(nombreFichero + ".xml");
		entrada.setMethod(ZipEntry.STORED);
		precalc(entrada, fis.getChannel());
		os.putNextEntry(entrada);

		byte[] buffer = new byte[1024];
		int leido = 0;
		while (0 < (leido = fis.read(buffer))) {
			os.write(buffer, 0, leido);
		}
		fis.close();
		os.closeEntry();
		os.close();

	}

	private static void precalc(ZipEntry entry, FileChannel fch)
			throws IOException {
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
		ByteBuffer buf = ByteBuffer
				.allocate((int) Math.min(uncompressed, 4096));
		for (int bytesRead; (bytesRead = fch.read(buf)) != -1; buf.clear()) {
			crc.update(buf.array(), buf.arrayOffset(), bytesRead);
			if (def != null) {
				def.setInput(buf.array(), buf.arrayOffset(), bytesRead);
				while (!def.needsInput())
					def.deflate(drain, 0, drain.length);
			}
		}
		entry.setSize(uncompressed);
		if (def != null) {
			def.finish();
			while (!def.finished())
				def.deflate(drain, 0, drain.length);
			entry.setCompressedSize(def.getBytesWritten());
		}
		entry.setCrc(crc.getValue());
		fch.position(0);
	}

}
