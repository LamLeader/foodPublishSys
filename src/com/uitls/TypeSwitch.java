package com.uitls;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeSwitch {
   
	/**
	 * 字符串转换成BigDecimal
	 * @param str1
	 * @return
	 */
	public static  BigDecimal strToBigDecimal(String str1){
		BigDecimal bd=new BigDecimal(str1);
		return bd;
	}
	/**
	 * BigDecimal转换成字符串
	 * @param str1
	 * @return
	 */
	public static  String bigDecimalToStr(BigDecimal big){
		BigDecimal bd=new BigDecimal("big");
		String str=bd.toString();
		return str;
	}
	/**
	 * 将数值数据从字符串中取出
	 * @param str1
	 * @return
	 */
	public static String getNumber(String str){
		// 需要取整数和小数的字符串
        // 控制正则表达式的匹配行为的参数(小数)
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        //Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
        Matcher m = p.matcher(str);
        //m.find用来判断该字符串中是否含有与"(\\d+\\.\\d+)"相匹配的子串
        if (m.find()) {
            //如果有相匹配的,则判断是否为null操作
            //group()中的参数：0表示匹配整个正则，1表示匹配第一个括号的正则,2表示匹配第二个正则,在这只有一个括号,即1和0是一样的
            str = m.group(1) == null ? "" : m.group(1);
        } else {
            //如果匹配不到小数，就进行整数匹配
            p = Pattern.compile("(\\d+)");
            m = p.matcher(str);
            if (m.find()) {
                //如果有整数相匹配
                str = m.group(1) == null ? "" : m.group(1);
            } else {
                //如果没有小数和整数相匹配,即字符串中没有整数和小数，就设为空
                str = "";
            }
        }
          return str;
	} 
	/**
	 * 百分比转换成小数
	 * @param str
	 * @return
	 */
	public static BigDecimal percentageTodecimal(String str){
		//NumberFormat是一个工厂，可以直接getXXX创建，而getPercentInstance()
		NumberFormat nf=NumberFormat.getPercentInstance();
		//是返回当前默认语言环境的百分比格式。
		DecimalFormat df=new DecimalFormat("0.000000");
		Number m = null;
		try {
			m = nf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String str2=df.format(m);
		//System.out.println(str2);//打印数值
		return strToBigDecimal(str2);
	} 
	/**
	 * Bigdecimal 小数 转 百分比
	 */
	public static String bigdecimalToPe(BigDecimal big){
		String percent="";
		DecimalFormat df = new DecimalFormat("0.00%");  
	    percent=df.format(big);
		return percent;
	}
	/**
	 * Bigdecimal 两小数相除 转百分比
	 */
	public static String bigdecimalTopercent(BigDecimal big1,BigDecimal big2){
		String percent="";
	    double big11 = big1.doubleValue();
	    double big22 = big2.doubleValue();
		double num= (double)big11/big22;  
		DecimalFormat df = new DecimalFormat("0.00%");//格式化小数   
		percent = df.format(num);//返回的是String类型 
		return percent;
	}
	
	
	/**
	 * 比例计算
	 * @param str1
	 * @return
	 */
	public static BigDecimal calculateBigDecimal(BigDecimal bignum1,BigDecimal bignum2){
		BigDecimal bignum3 = null;  
		try {
			bignum3 = bignum1.divide(bignum2,3,BigDecimal.ROUND_HALF_UP);//像上取整保留三位小数
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}if(bignum3!=null){
			return bignum3;
		}else{
			return null;
		}
		
		
	} 
	/**
	 * 字符串中提取小数
	 * @param str1
	 * @return
	 */
	public static String StrSubDecimal(String str){
      StringTokenizer fenxi= new StringTokenizer(str," "); //以空格和逗号分
      int len = fenxi.countTokens();
      StringBuffer temps=null;
      String str1=null;
      while(fenxi.hasMoreTokens())
      {
         String s = fenxi.nextToken();
         temps = new StringBuffer();
         char sr[] = s.toCharArray();
         for(int i = 0;i<sr.length;i++)
         {
           if(Character.isDigit(sr[i]) || (sr[i] =='.'))
              temps.append(sr[i]);
         }
         if(temps.length() != 0)
           str1=new String(temps);
          }
          
       return  str1;
	} 
	/**
	 * //String  str1="1%us";  字符串中提取百分比
	 * @param str1
	 * @return
	 */
	public static String strUsTopencet(String str1){
		String[] a1=str1.trim().split(":");
		String a1Str=a1[1].toString().trim();
		String[] a2=a1Str.trim().split("us");
		String str=a2[0].toString().trim();
		return str;
		
	}
	/**
	 * //String  str1="1%Sys";  字符串中提取百分比
	 * @param str1
	 * @return
	 */
	public static String strSysTopencet(String str1){
		String[] a=str1.trim().split("sy");
		String str=a[0].trim().toString();
		return str;
		
	}
	/**
	 * BigDecimal 相减 
	 * @param str1
	 * @return
	 */
	public static String bigFreeRate(BigDecimal bignum1,BigDecimal bignum2){
		String str="";
		BigDecimal bigFreeRate = null; 
		bigFreeRate = bignum1.subtract(bignum2); 
		str=bigFreeRate.toString().trim();
		return str;
		
	}
	/**
	 * 
	 * @param str1
	 * @return
	 */
	public static String strIdTopencet(String str1){
		String[] a=str1.trim().split("id");
		String str=a[0].trim().toString();
		return str;
		
	}
	/**
	 * 
	 * @Description  TODO
	 * @Author panshengwu
	 * @Date 2019年2月28日 下午3:16:18
	 * @param strbegeinLatitude
	 * @param strbegeinLongitude
	 * @param strendlatitude
	 * @param strendlongitude
	 * @return
	 */
	public static Boolean eqLatitudeAndLongitude(String  strbegeinLongitude,String  strbegeinLatitude,
			String  strendlongitude,String  strendlatitude){
		boolean bol=false;
		
		double begeinLongitudeD=Double.parseDouble(strbegeinLongitude);//起点经度
		double begeinLatitudeD=Double.parseDouble(strbegeinLatitude);//起点纬度
		
		double endlongitudeD=Double.parseDouble(strendlongitude);//终点经度
		double endlatitudeD=Double.parseDouble(strendlatitude);//终点经度
		DecimalFormat df = new DecimalFormat("#.000000");
	   
	    
	    String  stra=(String)df.format(begeinLongitudeD);
	    String  strb=(String)df.format(endlongitudeD);
	    
	    String  strc=(String)df.format(begeinLatitudeD);
	    String  strd=(String)df.format(endlatitudeD);
	   
	    System.out.println("经度："+stra+" "+strb+",纬度："+strc+" "+strd);
	    
	    
	    if(!stra.equals("")&&!strb.equals("")&&!strc.equals("")&&!strd.equals("")){
	    	 if(stra.equals(strb)&&strc.equals(strd)){
	 	    	bol=true;
	 	    	System.out.println("匹配结果："+bol);
	 	    }
	    }
	    return bol;
	}
	
	public static void main(String[] args) {
		//String str1="31.123456789";
		//System.out.println("分割："+str1.substring(0, str1.split(".").length));
		
		String q="31.2327972333,117.2378772323";
		String we="31.2327971111,117.2378773232";
		String  str1="31.23279768668";
		String  str2="31.2327979090909";
		String  str3="117.2378772323";
		String  str4="117.2378773232";
		
		TypeSwitch.eqLatitudeAndLongitude(str1, str3, str2,str4);
		
	}
}
