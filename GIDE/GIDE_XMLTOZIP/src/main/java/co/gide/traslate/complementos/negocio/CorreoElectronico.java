package co.gide.traslate.complementos.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class CorreoElectronico implements Serializable {

	private static final long serialVersionUID = 5991574283314832913L;

	public synchronized void enviarMensajeAdjuntos(String from, String password, String asunto, List<String> to,
			String mensaje, List<String> ruta) {
		try {
			// Propiedades de la conexi�n
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "mail.simba.co");
			// props.setProperty("mail.smtp.port", "465");//587
			props.setProperty("mail.smtp.user", from);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props);

			// Se compone la parte del texto
			MimeBodyPart texto = new MimeBodyPart();
			// texto.setText(mensaje);
			texto.setContent(mensaje, "text/html; charset=utf-8;");

			// Se compone el adjunto con el archivo
			List<MimeBodyPart> listAdjuntos = new ArrayList<MimeBodyPart>();
			for (int i = 0; i < ruta.size(); i++) {
				MimeBodyPart adjunto = new MimeBodyPart();
				adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta.get(i))));
				adjunto.setFileName(ruta.get(i));
				listAdjuntos.add(adjunto);
			}

			// Una MultiParte para agrupar texto y archivo.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			for (MimeBodyPart adj : listAdjuntos) {
				multiParte.addBodyPart(adj);
			}

			// Se compone el correo, dando to, from, subject y el
			// contenido.
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			for (int i = 0; i < to.size(); i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.get(i)));
			}

			message.addHeader("Disposition-Notification-To", from);
			message.setContent(multiParte, "text/html; charset=utf-8;");
			message.setSubject(asunto);

			// Se envia el correo.
			Transport t = session.getTransport("smtp");
			t.connect(from, password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();

		} catch (Exception ex) {
			System.out.println("Error SMTP: " + ex.getMessage());
		}
	}

}
