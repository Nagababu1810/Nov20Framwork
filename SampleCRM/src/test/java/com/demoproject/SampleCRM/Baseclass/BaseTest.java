package com.demoproject.SampleCRM.Baseclass;



import com.demoproject.SampleCRM.Utilities.ExcelAPI;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;

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
		
		
		String[] pack = this.getClass().getPackage().getName().split("\\.");
		String suiteName = pack[pack.length-1];
		System.out.println(suiteName);
		
		//xls=new ExcelAPI(projectpath+"\\src\\test\\resources\\"+suiteName+".xlsx");
		//every change suitname ramdomly
		xls=new ExcelAPI(childprop.getProperty(suiteName+".xls"));
		
		String TestName = this.getClass().getSimpleName();
		System.out.println(TestName);
		
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
