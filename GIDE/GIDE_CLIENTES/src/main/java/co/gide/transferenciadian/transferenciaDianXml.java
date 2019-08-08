package co.gide.transferenciadian;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
 
import co.test.clientes.HeaderHandlerResolver;

import javax.persistence.Entity;


public class transferenciaDianXml{
//	
//	
//	public synchronized  AcuseRecibo tranferirWsDian(String rutaXml,String fechaXml,String documentoObligado,
//                                  String numeroDocumento, String userNameHeader, 
//                                  String passwordHeader, String urlAmbiente) throws Exception{
//        ObjectFactory factory=new ObjectFactory();
//        AcuseRecibo resultado=new AcuseRecibo();
//        try{
//            
//            URL url=new URL(urlAmbiente);
//
//            FacturaElectronicaPortNameService portNameService=new FacturaElectronicaPortNameService(url,new QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura","facturaElectronicaPortNameService"));
//
//            HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(userNameHeader, passwordHeader);
//
//            portNameService.setHandlerResolver(handlerResolver);
//
//            FacturaElectronicaPortName facturaElectronicaPortName=portNameService.getFacturaElectronicaPortNameSoap11();
//
//            BindingProvider bindingProvider=(BindingProvider)facturaElectronicaPortName;
//
//            bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address",urlAmbiente);
//
//            EnvioFacturaElectronica envioFacturaElectronica=factory.createEnvioFacturaElectronica();
//
//            System.out.println("rutaXml: "+rutaXml);
//            DataSource fds=new FileDataSource(new File(rutaXml));
//
//            DataHandler dataHandler=new DataHandler(fds);
//
//            envioFacturaElectronica.setDocument(dataHandler);
//
//            envioFacturaElectronica.setNIT(documentoObligado);
//            envioFacturaElectronica.setIssueDate(getXMLGregorianCalendar(fechaXml));
//            envioFacturaElectronica.setInvoiceNumber(numeroDocumento);
//            factory.createEnvioFacturaElectronicaPeticion(envioFacturaElectronica);
//
//            resultado=facturaElectronicaPortName.envioFacturaElectronica(envioFacturaElectronica);          
//            
//        }
//        catch(Exception e){
//            throw new Exception("El error de trans xml es: "+e);
//        }
//
//        return resultado;
//    }
//
//    public static XMLGregorianCalendar getXMLGregorianCalendarNow() throws DatatypeConfigurationException{
//        GregorianCalendar gregorianCalendar=new GregorianCalendar();
//        DatatypeFactory datatypeFactory=DatatypeFactory.newInstance();
//        XMLGregorianCalendar now=datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
//        return now;
//    }
//
//    public static XMLGregorianCalendar getXMLGregorianCalendar(String date) throws Exception{
//        XMLGregorianCalendar xmlDate=null;
//
//        GregorianCalendar calender=new GregorianCalendar();
//        calender.setTime(stringToJavaDate(date));
//        try{
//            xmlDate=DatatypeFactory.newInstance().newXMLGregorianCalendar(calender.get(1),calender.get(2)+1,calender.get(5),calender.get(11),calender.get(12),calender.get(13),calender.get(14),0);
//        }
//        catch(DatatypeConfigurationException e){
//            throw new Exception("Error en XMLGregorianCalendar: "+e);
//        }
//
//        return xmlDate;
//    }
//
//    public static Date stringToJavaDate(String sDate) throws Exception{
//        Date date=null;
//        try{
//            date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDate);
//        }
//        catch(ParseException e){
//            throw new Exception("Error en stringToJavaDate: "+e);
//        }
//
//        return date;
//    }
}