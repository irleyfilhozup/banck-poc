package com.example.bankpoc.util;


import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateHour {

	public static String getDate(Date dateObject) {
		String dateModel = "dd/MM/yyyy";
		String hourModel = "HH:mm:ss";
		String date, hour;
		
		SimpleDateFormat format = new SimpleDateFormat(dateModel);
		date = format.format(dateObject);
		format = new SimpleDateFormat(hourModel);
		hour = format.format(dateObject);
		
		return date+" "+hour;
	}
}
