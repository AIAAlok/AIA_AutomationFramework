package com.aia.projects.abi.testcases;

import java.util.ArrayList;

import com.innomind.projects.aia.api.*;
import org.testng.annotations.Test;

import com.innomind.annotations.FrameworkAnnotation;
import com.innomind.common.BaseTest;
import com.innomind.dataprovider.DataProviderManager;
import com.innomind.driver.DriverManager;
import com.innomind.enums.AuthorType;
import com.innomind.enums.CategoryType;
import com.innomind.projects.aia.pages.SignIn.LoginPageABI;
import com.innomind.projects.aia.pages.SignIn.SignUpPage;
import com.innomind.utils.LogUtils;

import freemarker.log.Logger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("Regression Test AIA - ABI")
@Feature("SignUp Test")
public class SignUpUserTest extends  BaseTest {
		
	LoginPageABI loginPageABI;
	SignUpPage signupPage;
		
	MailinatorAPI mailinator;
	
	ArrayList<String> signUp_Data;
	
	public SignUpUserTest() {
		loginPageABI = new LoginPageABI();
		signupPage = new SignUpPage();
		mailinator = new MailinatorAPI(DriverManager.getDriver());
	}
	 
	@FrameworkAnnotation(author = {AuthorType.Alok}, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test(priority = 1, description = "ABI_TC01_SignUpNewUser")
    public void signUp_NewUser() {
		try {
		LogUtils.info("Starting Test SignUp New User in ABI :  ");
		signupPage.signUpUser();
    	signupPage.clickCloseAfterVerification();
    	signupPage.verifyEmail();
    	signUp_Data = signupPage.signUpData();
    	loginPageABI.signInNewUser_ABI(signUp_Data);
    	LogUtils.info("New User SignUp Done  :  ");
		}catch(Exception ex) {
			
		}
    	
    }
	
}
	
	
	