package co.test.clientes;

//import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

	private String userNameHeader, passwordHeader;

	public HeaderHandler(String userNameHeader, String passwordHeader) {
		this.userNameHeader = userNameHeader;
		this.passwordHeader = passwordHeader;
	}

	public boolean handleMessage(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc.get("javax.xml.ws.handler.message.outbound");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
		Calendar c1 = Calendar.getInstance();
		String USER_CREATE = sdf.format(c1.getTime());
		String USER_NONCE = "001";

		if (outboundProperty.booleanValue()) {
			// SOAPMessage message = smc.getMessage();
			try {
				SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
				envelope.setAttribute("xmlns:rep",
						"http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura");
				envelope.removeAttribute("xmlns:S");
				envelope.setPrefix("soapenv");

				SOAPHeader header = null;
				if (header == null) {
					if (envelope.getHeader() != null) {
						envelope.getHeader().detachNode();
					}
					header = envelope.addHeader();
				}

				header.setPrefix("soapenv");
				header.removeAttribute("soapenv");
				SOAPElement security = header.addChildElement("Security", "wsse",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
				security.setAttribute("mustUnderstand", "1");

				SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");

				SOAPElement username = usernameToken.addChildElement("Username", "wsse");
				username.addTextNode(this.userNameHeader);
				System.out.println("this.userNameHeader: " + this.userNameHeader);

				SOAPElement password = usernameToken.addChildElement("Password", "wsse");
				System.out.println("this.passwordHeade): " + this.passwordHeader);
				password.addTextNode(sha256Resumen(this.passwordHeader));
				System.out.println("sha256Resumen(this.passwordHeader): " + sha256Resumen(this.passwordHeader));

				SOAPElement nonce = usernameToken.addChildElement("Nonce", "wsse");
				nonce.setAttribute("EncodingType",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
				// nonce.addTextNode(Base64.encode(("001" + USER_CREATE +
				// "*Cptc_Fact").getBytes()).toString());
				SOAPElement created = usernameToken.addChildElement("Created", "wsse");
				created.addTextNode(getXMLGregorianCalendar(USER_CREATE).toString().concat("Z"));

				SOAPBody soapBody = envelope.getBody();
				soapBody.setPrefix("soapenv");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.setProperty("java.net.useSystemProxies", "true");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return outboundProperty.booleanValue();
	}

	public Set<QName> getHeaders() {
		QName securityHeader = new QName(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security",
				"wsse");
		HashSet headers = new HashSet();
		headers.add(securityHeader);

		return headers;
	}

	private String sha256Resumen(String encriptar) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(encriptar.getBytes());
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; ++i) {
				String hex = Integer.toHexString(0xFF & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static XMLGregorianCalendar getXMLGregorianCalendarNow() throws DatatypeConfigurationException {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
		XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		return now;
	}

	public static XMLGregorianCalendar getXMLGregorianCalendar(String date) throws Exception {
		XMLGregorianCalendar xmlCalender = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss");
			Date dob = simpleDateFormat.parse(date);
			GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
			gc.setTime(dob);
			xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc.get(1), gc.get(2) + 1, gc.get(5),
					gc.get(11), gc.get(12), gc.get(13), gc.get(14), -2147483648);
		} catch (DatatypeConfigurationException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return xmlCalender;
	}

	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	public void close(MessageContext context) {
	}
}
