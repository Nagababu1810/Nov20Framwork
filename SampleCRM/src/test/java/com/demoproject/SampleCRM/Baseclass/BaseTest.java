package com.demoproject.SampleCRM.Baseclass;

import org.testng.annotations.Test;

import com.demoproject.SampleCRM.Utilities.ExcelAPI;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;

public class BaseTest {
 
	
	public String projectpath=System.getProperty("user.dir");
	public FileInputStream fi;
	public Properties mainprop;
	public Properties childprop;
	public ExcelAPI xls;
	
	
	public void init() throws Exception {
		
		fi=new FileInputStream(projectpath+"//src//test//resources//Environment.properties");
		mainprop=new Properties();
		mainprop.load(fi);
		String e=mainprop.getProperty("env");
		System.out.println(e);
		
		fi=new FileInputStream(projectpath+"//src//test//resources//"+e+".properties");
		childprop=new Properties();
		childprop.load(fi);
		String valu = childprop.getProperty("zohourl");
		System.out.println(valu);
		
		xls=new ExcelAPI("E:\\Users\\Nag\\Aug-2020-WorkingDirectory\\SampleCRM\\src\\test\\resources\\SuiteA.xlsx");
		
	}
	
	
	
  @BeforeMethod
  public void beforeMethod() throws Exception 
  {
	  init();
	  System.out.println("i am beforemethod.......");
	  
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("i am Aftermethod.......");
  }

}
