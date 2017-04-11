package com.tpajay.javahack.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class PlayDate {
	
	public static void main(String args[]) {
		
		Date date = new Date();
		System.out.println("Current Date/Time: " + date);
		
		String oldDttm = "011520171330";
		String month = oldDttm.substring(0, 2);
		String day = oldDttm.substring(2,4);
		String year = oldDttm.substring(4, 8);
		String hour = oldDttm.substring(8, 10);
		String mins = oldDttm.substring(10, 12);		
		System.out.println(month + "/" + day + "/" + year + " " + hour + ":" + mins);
		
		java.util.Date dttm = new java.util.Date(Integer.parseInt(year)-1900,
				Integer.parseInt(month)-1,
				Integer.parseInt(day), Integer.parseInt(hour),
				Integer.parseInt(mins), 0);

		Calendar c = Calendar.getInstance(); //get current date time
		c.setTime(dttm); //set Calendar to time from input
		
		Date convertedDate = c.getTime();
		System.out.println(convertedDate.toString());
		
		//or Calendar
		Calendar calendar = Calendar.getInstance();
		Date calDate =  calendar.getTime();
		
		//Java SE 8 Date and Time
		//This code is from http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
		//java.util.Date is DEPRECATED, try java.time.LocalDate and LocalTime (Thread-safe)
		LocalDateTime timePoint = LocalDateTime.now();     // The current date and time
		LocalDate.of(2012, Month.DECEMBER, 12); // from values
		LocalDate.ofEpochDay(150);  // middle of 1970
		LocalTime.of(17, 18); // the train I took home today
		LocalTime.parse("10:15:30"); // From a String
		
		LocalDate theDate = timePoint.toLocalDate();
		Month month2 = timePoint.getMonth();
		int day2 = timePoint.getDayOfMonth();
		timePoint.getSecond();
		
		// Set the value, returning a new object
		LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);

		/* You can use direct manipulation methods, or pass a value and field pair */
		LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
		
		// You can specify the zone id when creating a zoned date time
		ZoneId id = ZoneId.of("Europe/Paris");
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zoned = ZonedDateTime.of(dateTime , id);
		System.out.println("LocalDateTime + ZoneId: " + dateTime.toString());
		//assertEquals(id, ZoneId.from(zoned));
		
		
	}

}
