package businesslogic.utilitybl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getDate {
	public static String getdate() {
		
		 Calendar rightNow = Calendar.getInstance();
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	        String sysDatetime = fmt.format(rightNow.getTime());   
	return sysDatetime;
	}
	
public static String getAllDate() {
		
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DATE);
		String d=year+"-"+month+"-"+day;
		d+=" "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+" "/*":"+c.get(Calendar.SECOND)*/;
		return d;
	
	}
}
