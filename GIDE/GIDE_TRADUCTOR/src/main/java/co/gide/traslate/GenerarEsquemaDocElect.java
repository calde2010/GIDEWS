package co.gide.traslate;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import co.gov.dian.contratos.facturaelectronica.v1.CreditNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.DebitNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;
import co.gov.dian.contratos.facturaelectronica.v1.ObjectFactory;
import co.gide.traslate.complementos.negocio.ComponenteConstantes.EnumTipoDocumento;
import co.gide.traslate.complementos.negocio.MyNamespacePrefixMapper;

public class GenerarEsquemaDocElect implements Serializable {

	/**
	 * Esta clase genera el esquema limpio del xml segun sea factura
	 * electronica, Nota Debito o Nota Credito en forma generica
	 */
	private static final long serialVersionUID = 1L;
	public static final String ENCODING_UTF_8 = "UTF-8";

	private  InvoiceType objInvoiceType;
	private  CreditNoteType objCreditNote;
	private  DebitNoteType objDebitNote;
	private String nombreDocumento;
	private String ruta;
	private  int tipoDocumento;

	//SE LE APLICO LA PROPIEDAD PUBLIC 
	public GenerarEsquemaDocElect(InvoiceType objInvoiceType, String nomDocu, String ruta, int tipoDocu ) {
       this.tipoDocumento=tipoDocu;
		this.nombreDocumento = nomDocu;
		this.ruta = ruta;
		this.objInvoiceType = objInvoiceType;	

		
	}

	
	GenerarEsquemaDocElect(CreditNoteType objCreditNote, String nomDocu, String ruta, int tipoDocu) {
		
		this.tipoDocumento=tipoDocu;
		this.nombreDocumento = nomDocu;
		this.ruta = ruta;
		this.objCreditNote = objCreditNote;


	}


	GenerarEsquemaDocElect(DebitNoteType objDebitNote, String nomDocu, String ruta, int tipoDocu) {
		this.tipoDocumento=tipoDocu;
		this.nombreDocumento = nomDocu;
		this.ruta = ruta;
		this.objDebitNote = objDebitNote;
	
	}


	public  Boolean crearDocumentoElectronico() throws JAXBException{
		// Metodo para crear un ndocumento electroocnico generico

		JAXBContext jaxbContext = null;
		Marshaller marshaller = null;

		if (tipoDocumento==(1)) {// Factura electronica
			try {
				jaxbContext = JAXBContext.newInstance(InvoiceType.class);
				marshaller = jaxbContext.createMarshaller();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else if (tipoDocumento==(2)) {// Nota Debito
			try {
				jaxbContext = JAXBContext.newInstance(DebitNoteType.class);
				marshaller = jaxbContext.createMarshaller();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

		} else if (tipoDocumento==(3)) {// Nota Credito
			try {
				jaxbContext = JAXBContext.newInstance(CreditNoteType.class);
				marshaller = jaxbContext.createMarshaller();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

		try {
			marshaller.setProperty(Marshaller.JAXB_ENCODING, ENCODING_UTF_8);
		} catch (PropertyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
					"http:/www.dian.gov.co/contratos/facturaelectronica/v1 ../xsd/DIAN_UBL.xsd urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2 ../../ubl2/common/UnqualifiedDataTypeSchemaModule-2.0.xsd urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2 ../../ubl2/common/UBL-QualifiedDatatypes-2.0.xsd");
		} catch (PropertyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// LOGGER.info("indicamos que queremos formateada nuestra salida
		// (con enters y tabs)");
		try {
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (PropertyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// LOGGER.info("indicamos los prefijos a utilizar");

		// se describe que tipo de documento electronico es (1 factura, 2
		// nota debito, 3 nota credito ) en la calse EnumTipoDocumento

		if (tipoDocumento==(1)) {// Factura electronica

			try {
				marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper",new MyNamespacePrefixMapper(EnumTipoDocumento.INVOICE));
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		} else if (tipoDocumento==(2)) {// Nota Debito
			try {
				marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper",
						new MyNamespacePrefixMapper(EnumTipoDocumento.DEBITNOTE));
			} catch (PropertyException e) {
				e.printStackTrace();
			}

		} else if (tipoDocumento==(3)) {// Nota Credito
			try {
				marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper",
						new MyNamespacePrefixMapper(EnumTipoDocumento.CREDITNOTE));
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}

		File directorio = new File(ruta);
		File fichero = new File(ruta.trim()+"/"+nombreDocumento.trim());
	
			directorio.mkdirs();
			
			
			if (directorio.isDirectory()) {
			
				
				try {
					fichero.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		// icamos creación de "+ EnumTipoDocumento.INVOICE.getDescripcion());

		ObjectFactory factory = new ObjectFactory();

		if (tipoDocumento==(1)) {// Factura electronica

			JAXBElement<InvoiceType> element = factory.createInvoice(objInvoiceType);

				marshaller.marshal(element, fichero);
	

		} else if (tipoDocumento==(2)) {// Nota Debito

			JAXBElement<DebitNoteType> element = factory.createDebitNote(objDebitNote);
			try {
				marshaller.marshal(element, fichero);
			} catch (JAXBException e) {

				e.printStackTrace();
			}

		} else if (tipoDocumento==(3)) {// Nota Credito

			JAXBElement<CreditNoteType> element = factory.createCreditNote(objCreditNote);
			try {
				marshaller.marshal(element, fichero);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// LOGGER.info("Archivo XML Serializado");
		return Boolean.TRUE;

	}

}
