package com.demoproject.SampleCRM.Baseclass;

import org.testng.annotations.Test;
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
	
	
	public void init() throws IOException {
		
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
		
		
	}
	
	
	
  @BeforeMethod
  public void beforeMethod() throws IOException 
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
