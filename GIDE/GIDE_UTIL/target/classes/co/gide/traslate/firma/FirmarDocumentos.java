package co.gide.traslate.firma;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.FileUtils;
import org.jfree.util.Log;

import com.growupit.validate.CodigoErrores;


public class FirmarDocumentos implements Serializable{
	
	/**
	 * Sereial Version
	 */
	private static final long serialVersionUID = -6926730351231619541L;

	public   static Boolean firmarDigitalmenteArchivo(String nombreFactura, 
			String keyStore, String passwordKeyStoreEncode, String certAlias, 
			String passwordCertEncoded, String signPolicy, String policyFilePath, 
			String rutaFacturaSinFirmar, String rutaFacturaFirmada){
		
		Log.info("	Se esta ejecutando el metodo, firmarDigitalmenteArchivo () ");
		
		
		File directorio = new File(rutaFacturaFirmada.trim());
		File fichero = new File(rutaFacturaFirmada.trim()+"/"+nombreFactura.trim());
	
			directorio.mkdirs();
			if(directorio.isDirectory()){
				try {
					fichero.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		//setUpBeforeClass(PathCRL);
		
		Log.info("Se esta firmando la factura digitalemnete");
		
		Sign sign = new Sign();
		DocToSignPathRequestType docToSignPathRequestType=new DocToSignPathRequestType();
		docToSignPathRequestType.setAlias(certAlias);
		docToSignPathRequestType.setDocumentOutPath(rutaFacturaFirmada+nombreFactura);
		docToSignPathRequestType.setDocumentPath(rutaFacturaSinFirmar+nombreFactura);
		docToSignPathRequestType.setKeystorePassword( CipherUtils.encrypt(passwordKeyStoreEncode)  );
		docToSignPathRequestType.setKeystore(new File(keyStore));
		docToSignPathRequestType.setPassword( CipherUtils.encrypt(passwordCertEncoded) );
		docToSignPathRequestType.setSignatureType(SignatureType.XADESEPES);

		PolicyType policy = new PolicyType();
		policy.setIdentifier(signPolicy);
		policy.setIdentifierType(IdentifierType.URI);
	
			try {
				policy.setPolicyBytes(FileUtils.readFileToByteArray(new File(policyFilePath)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

		docToSignPathRequestType.setPolicy(policy);

		DocToSignPathResponseType docToSignPathResponseType =sign.processSign(docToSignPathRequestType);
                

		
		return Boolean.TRUE; 

	}	

}
