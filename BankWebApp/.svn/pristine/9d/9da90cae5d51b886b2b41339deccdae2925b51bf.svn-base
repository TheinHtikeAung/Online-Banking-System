package sg.com.issbank.biz;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sg.com.issbank.dao.DaoFactory;
import sg.com.issbank.dao.TransactionDao;
import sg.com.issbank.dto.Transaction;

public class TransactionManager {

	/**
	 * @param args
	 */
	
	public ArrayList<Transaction> getTransaction(String from,String to, String accountId){
		Date fromDate=getDate(from,"00:00:00.0");
		Date toDate=getDate(to,"23:59:59.0");
		TransactionDao dao=DaoFactory.getTransactionDao();
		ArrayList<Transaction> transList=dao.getTransactionByDate(fromDate, toDate, accountId);
		return transList;
	}
	
//	public Date getTransaction(String from,String to){
//		return getDate(from); 
//	}

	private static Date getDate(String from, String clock) {		
		Date date = null;		
		String dateStr = "";
	    Pattern p = Pattern.compile("(\\S*)(\\s*)(\\d*)(\\S*)(,)(\\s*)(\\d*)");
	    Matcher m = p.matcher(from);
	    if (m.find()) {
	    	
	    	dateStr = m.group(1)+" "+m.group(3)+", "+m.group(7);
//	    	+" "+clock
	    }		
		try {
			/*date = new SimpleDateFormat("yyyy-MM-dd k:m:s.S").parse(dateStr+" 23:59:59.59");*/
			System.out.println(dateStr+" "+clock);
			date=new SimpleDateFormat("MMM d, yyyy k:m:s.S").parse(dateStr+" "+clock);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return date;
	}

	public ArrayList<Transaction> getAllTransactions(String accId) {
		TransactionDao dao=DaoFactory.getTransactionDao();
		ArrayList<Transaction> transList=dao.getAllTransactions(accId);
		return transList;
		
	}

//	private static Timestamp getCurrentTimeStamp() {
//		// TODO Auto-generated method stub
//		Date date= new Date();
//		return new Timestamp(date.getTime());
//	}
//
//	private static Timestamp getTimeStamp(Date date) {
//		return new Timestamp(date.getTime());
//	}
}
