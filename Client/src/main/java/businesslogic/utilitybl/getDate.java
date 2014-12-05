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
}
