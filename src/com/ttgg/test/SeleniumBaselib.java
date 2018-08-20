package com.ttgg.test;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.javafx.charts.ChartLayoutAnimator;

public class SeleniumBaselib {

	protected WebDriver driver;
	//页面元素
    private WebElement element;
    
	private static Logger logger = Logger.getLogger(SeleniumBaselib.class.getName());
	/**
	 * 
	 * @param p_caseName   用例名称
	 * @throws Security Exception
	 * @throws IOException
	 */
	protected void newSetup(String p_caseName) throws SecurityException, IOException {
		try {
			BaseLib.createHtmlLog(p_caseName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");//设置webdriver驱动的浏览器
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");//设置浏览器对应的驱动程序，不同的浏览器的
		driver = new FirefoxDriver();
		//响应时间
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //窗口最大化
	    driver.manage().window().maximize();
	    //打开网页
	    driver.get("https://www.baidu.com/");
	
		FileHandler fileHandler = new FileHandler("E:\\selenium.log");
		fileHandler.setLevel(Level.INFO);
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
	}
	
	/**
	 * @param by   一个类型（id、class、name等）
	 * @param byValue   名称（类型的值）
	 * @return    返回WebElement
	 */
	
	protected WebElement findElement(String by, String byValue) {
	       try {
	    	   switch (by) {
               case "id":
                   element = driver.findElement(By.id(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
                   break;
               case "name":
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
                   element = driver.findElement(By.name(byValue));
                   break;
               case "class":
                   element = driver.findElement(By.className(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
                   break;
               case "tag":
                   element = driver.findElement(By.tagName(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
               case "link":
                   element = driver.findElement(By.linkText(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
                   break;
               case "partiallinktext":
                   element = driver.findElement(By.partialLinkText(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
               case "css":
                   element = driver.findElement(By.cssSelector(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
                   break;
               case "xpath":
                   element = driver.findElement(By.xpath(byValue));
                   logger.info(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mPass);
                   break;
               default:
            	   throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
           }
		} catch (Exception e) {
            logger.severe(MessageOutput.mFind+MessageOutput.mObject+byValue+MessageOutput.mFail);
			// TODO: handle exception
		}
	           
	        return element;
	    }
	/**
	 * 
	 * @param by   一个类型（id、class、name等）
	 * @param byValue  名称（类型的值）
	 */
	protected  void findElementClick(String by, String byValue) {
        try {
            findElement(by, byValue).click();
            logger.info(MessageOutput.mClick+MessageOutput.mObject+byValue+MessageOutput.mPass);
        } catch (Exception e) {
            logger.severe(MessageOutput.mClick+MessageOutput.mObject+byValue+MessageOutput.mFail);
        }
    }
    
    /**
     * 
     * @param by   一个类型（id、class、name等）
     * @param byValue  名称（类型的值）
     * @param key   文本框的值
     */
	protected void findElementSendKeys(String by, String byValue,String key) {
        try {
            findElement(by, byValue).sendKeys(key);
            logger.info(MessageOutput.mInput+MessageOutput.mObject+byValue+MessageOutput.mPass);
        } catch (Exception e) {
            logger.severe(MessageOutput.mInput+MessageOutput.mObject+byValue+MessageOutput.mFail);
        }
    }  
    
    /**
     * 判断页面元素是否存在
     *
     * @param by
     * @return boolean
     */
	protected boolean isElementExist(By by,WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            // TODO: handle exception
           
        }
        return false;
    }
    
	protected void newAssertEquals(String p_m, Object p_expected, Object p_actual) {
		if (p_expected.equals(p_actual)) {
			BaseLib.writeToLog(p_m, p_expected, p_actual, "PASS");
		}else {
			BaseLib.writeToLog(p_m, p_expected, p_actual, "FAIL");
		}
	}
	protected void newAssert(String p_m, Object p_expected, Object p_actual) {
		if (p_expected.equals(p_actual)) {
			BaseLib.writeToLog(p_m, p_expected, p_actual, "PASS");
		}else {
			BaseLib.writeToLog(p_m, p_expected, p_actual, "FAIL");
		}
	}
	protected void newClose() {
    	driver.close();
    }   
}
