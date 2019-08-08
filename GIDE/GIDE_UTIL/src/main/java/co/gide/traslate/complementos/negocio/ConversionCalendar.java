package co.gide.traslate.complementos.negocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConversionCalendar {

	public ConversionCalendar() {
		// TODO Auto-generated constructor stub
	}
	
	// TODO Agregar zona horaria
	public static String dateYYYYMMDD(Calendar objCalendar){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(objCalendar.getTime());	
	}
	
	// TODO Agregar zona horaria (hora)
	public static String dateHHMMSS(Calendar objCalendar){
		SimpleDateFormat format = new SimpleDateFormat("HH:MM:ss");
		return format.format(objCalendar.getTime());
		
	}

	/*
	public static String dateYYYYMMDD(Date objDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(objDate);
		
	}
	
	public static String dateHHMMSS(Date objDate){
		SimpleDateFormat format = new SimpleDateFormat("HH:MM:ss");
		return format.format(objDate);
		
	}
	*/
	

}
