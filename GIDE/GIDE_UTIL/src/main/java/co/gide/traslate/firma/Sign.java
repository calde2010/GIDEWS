package co.gide.traslate.firma;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.X509CRL;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.gide.traslate.firma.CertificateInfoType;
import co.gide.traslate.firma.DocToSignPathRequestType;
import co.gide.traslate.firma.DocToSignPathResponseType;
import co.gide.traslate.firma.DocToSignRequestType;
import co.gide.traslate.firma.DocToSignResponseType;
import co.gide.traslate.firma.ImplFromName.ImplClass;
import co.gide.traslate.firma.ValidateCertCacheType;
import co.gide.traslate.firma.ValidateCertType;


public class Sign {

	private Log logger;
	
	public Sign()
	{
		logger = LogFactory.getLog(Sign.class);
	}
	
	public Sign(Log externalLogger)
	{
		this.logger = externalLogger;
	}

	public DocToSignResponseType processSign(
			DocToSignRequestType docToSignRequestType) {


		DocToSignResponseType docToSignResponseType=null;

		InputStream is=null;
		if(!validateRequest(docToSignRequestType))
		{
			docToSignResponseType=new DocToSignResponseType();
			docToSignResponseType.setStatus(ReturnCodes.VALIDATE_REQUEST_EXCEPTION);
			System.out.println("Error: Peticion mal construida ReturnCode: " + ReturnCodes.VALIDATE_REQUEST_EXCEPTION);
			docToSignResponseType.setErrorReason("Error: Peticion mal construida");
			return docToSignResponseType;
		}


		try{
			is = new ByteArrayInputStream(DatatypeConverter.parseBase64Binary(new String(docToSignRequestType.getDocument())));
		}catch(Throwable e)
		{
			docToSignResponseType=new DocToSignResponseType();
			docToSignResponseType.setStatus(ReturnCodes.ILLEGAL_DOCUMENT_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.ILLEGAL_DOCUMENT_EXCEPTION);
			System.out.println(e);
			docToSignResponseType.setErrorReason(e.toString());
			return docToSignResponseType;
		}



		ValidateCertTypes validateCertTypes=null;		
		List<X509CRL> crls=null;
		SignTypes signTypes=null;

		List <ValidateCertCacheType> listValidateCertCacheType=null;


		try {
			String classSignName=ImplClass.valueOf("SIGNATURE"+docToSignRequestType.getSignatureType()).getClassName();
			if(docToSignRequestType.getValidateCertType()!=null)
			{
				String classCertName=ImplClass.valueOf(docToSignRequestType.getValidateCertType().getType().name()).getClassName();
				validateCertTypes=(ValidateCertTypes) Class.forName(classCertName).newInstance();
				crls=docToSignRequestType.getValidateCertType().getCrls();
				listValidateCertCacheType=docToSignRequestType.getValidateCertType().getValidateCertCache();
			}
			signTypes=(SignTypes) Class.forName(classSignName).newInstance();
			
			if(docToSignRequestType.getProxy()!=null && docToSignRequestType.getPort()!=null && !docToSignRequestType.getProxy().equals("") && !docToSignRequestType.getPort().equals(""))
			{
				logger.info("Se sale mediante proxy: " + docToSignRequestType.getProxy() + ":" + docToSignRequestType.getPort());
				System.setProperty("http.proxyHost", docToSignRequestType.getProxy());
				System.setProperty("http.proxyPort", docToSignRequestType.getPort());
			}

		} catch (ClassNotFoundException e) {

			docToSignResponseType=new DocToSignResponseType();
			docToSignResponseType.setStatus(ReturnCodes.CLASS_NOT_FOUND_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.CLASS_NOT_FOUND_EXCEPTION);
			System.out.println(e);
			docToSignResponseType.setErrorReason(e.toString());
			return docToSignResponseType;
		} catch (InstantiationException e) {
			docToSignResponseType=new DocToSignResponseType();
			docToSignResponseType.setStatus(ReturnCodes.INSTANTIATION_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.INSTANTIATION_EXCEPTION);
			System.out.println(e);
			docToSignResponseType.setErrorReason(e.toString());
			return docToSignResponseType;
		} catch (IllegalAccessException e) {
			docToSignResponseType=new DocToSignResponseType();
			docToSignResponseType.setStatus(ReturnCodes.ILLEGAL_ACCESS_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.ILLEGAL_ACCESS_EXCEPTION);
			System.out.println(e);
			docToSignResponseType.setErrorReason(e.toString());
			return docToSignResponseType;
		}


		signTypes.setListValidateCertCacheType(listValidateCertCacheType);
		docToSignResponseType =signTypes.processSign(docToSignRequestType.getKeystore(),
				docToSignRequestType.getKeystorePassword(),
				docToSignRequestType.getAlias(),
				docToSignRequestType.getPassword(),
				crls,
				docToSignRequestType.getUrlTSA(),
				is,
				validateCertTypes,null, docToSignRequestType.getPolicy());

		return docToSignResponseType;

	}


	private boolean validateRequest(DocToSignRequestType docToSignRequestType) {
		if(docToSignRequestType.getAlias()==null)
		{
			return false;
		}
		if(docToSignRequestType.getDocument()==null)
		{
			return false;
		}
		if(docToSignRequestType.getPassword()==null)
		{
			return false;
		}

		if(docToSignRequestType.getKeystorePassword()==null)
		{
			return false;
		}
		if(docToSignRequestType.getKeystore()==null)
		{
			return false;
		}

		if(docToSignRequestType.getValidateCertType()!=null)
		{
			ValidateCertType validateCertType=docToSignRequestType.getValidateCertType();

			if(validateCertType.getType()==null)
			{
				return false;
			}

			if(validateCertType.getCrls()==null || validateCertType.getCrls().size()==0)
			{
				return false;
			}
		}

		if(docToSignRequestType.getSignatureType()==null)
		{
			return false;
		}

		return true;
	}


	public DocToSignPathResponseType processSign(
			DocToSignPathRequestType docToSignPathRequestType) {


		InputStream is=null;
		DocToSignPathResponseType docToSignPathResponseType=null;

		if(!validateRequest(docToSignPathRequestType))
		{
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.VALIDATE_REQUEST_EXCEPTION);
			System.out.println("Error: Peticion mal construida ReturnCode: " + ReturnCodes.VALIDATE_REQUEST_EXCEPTION);
			docToSignPathResponseType.setErrorReason("Error: Peticion mal construida");
			return docToSignPathResponseType;
		}


		//ZipInputStream zis = new ZipInputStream(new FileInputStream("fichero.zip"));



		try {
			is = new FileInputStream(docToSignPathRequestType.getDocumentPath());
		} catch (FileNotFoundException e) {
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.ST_FILE_NOT_FOUND_EXCEPTION_OPENING_FILE);
			System.out.println("Error. ReturnCode: " + ReturnCodes.ST_FILE_NOT_FOUND_EXCEPTION_OPENING_FILE);
			System.out.println( e);
			docToSignPathResponseType.setErrorReason(e.toString());
			return docToSignPathResponseType;
		}catch (SecurityException e) {
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.ST_OPEN_FILE_EXCEPTION_NOT_PERMISSIONS);
			System.out.println("Error. ReturnCode: " + ReturnCodes.ST_OPEN_FILE_EXCEPTION_NOT_PERMISSIONS);
			System.out.println(e);
			docToSignPathResponseType.setErrorReason(e.toString());
			return docToSignPathResponseType;
		}



		ValidateCertTypes validateCertTypes=null;
		List<X509CRL> crls=null;
		SignTypes signTypes=null;

		List <ValidateCertCacheType> listValidateCertCacheType=null;


		try {
			String classSignName=ImplClass.valueOf("SIGNATURE"+docToSignPathRequestType.getSignatureType()).getClassName();
			if(docToSignPathRequestType.getValidateCertType()!=null)
			{
				String classCertName=ImplClass.valueOf(docToSignPathRequestType.getValidateCertType().getType().name()).getClassName();
				validateCertTypes=(ValidateCertTypes) Class.forName(classCertName).newInstance();
				crls=docToSignPathRequestType.getValidateCertType().getCrls();
				listValidateCertCacheType=docToSignPathRequestType.getValidateCertType().getValidateCertCache();
			}
			Class signerClass = Class.forName(classSignName);
			//signTypes=(SignTypes) Class.forName(classSignName).newInstance();
			Class[] argTypes = {Log.class};
			Constructor constructor = signerClass.getDeclaredConstructor(argTypes);
			Object[] arguments = {this.logger};
			signTypes= (SignTypes) constructor.newInstance(arguments);
			
			if(docToSignPathRequestType.getProxy()!=null && docToSignPathRequestType.getPort()!=null && !docToSignPathRequestType.getProxy().equals("") && !docToSignPathRequestType.getPort().equals(""))
			{
				logger.info("Se sale mediante proxy: " + docToSignPathRequestType.getProxy() + ":" + docToSignPathRequestType.getPort());
				System.setProperty("http.proxyHost", docToSignPathRequestType.getProxy());
				System.setProperty("http.proxyPort", docToSignPathRequestType.getPort());
			}

		}
		catch(InvocationTargetException ite)
		{
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.CONSTRUCTOR_NOT_FOUND_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.CONSTRUCTOR_NOT_FOUND_EXCEPTION);
			System.out.println(ite);
			docToSignPathResponseType.setErrorReason(ite.toString());
			IOUtils.closeQuietly(is);
			return docToSignPathResponseType;
		}
		catch(NoSuchMethodException nsme)
		{
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.CONSTRUCTOR_NOT_FOUND_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.CONSTRUCTOR_NOT_FOUND_EXCEPTION);
			System.out.println(nsme);
			docToSignPathResponseType.setErrorReason(nsme.toString());
			IOUtils.closeQuietly(is);
			return docToSignPathResponseType;			
		}
		catch (ClassNotFoundException e) {

			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.CLASS_NOT_FOUND_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.CLASS_NOT_FOUND_EXCEPTION);
			System.out.println(e);
			docToSignPathResponseType.setErrorReason(e.toString());
			IOUtils.closeQuietly(is);
			return docToSignPathResponseType;
		} catch (InstantiationException e) {
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.INSTANTIATION_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.CLASS_NOT_FOUND_EXCEPTION);
			System.out.println(e);
			docToSignPathResponseType.setErrorReason(e.toString());
			IOUtils.closeQuietly(is);
			return docToSignPathResponseType;
		} catch (IllegalAccessException e) {
			docToSignPathResponseType=new DocToSignPathResponseType();
			docToSignPathResponseType.setStatus(ReturnCodes.ILLEGAL_ACCESS_EXCEPTION);
			System.out.println("Error. ReturnCode: " + ReturnCodes.CLASS_NOT_FOUND_EXCEPTION);
			System.out.println(e);
			docToSignPathResponseType.setErrorReason(e.toString());
			IOUtils.closeQuietly(is);
			return docToSignPathResponseType;
		}


		signTypes.setListValidateCertCacheType(listValidateCertCacheType);
		DocToSignResponseType docToSignResponseType=signTypes.processSign(docToSignPathRequestType.getKeystore(),
				docToSignPathRequestType.getKeystorePassword(),
				docToSignPathRequestType.getAlias(),
				docToSignPathRequestType.getPassword(),
				crls,
				docToSignPathRequestType.getUrlTSA(),
				is,
				validateCertTypes,docToSignPathRequestType.getDocumentOutPath(), docToSignPathRequestType.getPolicy());

		docToSignPathResponseType=new DocToSignPathResponseType();
		docToSignPathResponseType.setStatus(docToSignResponseType.getStatus() + " "+ docToSignResponseType.getErrorReason());


		List<CertificateInfoType> certificateInfoList=docToSignPathResponseType.getCertificateInfo();
		certificateInfoList=docToSignResponseType.getCertificateInfo();

		return docToSignPathResponseType;

	}


	private boolean validateRequest(
			DocToSignPathRequestType docToSignPathRequestType) {


		if(docToSignPathRequestType.getAlias()==null)
		{
			return false;
		}
		if(docToSignPathRequestType.getDocumentOutPath()==null)
		{
			return false;
		}
		if(docToSignPathRequestType.getPassword()==null)
		{
			return false;
		}
		if(docToSignPathRequestType.getDocumentPath()==null)
		{
			return false;
		}
		if(docToSignPathRequestType.getKeystorePassword()==null)
		{
			return false;
		}
		if(docToSignPathRequestType.getKeystore()==null)
		{
			return false;
		}

		if(docToSignPathRequestType.getValidateCertType()!=null)
		{
			ValidateCertType validateCertType=docToSignPathRequestType.getValidateCertType();

			if(validateCertType.getType()==null)
			{
				return false;
			}

			if(validateCertType.getCrls()==null || validateCertType.getCrls().size()==0)
			{
				return false;
			}
		}

		if(docToSignPathRequestType.getSignatureType()==null)
		{
			return false;
		}

		return true;
	}

}
