package co.gide.tx.ftp;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class exec {

	public static void main(String[] args) {
		// face_f08300411180980032000.xml

		TrasferenciaFTP tf = new TrasferenciaFTP();
		try {
			tf.tranferirViaFTP("localhost", "gide", "Admin123*",
					"C:/home/facturador/gide/830041118/facturasFirmadas/face_f08300411180980032000.xml",
					"C:/home/facturador/gide/830041118/facturasSinFirmar/face_f08300411180980032000.xml",
					"face_f08300411180980032001.xml", "830041118");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
