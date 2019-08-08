package co.gide.tx.ftp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class TrasferenciaFTP {
	private FTPClient ftpClient;

	public void tranferirViaFTP(String ip, String User, String Pass, String RutaArchivofirmados, String RutaArchivoSinfirmar,
			String NombreArchivo, String nit) throws SocketException, UnknownHostException, IOException {
		try {
			ftpClient = new FTPClient();
			ftpClient.connect(InetAddress.getByName(ip));
			ftpClient.login(User, Pass);

			// Verificar conexión con el servidor.

			int reply = ftpClient.getReplyCode();

			System.out.println("Respuesta recibida de conexión FTP:" + reply);

			if (FTPReply.isPositiveCompletion(reply)) {

				System.out.println("Conectado Satisfactoriamente");

				

				

			} else {
				System.out.println("Imposible conectarse al servidor");
			}

			trasnferirArchivoFTP(NombreArchivo, RutaArchivofirmados, "/facturasFirmadas" ,nit);
			trasnferirArchivoFTP(NombreArchivo, RutaArchivoSinfirmar, "/facturasSinFirmar",nit);
			
			try {
				ftpClient.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Cerrar sesión
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Desconectarse del servidor

			// Verificar si se cambia de direcotirio de trabajo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Algo malo sucedió");
			e.printStackTrace();
		}
	}

	public boolean trasnferirArchivoFTP(String NombreArchivo, String RutaArchivo, String path, String nit) {

		try {
			String ruta = "/"+nit+""+path;
			ftpClient.changeWorkingDirectory(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Cambiar directorio de trabajo
		System.out.println("Se cambió satisfactoriamente el directorio");

		// Activar que se envie cualquier tipo de archivo

		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedInputStream buffIn = null;
		/** Ruta del archivo **/
		try {
			buffIn = new BufferedInputStream(new FileInputStream(RutaArchivo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ftpClient.enterLocalPassiveMode();
		try {
			ftpClient.storeFile(NombreArchivo, buffIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Ruta completa de alojamiento en el FTP

		try {
			buffIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Cerrar envio de arcivos al FTP

		return true;

	}
}
