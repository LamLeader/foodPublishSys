package com.uitls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CommonUtils {
	
	
	private static Date date = new Date();
	
	/**
	 * 时间
	 */
	public static String getCuttentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
		return sdf.format(date);
	}

	/***
	 * 日期 str to  date
	 */
	public static Date strToDate(String strTime) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.parse(strTime);
	}

	/***
	 * 日期时间
	 */
	public static String getCuttentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	/***
	 * 标准格式日期时间
	 */
	public static String getCuttentDateTimeFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/***
	 * Date to String 
	 * @param date
	 * @return
	 */
	public static String convertDateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/***
	 * String to Date
	 * @param datestr
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String datestr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(datestr);
	}

	public static void main(String[] args) {
		/***
		 * 日期 str to  date
		 */
		try {
			System.out.println("date:"+CommonUtils.strToDate("2017-01-01"));;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
