package com.healthCare.executepageclasses;

import org.testng.annotations.Test;

import com.utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass1 {
  //@Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }

  @DataProvider
  public Object[][] dp() throws IOException {
    return new Object[][] {
    	new Object[] { ExcelReadClass.getStringData(2, 4), ExcelReadClass.getStringData(3, 4) },
        new Object[] { ExcelReadClass.getStringData(2, 5), ExcelReadClass.getStringData(3, 5)},
        new Object[] { ExcelReadClass.getStringData(2, 6), ExcelReadClass.getStringData(3, 6) }
    };
    
  }
  @DataProvider(name="login")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
    	new Object[] { ExcelReadClass.getStringData(2, 1),ExcelReadClass.getStringData(3, 1)  },
    };
}
}
