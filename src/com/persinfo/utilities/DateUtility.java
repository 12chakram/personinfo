/**
 * 
 */
package com.persinfo.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author vayyalde
 *
 */
public class DateUtility {

	/**
	 * @param dt
	 * @return
	 */
	public static String getDateAsString(int amount){
		TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
		Calendar gCalendar = GregorianCalendar.getInstance(tz);
		gCalendar.add(GregorianCalendar.DAY_OF_YEAR, amount);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return df.format(gCalendar.getTime()); 

	}
	
	/**
	 * @param dt
	 * @return
	 */
	public static Date convertStringToDate(String dt){
		 try {    
	         DateFormat formatter ; 
	          formatter = new SimpleDateFormat("MM/dd/yyyy");
	          return  formatter.parse(dt);    
		 } catch (ParseException e){
	    	return null;  
		 }    	     
	}
	
	/**
	 * @param dt
	 * @return
	 */
	public static String getDateAsString(Date dt){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		return df.format(dt.getTime()); 

	}
	
	/**
	 * @param dt
	 * @return
	 */
	public static String getTodaysDateAsString(){
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("EEE MMM dd,  yyyy"); 
		return df.format(dt.getTime()); 

	}
	
}
