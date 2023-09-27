package com.innomind.dataprovider;

import com.innomind.constants.FrameworkConstants;
import com.innomind.helpers.ExcelHelpers;
import com.innomind.helpers.Helpers;
import com.innomind.helpers.PropertiesHelpers;
import com.innomind.projects.aia.models.ClientModel;
import com.innomind.projects.aia.models.SignInModel;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;

public final class DataProviderManager {

    private DataProviderManager() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @Test(dataProvider = "getSignInDataHashTable")
    public void testGetSignInData(Hashtable<String, String> data) {
        System.out.println("signInData.testCaseName = " + data.get(SignInModel.getTestCaseName()));
        System.out.println("signInData.username = " + data.get(SignInModel.getEmail()));
        System.out.println("signInData.password = " + data.get(SignInModel.getPassword()));
        System.out.println("signInData.expectedTitle = " + data.get(SignInModel.getExpectedTitle()));
        System.out.println("signInData.expectedError = " + data.get(SignInModel.getExpectedError()));

    }

    @Test(dataProvider = "getClientDataHashTable")
    public void testGetClientData(Hashtable<String, String> data) {
        System.out.println("clientData.TestCaseName = " + data.get(ClientModel.getTestCaseName()));
        System.out.println("clientData.CompanyName = " + data.get(ClientModel.getCompanyName()));
        System.out.println("clientData.OWNER = " + data.get(ClientModel.getOwner()));
        System.out.println("clientData.Address = " + data.get(ClientModel.getAddress()));
        System.out.println("clientData.CITY = " + data.get(ClientModel.getCity()));
        System.out.println("clientData.STATE = " + data.get(ClientModel.getState()));

    }
    
    @DataProvider(name = "getSignUp_UserDetails")
    public static  Object [][] testGetSignUp_UserDetails()
    {
    	 String fName;
    	 String lName;
    	 String mobNumb;
    	 String password;
    	 String emailaddressdata;
    	 String  emailPrefix;
    	 String emailDomain;
    	 ArrayList<String> data =new ArrayList<String>();
    	  fName = "AutoFn";
    	  data.add(0, fName);
		  System.out.println(fName); 
		  lName = "AutoLn";
		  data.add(1, lName);
		  mobNumb = String.format("%06d", new Random().nextInt(10000));
		  data.add(2, mobNumb);
		  System.out.println(mobNumb); 
		  DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		  Date date = new Date();
		  System.out.println(date.toString());
		  String date1= dateFormat.format(date);
		  System.out.println(date1);
		  emailPrefix = "automation_"+RandomStringUtils.randomAlphabetic(4).toLowerCase()+date1;
		  data.add(3, emailPrefix);
		  emailDomain = "@architects-team.m8r.co";
		  data.add(4, emailDomain);
		  emailaddressdata = emailPrefix + emailDomain;
		  data.add(5, emailaddressdata);		  
		  password = "Login_123";
		  data.add(6, password);	
		  
		  Object [][] objArray = new Object[data.size()][];

		  for(int i=0;i< data.size();i++){
		     objArray[i] = new Object[1];
		     objArray[i][0] = data.get(i);
		  } 

		  return objArray;	  
		  
		  
    }
  
    

    @DataProvider(name = "getSignInDataHashTable", parallel = true)
    public static Object[][] getSignInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn", 1, 2);
        System.out.println("getSignInData: " + data);
        return data;
    }

    @DataProvider(name = "getClientDataHashTable", parallel = true)
    public static Object[][] getClientData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Client", 1, 2);
        System.out.println("getClientData: " + data);
        return data;
    }

}
