package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datess {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println(d.toString());
		System.out.println(d.getDate());
		System.out.println(d.getHours());
		System.out.println(d.getDay());
		System.out.println(d.getMinutes());
		System.out.println(d.getTime());
		
		SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.println(s.format(d));
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println(cal.get(Calendar.AM_PM));
	}
}
