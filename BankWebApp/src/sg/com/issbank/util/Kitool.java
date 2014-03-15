package sg.com.issbank.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kitool{
	public static Date parseDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d=format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static java.sql.Date parseSQLDate(Date utilDate){
		 return new java.sql.Date(utilDate.getTime());
	}
	
	public static Timestamp currentTimeStamp(){
		Timestamp currentTimeStamp=null;
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date();
		Date dateFormatted;
		try {
			dateFormatted = dt.parse(dt.format(date));
			currentTimeStamp = new Timestamp(dateFormatted.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return currentTimeStamp;
	}
}
