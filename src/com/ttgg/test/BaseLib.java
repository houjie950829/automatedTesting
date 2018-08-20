package com.ttgg.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.Properties;

public class BaseLib {

	static HTMLReport hr=new HTMLReport();
	
	public static String HtmlLog;
	
	public static String SeleniumBaseLibLog;
	
		/**
		 * 读取外部文件
		 * @param key  
		 * @return
		 */
	public static String getPropertyString(String key) {
		String propertyFileName = System.getProperty("user.dir") + "\\config.properties"; // 获得文件路径
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(propertyFileName)); // 获取文件中的内容
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (key == null || key.equals("") || key.equals("null")) {
			return "";
		}
		String result = "";
		try {
			result = properties.getProperty(key); 
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static String getCurrentTime() throws Exception {

		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);// 获取年份
		int month = ca.get(Calendar.MONTH);// 获取月份
		int day = ca.get(Calendar.DATE);// 获取日
		int minute = ca.get(Calendar.MINUTE);// 分
		int hour = ca.get(Calendar.HOUR);// 小时
		int second = ca.get(Calendar.SECOND);// 秒
		return (String.valueOf(year) + "-" + String.valueOf(month + 1) + "-"
				+ String.valueOf(day) + "-" + String.valueOf(hour) + "-"
				+ String.valueOf(minute) + "-" + String.valueOf(second));

	}
 
 
	
	public static void createHtmlLog(String p_caseName) throws Exception{
	
	String RESULTS_BASE_PATH = "Log" + File.separator
				+ "loggingResults";
	
	String resultsPath = new File(RESULTS_BASE_PATH).getAbsolutePath();
	
	String resultHtmlFileName = resultsPath + File.separator
				+ p_caseName + "_" + BaseLib.getCurrentTime() + "_"
				+ "ie" + "_log.html";
	HtmlLog=resultHtmlFileName;
	
	String resultSeleniumLogFileName = resultsPath + File.separator
			+ p_caseName + "_" + BaseLib.getCurrentTime() + "_"
			+ "_seleniumLog.log";
	SeleniumBaseLibLog=resultSeleniumLogFileName;
	
	if (!new File(RESULTS_BASE_PATH).exists()) {
		new File(RESULTS_BASE_PATH).mkdirs();
	}
	
	    System.out.println("创建 HTML日志 ---"+resultHtmlFileName);
		hr.setup(resultHtmlFileName);
		
		
	}
	public static void closeLog(){
		hr.closeLog();
	}
	
	public static void writeToLog(String p_info,Object p_expected, Object p_actual, String p_result){
		hr.logWriter(p_info, p_expected, p_actual, p_result);
	}
	
	// 获得启动的浏览器信息
		public static String getBrowser(){
			String browser = null;
			if (InputDataStore.ChromeBrowser!=null) 
				browser=InputDataStore.ChromeBrowser;
			else if (InputDataStore.FireFoxBrowser!=null)
				browser=InputDataStore.FireFoxBrowser;
			else if (InputDataStore.IEBrowser!=null)
				browser=InputDataStore.IEBrowser;
			else if (InputDataStore.OperaBrowser!=null)
				browser=InputDataStore.OperaBrowser;
			else browser=InputDataStore.SafariBrowser;
			return browser;
		}
		
		/*public static String getBrowserName() throws Exception{
			
			String str=getBrowser();
			if (str.contains("*iexplore"))
			    return "ie";
			else if (str.contains("*chrome"))
			   return "firefox";
			else if (str.contains("*googlechrome"))
			   return "chrome";
			else if (str.contains("*safari"))
			   return "safari";
			else if (str.contains("*safari"))
				return "opera";
			else return null;
			
		}*/
	
}
