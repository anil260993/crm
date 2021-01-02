package com.qa.crm.testcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.Loginpage;
import com.qa.crm.util.Utility;

public class HomepageTest extends TestBase{
	Loginpage loginpage;
	Homepage homepage;
	

	public HomepageTest() throws IOException {
		super();
		
	}
	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		intialize();
		loginpage=new Loginpage();	
	homepage=	loginpage.validatingLoginPage(prop.getProperty("username"), prop.getProperty("password"));
	//Thread.sleep(5000);
	}
	@Test(priority=1)
	public void homePageUserLabelValidationTest(){
		
	
	try{
		Utility.moveInToFrame();
		boolean usernamelabel=	homepage.userLabelValidation();
	Assert.assertTrue(usernamelabel);
	System.out.println("Login is succe");
	}catch(NoSuchElementException e){
		System.out.println("Login is not sucessfull");
	}
	catch(NoSuchFrameException e1){
		System.out.println("Login is not sucessfull");
	}
	}
	/*@Test(priority=2)
	public void homepageUrlValidationTest(){
		String homepageUrl=homepage.homepageUrlValidation();
		Assert.assertEquals(homepageUrl, "https://classic.freecrm.com/index.cfm?CFID=1579057&CFTOKEN=79633529&jsessionid=483071a7598a3c0c59214e3de3f4b4e56792","HomePage url is not matching--------------->");
		
	}*/
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
