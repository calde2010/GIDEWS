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
public class ConsultaResolucionesDianXml{
//	
//	
//	public ResolucionesFacturacion consultaResolucionesDian(String nitEmisor,String nitProveedor,String ideSoftware,String userNameHeader, 
//                                  String passwordHeader) throws Exception{
//        ObjectFactory factory=new ObjectFactory();
//        ResolucionesFacturacion resultado=new ResolucionesFacturacion();
//        try{
//            String urlAmbiente = "https://facturaelectronica.dian.gov.co/habilitacion/B2BIntegrationEngine/FacturaElectronica/consultaDocumentos.wsdl";
//            URL url=new URL(urlAmbiente);
//                                                                                                                        
//            ResolucionFacturacionPortNameService portNameService=new ResolucionFacturacionPortNameService(url,new QName("http://www.dian.gov.co/servicios/facturaelectronica/ConsultaResolucionFacturacion","resolucionFacturacionPortNameService"));
//
//            HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(userNameHeader, passwordHeader);
//
//            portNameService.setHandlerResolver(handlerResolver);
//
//            ResolucionFacturacionPortName resolucionesPortName=portNameService.getResolucionFacturacionPortNameSoap11();
//
//            BindingProvider bindingProvider=(BindingProvider)resolucionesPortName;
//
//            bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address",urlAmbiente);
//
//            ConsultaResoluciones envioConsulta=factory.createConsultaResoluciones();
//            envioConsulta.setNITObligadoFacturarElectronicamente(nitEmisor);
//            envioConsulta.setNITProveedorTecnologico(nitProveedor);
//            envioConsulta.setIdentificadorSoftware(ideSoftware);
//            factory.createConsultaResolucionesFacturacionPeticion(envioConsulta);
//
//            resultado=resolucionesPortName.consultaResolucionesFacturacion(envioConsulta);          
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