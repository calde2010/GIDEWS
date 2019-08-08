package co.gide.traslate.firma;

import java.io.File;
import java.io.InputStream;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import co.gide.traslate.firma.CertificateInfoType;
import co.gide.traslate.firma.DocToSignResponseType;
import co.gide.traslate.firma.PolicyType;
import co.gide.traslate.firma.ValidateCertCacheType;




public abstract class SignTypes {

	
	private List<ValidateCertCacheType >listValidateCertCacheType;
	
	

	protected abstract DocToSignResponseType processSign(
			File keyStore,
			String passwordKeyStore, 
			String certAlias,
			String passwordCertEncode,
			List<X509CRL> crls,
			String urlTSA,
			InputStream factura,
			ValidateCertTypes validateCert,
			String outPath,
			PolicyType policy) ;


	/**
	 * 
	 * @param proxyHost
	 * @param proxyPort
	 * @param proxyUser
	 * @param proxyPassword
	 * @throws SecurityException
	 */
	protected void setProxy(String proxyHost, String proxyPort)
	{
		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", proxyPort);
	}

	public List<ValidateCertCacheType> getListValidateCertCacheType() {
		return listValidateCertCacheType;
	}


	public void setListValidateCertCacheType(
			List<ValidateCertCacheType> listValidateCertCacheType) {
		this.listValidateCertCacheType = listValidateCertCacheType;
	}
	
	
	protected void cacheValidationRequest(CertificateInfoType certificateInfoType,X509Certificate certificate)
	{
		
		String serial=certificate.getSerialNumber().toString();
		String acdn=certificate.getIssuerDN().getName();
		if(this.getListValidateCertCacheType()==null)
			return;
		else
		{
			Iterator<ValidateCertCacheType> it=this.getListValidateCertCacheType().iterator();
			
			while(it.hasNext())
			{
				ValidateCertCacheType validateCertCacheType=it.next();
				
				if(serial.equals(validateCertCacheType.getCertificateSerialNumber()) && acdn.equals(validateCertCacheType.getCertificateIssuer()))
				{
					certificateInfoType.setCertificateStatus(validateCertCacheType.getCertificateStatus());
					return;
				}
			}
		}
		return;
	}
	
}
