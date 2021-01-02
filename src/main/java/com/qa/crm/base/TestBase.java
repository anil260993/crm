package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.util.Utility;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public TestBase() throws IOException{
		FileInputStream fis=new FileInputStream("D:\\eclipse_automation_workspace\\POMFramwork_new\\src\\main\\java\\com\\qa\\crm\\util\\config.properties");
		prop=new Properties();
		prop.load(fis);
		
		
	}
	public static void intialize(){
		String browser_name=prop.getProperty("browser");
		if(browser_name.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser_name.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.page_implicity_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
