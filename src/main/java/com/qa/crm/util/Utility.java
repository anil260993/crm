package com.qa.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.qa.crm.base.TestBase;
import com.sun.media.sound.InvalidFormatException;

public class Utility extends TestBase{

	

	public Utility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long page_load_timeout=50;
	public static long page_implicity_wait=15;
	
	
	public static void moveInToFrame(){
		driver.switchTo().frame("mainpanel");
		
	}
	
	public static void moveOutOfFrame(){
		driver.switchTo().defaultContent();
		
	}
	
	
	
	}
