package com.ttgg.test;

public interface InputDataStore {
	
	String webdriver = BaseLib.getPropertyString("webdriver");
	
	String FireFoxBrowser = BaseLib.getPropertyString("FireFoxBrowser");
	
	String ChromeBrowser = BaseLib.getPropertyString("ChromeBrowser");
	
	String IEBrowser = BaseLib.getPropertyString("IEBrowser");
	
	String OperaBrowser = BaseLib.getPropertyString("OperaBrowser");
	
	String SafariBrowser = BaseLib.getPropertyString("SafariBrowser");
	
	String URL = BaseLib.getPropertyString("URL");
	
	String userName = BaseLib.getPropertyString("userName");
	
	String password = BaseLib.getPropertyString("password");
	
	String loginBtn = BaseLib.getPropertyString("loginBtn");

}
