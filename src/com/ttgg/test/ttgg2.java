package com.ttgg.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ttgg2 extends SeleniumBaselib{
	
	Businesslib businesslib = new Businesslib();
	
	@Before
	public void setUp() throws Exception {
	businesslib.newSetup("lemon");
	}

	@Test
	public void testTtgg() throws Exception {
		businesslib.login();
	}
	@After
	public void tearDown() throws Exception {
		businesslib.newClose();
	}
}
