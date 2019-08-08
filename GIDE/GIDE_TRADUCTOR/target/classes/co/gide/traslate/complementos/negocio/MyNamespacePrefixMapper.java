package co.gide.traslate.complementos.negocio;

import java.util.HashMap;
import java.util.Map;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import co.gide.traslate.complementos.negocio.ComponenteConstantes.EnumTipoDocumento;


//la propiedad "com.sun.xml.bind.namespacePrefixMapper" debe ser una instancia del tipo com.sun.xml.bind.marshaller.NamespacePrefixMapper, 
//no com.was.facturador.general.utilidades.MyNamespacePrefixMapper

public class MyNamespacePrefixMapper extends NamespacePrefixMapper{

	private Map<String, String> namespaceMap = new HashMap<>();

	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion,
			boolean requirePrefix) {
		return namespaceMap.get(namespaceUri);
	}
	
    public MyNamespacePrefixMapper(EnumTipoDocumento tipoDocumento){
    	namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", "cbc");
    	
    	switch (tipoDocumento) {
		case INVOICE:
			namespaceMap.put("http://www.dian.gov.co/contratos/facturaelectronica/v1", "fe");
			break;
		case DEBITNOTE:
			namespaceMap.put("http://www.dian.gov.co/contratos/facturaelectronica/v1", "nd");
			break;
		case CREDITNOTE:
			namespaceMap.put("http://www.dian.gov.co/contratos/facturaelectronica/v1", "nc");
			break;
		default:
			break;
		}
    	namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2", "ext");
    	namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", "cac");
    	namespaceMap.put("http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures", "sts");
    	namespaceMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
    	namespaceMap.put("urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2", "udt");
    }
 
}
