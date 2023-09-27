package com.aia.projects.abi.testcases;

import com.innomind.constants.FrameworkConstants;
import com.innomind.enums.*;
import com.innomind.helpers.ExcelHelpers;
import com.innomind.projects.aia.pages.SignIn.LoginPageABI;
import com.innomind.projects.aia.pages.SignIn.SignUpPage;
import com.innomind.dataprovider.DataProviderManager;
import com.aventstack.extentreports.model.Log;
import com.innomind.annotations.FrameworkAnnotation;
import com.innomind.common.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


import static com.innomind.keywords.WebUI.*;

import java.util.ArrayList;
import java.util.Hashtable;

@Epic("Regression Test AIA - ABI")
@Feature("SignUp Test")
public class LoginTest extends BaseTest {
	
	
	LoginPageABI loginPageABI;
	SignUpPage signupPage;
	ArrayList<String> dataList;
	
	public LoginTest() {
		loginPageABI = new LoginPageABI();
		signupPage = new SignUpPage();
	
	}
	
	 //Using library DataProvider with read Hashtable
	@FrameworkAnnotation(author = {AuthorType.Alok}, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test(priority = 1, description = "ABI_TC01_SignUpNewUser", dataProvider = "getSignUp_UserDetails", dataProviderClass = DataProviderManager.class)
    public void signUp_NewUser(ArrayList<String> data) {
    	
    	System.out.print("Data : " + data);
    	//loginPageABI.signUpNewUser_ABI(data);
    	
    }
	
	
	
	
	
/*
	@FrameworkAnnotation(author = {AuthorType.Alok}, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test(priority=1, description="Validate ABI SignUp using credit card.", enabled=true)
	public void Validate_Signup_Through_CreditCard() throws Exception
	{
		loginPageAbi.loginToABI(dataList.get(5), dataList.get(6));
		loginPageAbi.checkLoginSuccess();
		System.out.print("Welcome to ABI Test");
	}
	
	*/
	
	/*
	
	//Using library DataProvider with read Hashtable
    @FrameworkAnnotation(author = {AuthorType.Alok}, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
    //@Test(priority = 1, description = "TC01_signInWithDataProvider", dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
   @Test(priority = 1)
    public void TC_LoginFailWithEmailNull() {
      
    	loginPageABI.openLoginPage();
      
    }

    @FrameworkAnnotation(author = {AuthorType.Alok}, category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 2)
    public void TC_LoginFailWithEmailDoesNotExist(String userName , String password) {
    	 // ExcelHelpers excel = new ExcelHelpers();
        //  excel.setExcelFile(FrameworkConstants.EXCEL_ABI_DATA, "Login");
        //  getLoginPageABI().loginFailWithEmailDoesNotExist(excel.getCellData(1, "email"), excel.getCellData(1, "password"));
    	 getLoginPageABI().loginFailWithEmailDoesNotExist("albhagat@innominds.com","password");
    }*/
}
