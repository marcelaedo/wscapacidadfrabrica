/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cl.akzio.auth.central.obtenercapacidadfabrica.exception.ConfigurationException;
/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public class Utils implements Serializable{
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -6699524082108419896L;
	
	
	/**
	 * Devuelve la fecha actual en milisegundos.
	 * 
	 * @return Long
	 */
	public static Long getTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.getTimeInMillis();
	}
	/**
	 * <p>Formatea una fecha (Date) a String de acuerdo al patron informado.</p>
	 * <p>Patron por default: "yyyy-MM-dd HH:mm:ss"</p>
	 * 
	 * @param date Date
	 * @param pattern String
	 * @return String
	 */
	public static String formatFechaDate(Date date, String pattern) {
		String resultado = "";
		if(pattern == null){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		try{
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			resultado = format.format(date);
		}catch(Exception e){
			return null;
		}
		return resultado;
	}
	/**
	 * <p>Formatea una fecha (String) a String de acuerdo a los patrones de entrada y salida informados.</p>
	 * <p>Patron de entrada y salida por default: "yyyy-MM-dd HH:mm:ss"</p>
	 * 
	 * @param fecha String
	 * @param patternIn String
	 * @param patternOut String
	 * @return String
	 */
	public static String formatFechaString(String fecha, String patternIn,
			String patternOut) {
		Date date = new Date();
		if(patternIn == null){
			patternIn = "yyyy-MM-dd HH:mm:ss";
		}
		if(patternOut == null){
			patternOut = "yyyy-MM-dd HH:mm:ss";
		}
		try{
			SimpleDateFormat format = new SimpleDateFormat(patternIn);
			date = format.parse(fecha);
		}catch(Exception e){
			return null;
		}
		return formatFechaDate(date, patternOut);
	}
	/**
	 * <p>Realiza el paso de un Date (en milisegundos) a String de acuerdo al patron informado.</p>
	 * <p>Patron por default: "yyyy-MM-dd HH:mm:ss"</p>
	 * 
	 * @param fecha String
	 * @param pattern String
	 * @return Date
	 */
	public static String formatFechaLong(Long fecha, String pattern) {
		if(fecha == null){
			return null;
		}
		if(pattern == null){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		String resultado = "";
		Date date = new Date(fecha);
		try{
			SimpleDateFormat formato = new SimpleDateFormat(pattern);
			resultado = formato.format(date);
		}catch(Exception e){
			return null;
		}
		return resultado;
	}
	/**
	 * Valida si un String viene con contenido (distinto de null y distinto de vacio).
	 * 
	 * @param string String
	 * @return Boolean
	 */
	public static Boolean esStringValido(String string) {
		if(string != null && !"".equals(string.trim())){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	/**
	 * Valida si un String contiene un numero entero.
	 * 
	 * @param string String
	 * @return Boolean
	 */
	public static Boolean esEntero(String string) {
		if(esStringValido(string)){
			try{
				Integer.parseInt(string.trim());
				return Boolean.TRUE;
			}catch(Exception e){
				return Boolean.FALSE;
			}
		}else{
			return Boolean.FALSE;
		}
	}
	/**
	 * Valida si un String contiene un numero entero positivo.
	 * 
	 * @param string String
	 * @return Boolean
	 */
	public static Boolean esEnteroPositivo(String string) {
		if(esStringValido(string)){
			try{
				Integer numero = Integer.parseInt(string.trim());
				if(numero > 0){
					return Boolean.TRUE;
				}else{
					return Boolean.FALSE;
				}
			}catch(Exception e){
				return Boolean.FALSE;
			}
		}else{
			return Boolean.FALSE;
		}
	}
	/**
	 * Valida si un String contiene un numero Long.
	 * 
	 * @param string String
	 * @return Boolean
	 */
	public static Boolean esLong(String string) {
		if(esStringValido(string)){
			try{
				Long.parseLong(string.trim());
				return Boolean.TRUE;
			}catch(Exception e){
				return Boolean.FALSE;
			}
		}else{
			return Boolean.FALSE;
		}
	}
	/**
	 * Valida si un String contiene un numero Long positivo.
	 * 
	 * @param string String
	 * @return Boolean
	 */
	public static Boolean esLongPositivo(String string) {
		if(esStringValido(string)){
			try{
				Long numero = Long.parseLong(string.trim());
				if(numero > 0){
					return Boolean.TRUE;
				}else{
					return Boolean.FALSE;
				}
			}catch(Exception e){
				return Boolean.FALSE;
			}
		}else{
			return Boolean.FALSE;
		}
	}
	/**
	 * <p>Valida si una fecha (String) corresponde a una fecha, de acuerdo al patron informado.</p>
	 * <p>Patron por default: "yyyy-MM-dd HH:mm:ss"</p>
	 * 
	 * @param fecha String
	 * @param pattern String
	 * @return Boolean
	 */
	public static Boolean esFechaValida(String fecha, String pattern) {
		if(pattern == null){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		try{
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			format.setLenient(false);
			format.parse(fecha);
		}catch(Exception e){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	/**
	 * <p>Valida si una fecha (String) corresponde a una fecha, de acuerdo al patron  dd-MM-yyyy.</p>
	 * @param fecha String
	 * @return Boolean
	 */
	public static Boolean validaFormatoFechaddMMYYYY(String fecha){
		if(fecha.matches("^(?:3[01]|[12][0-9]|0?[1-9])([-.])(0?[1-9]|1[1-2])\\1\\d{4}$")){
			return true; 
		}
		else{
			return false;
		}
	}
	/**
	 * <p>Valida si un rut es valido, evaluando formato con puntos y/o guion.</p>
	 * <p>Ademas evalua el digito verificador.</p>
	 * 
	 * @param rut String
	 * @return Boolean
	 */
	public static Boolean validaRut(String rut) {
		if(rut == null){
			return Boolean.FALSE;
		}
		Boolean resultado = Boolean.FALSE;
		Pattern patron = Pattern.compile("^0*(\\d{1,3}(\\.?\\d{3})*)\\-?([\\dkK])$");

		String sDigVer;
		String sRutSinDigVer;
		Integer iDigVer;
		Integer iRutSinDigVer;
		Integer size;

		Matcher matcher = patron.matcher(rut);
		/* valida formato de rut */
		if(matcher.matches()){
			sRutSinDigVer = matcher.group(1).replace(".", "");
			sDigVer = matcher.group(3);
			if(("k".equalsIgnoreCase(sDigVer))){
				sDigVer = "10";
			}
			try{
				iDigVer = Integer.valueOf(sDigVer);
				iRutSinDigVer = Integer.valueOf(sRutSinDigVer);
				size = sRutSinDigVer.length();
			}catch(NumberFormatException e){
				return resultado;
			}
			/* valida digito verificador */
			Integer digito;
			int contador = 0;
			Integer array[] = new Integer[size];
			int j = 2;
			Integer RESET_VALUE = 8;
			for(int i = 0; i < size; i++){
				if(j == RESET_VALUE){
					j = 2;
				}
				array[i] = (iRutSinDigVer % 10);
				contador += (array[i] * j);
				iRutSinDigVer /= 10;
				j++;
			}
			digito = 11 - (contador % 11);
			if(digito.equals(Integer.valueOf(11))){
				digito = 0;
			}
			if(digito.equals(iDigVer)){
				resultado = Boolean.TRUE;
			}
		}

		return resultado;
	}
	/**
	 * Formatea un rut, devolviendo el rut con 9 digitos, sin puntos ni guion.
	 * 
	 * @param rut String
	 * @return String
	 */
	public static String formatRut(String rut) {
		String resultado = "";

		if(rut == null || "".equals(rut.trim())){
			return "";
		}
		rut = rut.replace(".", "").trim();
		resultado = rut;

		Pattern patron = Pattern
				.compile("^0*(\\d{1,3}(\\d{3})*)\\-?([\\dkK])$");
		Matcher matcher = patron.matcher(rut);
		if(matcher.matches()){
			resultado = matcher.group(1).concat(matcher.group(3));
			while(resultado.length() < 9){
				resultado = "0".concat(resultado);
			}
		}
		return resultado.toUpperCase();
	}
	/**
	 * Formatea un rut, devolviendo el rut con 9 digitos, sin puntos y con guion. <br />
	 * 
	 * @param rut String
	 * @return String
	 */
	public static String formatRutConGuion(String rut) {
		String resultado = "";

		if(rut == null || "".equals(rut.trim())){
			return "";
		}
		rut = rut.replace(".", "").trim();
		resultado = rut;

		Pattern patron = Pattern.compile("^0*(\\d{1,3}(\\d{3})*)\\-?([\\dkK])$");
		Matcher matcher = patron.matcher(rut);
		if(matcher.matches()){
			resultado = matcher.group(1).concat("-").concat(matcher.group(3));
			while(resultado.length() < 10){
				resultado = "0".concat(resultado);
			}
		}
		return resultado;
	}
	/**
	 * <p>Valida si el movil es valido.</p>
	 * <p>Evalua en formatos: 569XXXXXXXX, 9XXXXXXXX.</p>
	 * 
	 * @param movil String
	 * @return Boolean
	 */
	public static Boolean validaMovil(String movil) {
		if(movil == null){
			return Boolean.FALSE;
		}
		Boolean resultado = Boolean.FALSE;
		Pattern patron = Pattern.compile("^(56)?(\\d{9})$");

		Matcher matcher = patron.matcher(movil.trim());
		if(matcher.matches()){
			resultado = Boolean.TRUE;
		}
		return resultado;
	}
	/**
	 * Formatea un movil en formato 9 digitos.
	 * 
	 * @param movil String
	 * @return String
	 */
	public static String formatMovil(String movil) {
		if(movil == null){
			return null;
		}
		if(movil.length() == 9){
			return movil; 
		}
		Pattern patron = Pattern.compile("^(56)?(\\d{9})$");
		Matcher matcher = patron.matcher(movil.trim());
		if(matcher.matches()){
			return movil.substring(2);
		}else{
			return null;
		}
	}
	/**
	 * Retorna el entero de un double redondeado hacia arriba.
	 * 
	 * @param numero Double
	 * @return Integer
	 */
	public static Integer roundUp(Double numero) {
		BigDecimal big;
		try{
			big = BigDecimal.valueOf(numero);
			big = big.setScale(0, BigDecimal.ROUND_UP);
		}catch(Exception e){
			return 0;
		}
		return big.intValue();
	}
	/**
	 * <p>Retorna la fecha actual en string de acuerdo al patron informado.</p>
	 * <p>Patron por default: "yyyy-MM-dd HH:mm:ss"</p>
	 * 
	 * @param pattern String
	 * @return String
	 */
	public static String getFechaActual(String pattern) {
		String resultado = "";
		if(pattern == null){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		try{
			Calendar fecCal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			resultado = format.format(fecCal.getTime());
		}catch(Exception e){
			return null;
		}
		return resultado;
	}
	/**
	 * Quita el salto de linea a un String
	 * 
	 * @param texto
	 * @return String
	 */
	public static String quitarSaltoLinea(String texto) {
		if(!esStringValido(texto)){
			return texto;
		}
		return texto.replace("\n", " ");
	}
	/**
	 * complejidad ciclomatica
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value){
		if(null == value || value.trim().isEmpty()){
			return true;
		}
		return false;		
	}
	/**
	 * Formatea un mensaje con un patron, agregandole argumentos.
	 * 
	 * @param pattern String
	 * @param arguments Object...
	 * @return String
	 * @throws ConfigurationException
	 */
	public static String formatearMensaje(String pattern, Object... arguments)throws ConfigurationException {
		String mensaje;
		try{
			mensaje = MessageFormat.format(pattern, arguments);
		}catch(Exception e){
			throw new ConfigurationException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0103,
					"Error en valores de configuracion");
		}
		return esStringValido(mensaje) ? mensaje.trim() : "";
	}

}
