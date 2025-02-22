package com.client.vtiger.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtils 
{
	public int getRandomValue()
	{
		Random random=new Random();
		int randomInt=random.nextInt(5000);
		return randomInt;
	}
	
	public String getCurrentDateYYYYMMdd()
	{
		Date dateObj= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String actDate=sdf.format(dateObj);
		return actDate;
	}
	public String getEndDateYYYYMMdd(int days)
	{
		Date dateObj=new Date();
		SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");	
		simpleDate.format(dateObj);

		Calendar cal=simpleDate.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String endDate=simpleDate.format(cal.getTime());
		return endDate;
	}
}
