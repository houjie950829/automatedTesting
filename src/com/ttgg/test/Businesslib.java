package com.ttgg.test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

public class Businesslib extends SeleniumBaselib{
	
	/**
	 * 封装之后登陆
	 * @throws Exception
	 */
	public void  login() throws Exception {
		  findElementClick("name", ObjectStore.loginUserName);
	      findElementSendKeys("name", ObjectStore.loginUserName, InputDataStore.userName);
	      findElementClick("name", ObjectStore.loginUserPwd);
	      findElementSendKeys("name", ObjectStore.loginUserPwd, InputDataStore.password);
	      findElementClick("name", ObjectStore.loginButton);
	     // assert super.findElement("class", "text") != null;
	     SeleniumBaselib seleniumBaselib = new SeleniumBaselib();
	     try {
			seleniumBaselib.newAssertEquals("test", true, seleniumBaselib.isElementExist(By.className("tex1t"),driver));
		} catch (Exception e) {
			
		}
	     //seleniumBaselib.newAssert("test", true, seleniumBaselib.isElementExist(By.className("text"),driver));
	    // seleniumBaselib.newAssertEquals("test", true, seleniumBaselib.isElementExist(By.className("text"),driver));
	}
	
	
	
}
