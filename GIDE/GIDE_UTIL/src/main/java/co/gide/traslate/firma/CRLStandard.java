package co.gide.traslate.firma;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.apache.commons.logging.Log;



public class CRLStandard extends ValidateCertTypes {

	//private static Log logger = LogFactory.getLog(CRLStandard.class);	

	public String certificateValidation(CertificateInfoType certificateInfoType,
			Certificate[] certs, 
			List<X509CRL> crls,
			Log logger){

		logger.info("CRLStandard.CertificateValidation--->");
		try{

			if(certs==null || certs.length < 1){
				certificateInfoType.setReturnCode(ReturnCodes.CRL_NO_CERTIFICATION_AUTHORITY);
				return "Ruta de certificacion erronea";
			}
			else{

				if(certificateInfoType.getCertificateStatus()==null)
				{
					if(crls==null || crls.size()<1)
					{
						throw new Exception("No contiene ninguna lista de revocacion ligada a ese certificado");
					}
					boolean validation=false;
					for(X509CRL crl:crls)
					{						
						for(Certificate c:certs)
						{							 
							try{							
								crl.verify(c.getPublicKey());
							}catch(Exception e)
							{
								continue;
							}
							String error=validateCRL(certificateInfoType, certs, crl, logger);
							if(certificateInfoType.getCertificateStatus()==CertificateStatusType.GOOD)
							{
								validation=true;
							}
							else
							{
								return error;
							}
						}
					}
					if(validation==false)
						throw new Exception("No existe ninguna lista de revocación de la CA del certificado");
					else
						return null;
				}
				else
				{
					return logStatus(certificateInfoType, logger);
				}
			}

		} catch (Exception e) {
			logger.error("Error", e);
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_EXCEPTION);
			return e.toString();
		}

	}

	/**
	 * 
	 * @param rutaHost
	 * @param certificadoX509Emisor
	 * @param certificadoX509
	 * @return
	 * @throws DatatypeConfigurationException 
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	private String validateCRL(CertificateInfoType certificateInfoType,
			Certificate[] certs,X509CRL crl,
			Log logger
			) throws DatatypeConfigurationException //throws NoSuchAlgorithmException, IOException, InvalidKeyException, SignatureException 
			{

		if(crl==null)
		{
			logger.error("No existen listas de distribución incluidas en el certificado para validarlo");			
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_EXCEPTION);
			return "No existen listas de revocación para validar el certificado";
		}


		CertificateStatusType status=CertificateStatusType.GOOD;

		for(int j=0; j< certs.length;j++)
		{
			if(crl.isRevoked(certs[j]))
			{
				status=CertificateStatusType.REVOKED;
			}
		}

		GregorianCalendar gc= new GregorianCalendar();
		gc.setTime(new Date());		

		certificateInfoType.setDateValidation(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));

		return logCRLStatus(status,certificateInfoType, logger);
			}





	/**
	 * 
	 * @param responseStatus
	 * @return
	 * @throws Exception
	 */
	private String logCRLStatus(CertificateStatusType responseStatus,CertificateInfoType certificateInfoType, Log logger){

		switch(responseStatus){
		case GOOD:
			certificateInfoType.setCertificateStatus(CertificateStatusType.GOOD);
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_GOOD);
			return null;
		case REVOKED:
			logger.error("Error certificate revoked");
			certificateInfoType.setCertificateStatus(CertificateStatusType.REVOKED);
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_REVOKED);
			return "Error certificate revoked";
		case UNKNOWN:
			logger.error("Error certificate unknown");
			certificateInfoType.setCertificateStatus(CertificateStatusType.UNKNOWN);
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_UNKNOWN);
			return "Error certificate unknown";
		default:
			logger.error("Error devuelto en la validacion de certificados no esperado: " + responseStatus);
			certificateInfoType.setReturnCode(ReturnCodes.CRL_INTERNAL_ERROR);
			return "Error devuelto en la validacion de certificados no esperado: " + responseStatus; 

		}
	}


	/**
	 * 
	 * @param responseStatus
	 * @return
	 * @throws Exception
	 */
	private String logStatus(CertificateInfoType certificateInfoType, Log logger){

		switch(certificateInfoType.getCertificateStatus()){
		case GOOD:
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_GOOD);
			return null;
		case REVOKED:
			logger.error("Error certificate revoked");
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_REVOKED);
			return "Error certificate revoked";
		case UNKNOWN:
			logger.error("Error certificate unknown");
			certificateInfoType.setReturnCode(ReturnCodes.CRL_CERTIFICATE_UNKNOWN);
			return "Error certificate unknown";
		default:
			logger.error("Error devuelto en la validacion de certificados no esperado: " + certificateInfoType.getCertificateStatus().name());
			certificateInfoType.setReturnCode(ReturnCodes.CRL_INTERNAL_ERROR);
			return "Error devuelto en la validacion de certificados no esperado: " + certificateInfoType.getCertificateStatus().name(); 

		}
	}

}
