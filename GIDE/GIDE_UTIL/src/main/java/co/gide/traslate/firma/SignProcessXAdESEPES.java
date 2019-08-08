package co.gide.traslate.firma;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.transforms.Transforms;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xades4j.XAdES4jException;
import xades4j.production.DataObjectReference;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesEpesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.properties.DataObjectDesc;
import xades4j.properties.DataObjectTransform;
import xades4j.properties.IdentifierType;
import xades4j.providers.BasicSignatureOptionsProvider;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.SignaturePolicyInfoProvider;
import xades4j.providers.SigningCertChainException;
import xades4j.providers.SigningKeyException;
import xades4j.utils.XadesProfileResolutionException;
import xades4j.verification.UnexpectedJCAException;




public class SignProcessXAdESEPES extends SignTypes{

	/**
	 * 
	 * @throws Exception
	 */
	public SignProcessXAdESEPES() throws Exception {
		super();
		this.logger = LogFactory.getLog(SignProcessXAdESEPES.class);
	}
	
	public SignProcessXAdESEPES(Log externalLogger) throws Exception {
		super();
		this.logger = externalLogger;
	}

	/**
	 * 
	 */
	private Log logger;

	/**
	 * 
	 */
	protected DocToSignResponseType processSign(
			File keyStore,
			String passwordKeyStoreEncode, 
			String certAlias,
			String passwordCertEncode,
			List<X509CRL> crls,
			String urlTSA,
			InputStream factura,
			ValidateCertTypes validateCert,
			String outPath,
			PolicyType policy
			)
	{
		logger.info("SignProcessXAdESEPES.processSign--->");
		OutputStream os = null;

		DocToSignResponseType docToSignResponseType = new DocToSignResponseType();
		docToSignResponseType.setStatus(ReturnCodes.ST_KO);
		try{

			DecodePasswordProvider decodePasswordProviderKeyStore =null;
			DecodePasswordProvider decodePasswordProviderCert = null;
			try{

				decodePasswordProviderKeyStore=new DecodePasswordProvider(passwordKeyStoreEncode);
				decodePasswordProviderCert=new DecodePasswordProvider(passwordCertEncode);

			}catch(Exception e)
			{				
				logger.error("Error", e);
				docToSignResponseType.setStatus(ReturnCodes.MK_ERROR_DECODE_PASSWORD_EXCEPTION);
				throw new Exception(e);
			}


			// Read the signing certificate and key from a PKCS#12 file			
			KeyingDataProvider keyingProviderMy=null;
			try {
				keyingProviderMy = new FileSystemKeyStoreKeyingDataProviderImpl(
						"pkcs12",
						keyStore,
						new FirstCertificateSelector(),
						decodePasswordProviderKeyStore,
						decodePasswordProviderCert,
						true,
						certAlias);
			} catch (KeyStoreException e2) {
				logger.error("Error", e2);
				docToSignResponseType.setStatus(ReturnCodes.MK_EXCEPTION);
				throw new Exception(e2);
			}

			X509Certificate signerCert;
			try {
				signerCert = keyingProviderMy.getSigningCertificateChain().get(0);
			} catch (SigningCertChainException e1) {
				logger.error("Error", e1);
				docToSignResponseType.setStatus(ReturnCodes.MK_EXCEPTION);
				throw new Exception(e1);
			} catch (UnexpectedJCAException e1) {
				logger.error("Error", e1);
				docToSignResponseType.setStatus(ReturnCodes.MK_EXCEPTION);
				throw new Exception(e1);
			}catch (Exception e1) {
				logger.error("Error", e1);
				docToSignResponseType.setStatus(ReturnCodes.MK_EXCEPTION);
				throw new Exception(e1);
			}


                        
			CertificateInfoType certificateInfoType= new CertificateInfoType();
			certificateInfoType.setCertificateIssuer(signerCert.getIssuerDN().getName());
			certificateInfoType.setCertificateOwner(signerCert.getSubjectDN().getName());
			certificateInfoType.setCertificateSerialNumber(signerCert.getSerialNumber().toString());

                        
			GregorianCalendar gce=new GregorianCalendar();
			gce.setTime(signerCert.getNotAfter());
			GregorianCalendar gcs=new GregorianCalendar();
			gcs.setTime(signerCert.getNotBefore());
                        

			try {
				certificateInfoType.setCertificateValidityEndDate( DatatypeFactory.newInstance().newXMLGregorianCalendar(gce));
				certificateInfoType.setCertificateValidityStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcs));
			} catch (DatatypeConfigurationException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_ERROR_PARSING_CERTIFICATE_VALIDITY_DATE);
				throw new Exception(e);
			}		

			java.util.Date today= new java.util.Date();

			if(!(signerCert.getNotAfter().after(today) && signerCert.getNotBefore().before(today)))
			{
				StringBuffer buffer= new StringBuffer("El certificado solo es valido desde ");
				buffer.append(signerCert.getNotBefore()).append(" hasta ").append(signerCert.getNotAfter()).append(signerCert.getNotAfter()).append(" y la fecha actual ").append(today).append(" no se encuentra entre ellas.");
				logger.error(buffer);
				docToSignResponseType.setStatus(ReturnCodes.ST_EXPIRED_CERTIFICATE);
				throw new Exception("Certificado caducado");
			}

			if(validateCert!=null)
			{
				List<CertificateInfoType> certificateInfoList=docToSignResponseType.getCertificateInfo();

				cacheValidationRequest(certificateInfoType,signerCert);
System.out.println("keyingProviderMy.getSigningCertificateChain().size()..... : "+keyingProviderMy.getSigningCertificateChain().size());
				String error=validateCert.certificateValidation(certificateInfoType,keyingProviderMy.getSigningCertificateChain().toArray(new X509Certificate[keyingProviderMy.getSigningCertificateChain().size()]), crls, logger);
				certificateInfoList.add(certificateInfoType);

				if(certificateInfoType.getReturnCode()!=ReturnCodes.CRL_CERTIFICATE_GOOD){
					docToSignResponseType.setStatus(certificateInfoType.getReturnCode());
					throw new Exception(error);
				}	
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			Document doc;
			try {
				doc = dbf.newDocumentBuilder().parse(factura);
				//				Element elem = doc.getDocumentElement();	        
				//				if(elem.hasAttributeNS(null, Constants._ATT_ID))
				//				{
				//					elem.setIdAttributeNS(null, Constants._ATT_ID, true);
				//				}

			} catch (SAXException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_SAX_EXCEPTION_PARSING_DOCUMENT);
				throw new Exception(e);
			} catch (IOException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_IO_EXCEPTION_PARSING_DOCUMENT);
				throw new Exception(e);
			} catch (ParserConfigurationException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_PARSER_CONFIGURATION_EXCEPTION_PARSING_DOCUMENT);
				throw new Exception(e);
			}



			NodeList nodeExts=doc.getElementsByTagNameNS("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2","UBLExtensions");

			Element exts;
			Element ext;
			Element cont;
			if(nodeExts==null || nodeExts.getLength()<1)
			{        	
				Element p= doc.getDocumentElement();

				exts=doc.createElementNS("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2","ext:UBLExtensions");
				ext=doc.createElement("ext:UBLExtension");     
				cont= doc.createElement("ext:ExtensionContent");        	
				ext.appendChild(cont);
				exts.appendChild(ext);
				p.insertBefore(exts, p.getFirstChild());        	
			}
			else
			{
				exts=(Element)nodeExts.item(0);        	
				String prefix=exts.getPrefix();
				ext=doc.createElement(prefix+":UBLExtension"); 
				cont= doc.createElement(prefix+":ExtensionContent");        	
				ext.appendChild(cont);
				exts.appendChild(ext);        	        	
			}

			Element elemToSign = cont;

			SignaturePolicyInfoProvider policyInfoProvider =null;
			try{
				policyInfoProvider = new SignaturePolicyInfoProviderImpl(policy.getPolicyBytes(),policy.getIdentifier(),IdentifierType.valueOf(policy.getIdentifierType().name()));
				if(policyInfoProvider.getSignaturePolicy()==null)
				{
					throw new Exception("Error construyendo el objeto policy");
				}
			}catch(Exception e)
			{
				docToSignResponseType.setStatus(ReturnCodes.POLICY_BUILD_EXCEPTION);
				throw new Exception(e);
			}



			XadesEpesSigningProfile xadesEpesSigningProfile = new XadesEpesSigningProfile(keyingProviderMy,policyInfoProvider);

			xadesEpesSigningProfile.withAlgorithmsProvider(new AlgorithmsProviderImpl());
			
			//
			xadesEpesSigningProfile.withBasicSignatureOptionsProvider(new BasicSignatureOptionsProvider() {
				public boolean signSigningCertificate() {
					return true;
				}
				public boolean includeSigningCertificate() {
					return true;
				}
				public boolean includePublicKey() {
					return false;
				}
			});
			
			//fin prueba 17 dic
			
			

			XadesSigner signer;
			try {
				signer = xadesEpesSigningProfile.newSigner();
			} catch (XadesProfileResolutionException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_SIGNATURE_EXCEPTION_SIGNING);
				throw new Exception(e);
			}




			DataObjectDesc obj1 = new DataObjectReference("")
			.withTransform(new DataObjectTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE));

			try {
                           signer.sign(new SignedDataObjects(obj1), elemToSign);
			}catch( SigningKeyException e){
                           
				docToSignResponseType.setStatus(ReturnCodes.MK_EXCEPTION);
                                return null;

			} catch (XAdES4jException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_SIGNATURE_EXCEPTION_SIGNING);
				return null;
			}

			//Se crea el fichero de salida con la factura firmada
			logger.info("Se crea la factura con la firma integrada");

			try {
				if(outPath!=null)
					os = new FileOutputStream(outPath);
				else
					os=new ByteArrayOutputStream();
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer trans;
				trans = tf.newTransformer();
				trans.transform(new DOMSource(doc), new StreamResult(os));

			} catch (FileNotFoundException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_FILE_NOT_FOUND_EXCEPTION_CREATING_FILE);
				throw new Exception(e);
			} catch (TransformerConfigurationException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_TRANSFORMER_CONFIGURATION_EXCEPTION_CREATING_FILE);
				throw new Exception(e);
			} catch (TransformerException e) {
				docToSignResponseType.setStatus(ReturnCodes.ST_TRANSFORMER_EXCEPTION_CREATING_FILE);
				throw new Exception(e);
			}

			if(outPath==null)
			{
				docToSignResponseType.setDocument(DatatypeConverter.printBase64Binary(((ByteArrayOutputStream)os).toByteArray()).getBytes());
			}	
			docToSignResponseType.setStatus(ReturnCodes.ST_OK);

			logger.info("<---SignProcessXAdESBES.processSign");
		}	
		catch (Exception e) {
			logger.error("Error. ReturnCode: " + docToSignResponseType.getStatus());
			logger.error("Error", e);
			docToSignResponseType.setErrorReason(e.toString());
		}
		catch (Throwable e) {
			docToSignResponseType.setStatus(ReturnCodes.ST_THROWABLE);
			logger.error("Error. ReturnCode: " + ReturnCodes.ST_THROWABLE);
			logger.error("Error", e);
			docToSignResponseType.setErrorReason(e.toString());
		}
		finally{
			IOUtils.closeQuietly(factura);
			IOUtils.closeQuietly(os);
		}
		return docToSignResponseType;

	}

}
