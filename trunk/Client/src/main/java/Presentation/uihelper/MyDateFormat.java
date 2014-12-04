package Presentation.uihelper;

public class MyDateFormat {
	 public static String FomatDate(String date){
	    	String year=date.substring(0, 4);
	    	String month=date.substring(4, 6);
	    	String day=date.substring(6, 8);
	    	return year+"/"+month+"/"+day;
	    }
}
