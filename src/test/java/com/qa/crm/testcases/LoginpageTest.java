package com.qa.crm.testcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.Loginpage;


public class LoginpageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	SoftAssert softassert;
	
	
	public LoginpageTest() throws IOException{
		super();
	}
	@BeforeClass
public void setUp() throws IOException{
	intialize();
	loginpage=new Loginpage();
	 softassert=new SoftAssert();
	
	
}

@Test(priority=1)
public void loginPageUrlTest(){
	String url=loginpage.loginPageUrlValidation();
	softassert.assertEquals(url, "https://classic.crmpro.com/","login page url is not matching ");

}

@Test(priority=2)
public void loginPageTitleTest(){
	String LoginpageTitle=loginpage.loginPageTitleValidation();
	softassert.assertEquals(LoginpageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.","login page title is not matching ");

}

@Test(priority=3)
public void loginFunctionalityTest() throws IOException{
	homepage=loginpage.validatingLoginPage(prop.getProperty("username"),prop.getProperty("password"));
	
	
}
 


@AfterClass
public void tearDown() throws InterruptedException{
	softassert.assertAll();
	if(driver!=null){
		driver.quit();
	}
}
}
