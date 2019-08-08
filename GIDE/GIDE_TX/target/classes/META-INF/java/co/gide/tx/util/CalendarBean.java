
package co.gide.tx.util;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * @author RA�L ANTONIO PAJARO ORTIZ
 */



public class CalendarBean implements Serializable{

	
	/** Serial Version */
	private static final long serialVersionUID = 4081890465226565780L;
	private static Date fecha;
	private static Time hora;
	private static java.sql.Timestamp fechaHora;
 
    public CalendarBean()  {
    }
    
	public static Date getFecha() {
		java.util.Date utilDate = new java.util.Date();
		long lnMilisegundos = utilDate.getTime();
		fecha = new java.sql.Date(lnMilisegundos);
		return fecha;
	}

	public static Time getHora() {
		Calendar calendario = Calendar.getInstance();
		int horas, minutos, segundos;
		horas = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		hora = Time.valueOf(horas + ":" + minutos + ":" + segundos);
		return hora;
	}

	public static java.sql.Timestamp getFechaHora() {
		java.util.Date utilDate = new java.util.Date();
		long lnMilisegundos = utilDate.getTime();
		fechaHora = new java.sql.Timestamp(lnMilisegundos);
		return fechaHora;
	}
	
	public static java.util.Date getFechaUtilDate() {
		java.util.Date utilDate = new java.util.Date();
		long lnMilisegundos = utilDate.getTime();
		java.util.Date fechaHora = new java.sql.Date(lnMilisegundos);
		return fechaHora;
	}
	
	public static java.util.Date sumarDias(java.util.Date date,int days){
		return new Date(date.getTime()+days*1000*60*60*24);
	}
	
	public static double compararFecha(java.util.Date fechaActual, java.util.Date fechaExpiracion){
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    	String fechaInicioString = df.format(fechaExpiracion);
    	String fechaFinalString =  df.format(fechaActual);
    	long fechaExpiracionMs = 0;
        long fechaActualMs = 0;
        long diferencia = 0;
        double dias = 0;
        try {
        	fechaExpiracion = (java.util.Date) df.parse(fechaInicioString);
        	fechaActual = (java.util.Date) df.parse(fechaFinalString);
            fechaExpiracionMs = fechaExpiracion.getTime();
            fechaActualMs = fechaActual.getTime();
            diferencia = fechaExpiracionMs-fechaActualMs;
            dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        } catch (ParseException ex) {
        	System.out.println(ex);
        }
		return dias;
	}
	
	public static int getAnio() {
		Calendar calendario = Calendar.getInstance();
		return calendario.get(Calendar.YEAR);
	}
	
	public static int getMes() {
		Calendar calendario = Calendar.getInstance();
		return calendario.get(Calendar.MONTH);
	}

}
