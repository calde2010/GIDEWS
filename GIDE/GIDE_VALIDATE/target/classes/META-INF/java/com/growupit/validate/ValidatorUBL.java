package com.growupit.validate;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import org.apache.log4j.Logger;

import com.growupit.gideesquema.ArchivoElectronicoTipo;
import com.growupit.gideesquema.TipoCodigo;
import com.growupit.gideesquema.TipoContacto;
import com.growupit.gideesquema.TipoIdentificador;
import com.growupit.gideesquema.TipoProveedor;
import com.growupit.gideesquema.TipoTercero;
import com.growupit.gideesquema.TipoTexto;

public class ValidatorUBL {

	private static final Logger LOG = Logger.getLogger(ValidatorUBL.class);

	public static void main(String args[]) {

		TipoIdentificador t = null;

		try {

			System.out.println(getElemtRequeridos(t, TipoIdentificador.class));

		} catch (ValidationException e) {
			e.printStackTrace();
		}

	}

	public class ValidationException extends Exception {
		public ValidationException(String message, Throwable cause) {
			super(message, cause);
		}

		public ValidationException(String message) {
			super(message);
		}
	}

	public static <T> StringBuilder getElemtRequeridos(T target, Class<T> targetClass) throws ValidationException {

		StringBuilder errors = new StringBuilder();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			XmlElement annotation = field.getAnnotation(XmlElement.class);
			if (annotation != null && annotation.required()) {
				try {
					field.setAccessible(true);
					if (field.get(target) == null) {
						if (errors.length() != 0) {
							errors.append(" ");
						}
						String message = String.format(
								"%s: Elemento requerido para el documento electronico :  '%s'  es nullo . \n",
								targetClass.getSimpleName(), field.getName());

						LOG.error(message);
						errors.append(message);
					}

				} catch (IllegalArgumentException e) {
					LOG.error(field.getName(), e);
				} catch (IllegalAccessException e) {
					LOG.error(field.getName(), e);
				}
			}
		}
		return errors;
	}

	public boolean validateDate(String date) {

		try {
			String test = null;
			if (!date.equals(test)) {

				if (!date.equals("")) {

					return true;
				}else {
					return false;
				}

			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
		

	}

	public boolean validateDate(Calendar fecha) {
		if (fecha != null) {

			return true;
		} else {
			return false;
		}
	}

	public boolean validateDate(BigDecimal medidaDuracion) {

		if (medidaDuracion.compareTo(BigDecimal.ZERO) == 0) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * public boolean validateDate(byte[] value) { return false; }
	 */

	public boolean validateDateHora(Calendar horaEmision) {
		if (horaEmision != null) {

			return true;
		} else {
			return false;
		}
	}

	public synchronized Date cargarDate(Calendar cal) {
		Date fecha = null;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(cal.getTime());
		String formatted = format1.format(cal.getTime());
		try {
			fecha = format1.parse(formatted);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}

	public synchronized String cargarFechaTransaccion(Calendar cal) {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		System.out.println(cal.getTime());

		String fecha = format1.format(cal.getTime());
		System.out.println(fecha);

		return fecha;

	}

	public static Calendar cargarCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

}
