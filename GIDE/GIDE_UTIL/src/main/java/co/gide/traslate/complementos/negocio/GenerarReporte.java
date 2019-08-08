package co.gide.traslate.complementos.negocio;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;

import org.jfree.util.Log;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.growupit.validate.CodigoErrores;






public class  GenerarReporte {

	public static String nombreDocumento;
	public static String carpetaDocumento;
	public static void main(String arg[]) throws JRException{
		nombreDocumento = "fe_PRUE980000009";
		carpetaDocumento ="800199436";
		//System.out.println(System.getProperty("user.dir")+"/src/main/resources/reportesfacturas/FacturaElectronica.jasper");
		GenerarReporte.generarPDF("/home/facturador/PruebasReportes/fe_PRUE980000000.xml","/home/facturador/PruebasReportes/fe_PRUE980000000.pdf","FECINECO");	
	}
	
	/**
	 * Generación de reportes de Factura electronica
	 * @throws ComponenteException 
	 */
	public static Boolean generarPDF(String xPathXML, String xPathPDF, String reporte)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		Document document = null;
		DocumentBuilder documentBuilder= null;

			 try {
				documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 try {
				document = documentBuilder.parse(JRLoader.getLocationInputStream(xPathXML)) ;
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//JRXmlUtils.parse(JRLoader.getLocationInputStream(xPathXML));
	
		
		params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
		params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
		params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
		params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
		params.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		
		try {
			JasperFillManager.fillReportToFile("/home/facturador/ReporteadorElectronico/"+reporte+".jasper",xPathPDF.replace(".pdf", ".jrprint"), params);
			
			
			JasperExportManager.exportReportToPdfFile(xPathPDF.replace(".pdf", ".jrprint"),xPathPDF);
		} catch (JRException e) {
			 e.printStackTrace();
		}
		File reporteTemp = new File (xPathPDF.replace(".pdf", ".jrprint"));
		reporteTemp.delete();
		
		return Boolean.TRUE;
	}
	
	
}

