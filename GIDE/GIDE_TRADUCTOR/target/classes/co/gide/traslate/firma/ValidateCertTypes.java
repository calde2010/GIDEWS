package co.gide.traslate.firma;

import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.util.List;

import org.apache.commons.logging.Log;




public abstract class  ValidateCertTypes
{	
	
	public abstract String certificateValidation(CertificateInfoType certificateValidationInfoType,
			Certificate[] certs,
			List<X509CRL> crls,
			Log logger); 

}

