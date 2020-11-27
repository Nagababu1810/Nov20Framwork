package com.demoproject.SampleCRM.SuiteA;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoproject.SampleCRM.Baseclass.BaseTest;


public class LoginTest extends BaseTest{
  @Test(dataProvider="getdata")
  public void f(String x,String Y) {
	  
	  System.out.println("i am f Testmethod.......from LoginTest");
 
  
  }
  
  @DataProvider
  public Object[][] getdata(){
	  Object[][] data=new Object[2][3];
			  data[0][0]=10;
			  data[0][1]=20;
			  data[1][0]=30;
			  data[1][1]=40;
			  data[1][2]=50;
	
	  
	  System.out.println("i am dataprovider.....");
	  
	  
	  return data;
	  	  
  }

  
  
  
  
  
}
