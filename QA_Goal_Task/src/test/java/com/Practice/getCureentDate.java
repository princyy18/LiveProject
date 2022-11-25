package com.Practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getCureentDate {

	public static void main(String[] args) {
		
		
		//get the current date
//		DateFormat dateFormat = new SimpleDateFormat("dd");
//		Date date = new Date();
//		String date1= dateFormat.format(date);
//		 System.out.println(date1);
		
		
		//get the date after 2 days of current date
		DateFormat dateFormat = new SimpleDateFormat("dd");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 2);
	    String newDate = dateFormat.format(cal.getTime());
	    System.out.println(newDate);
	}

}
