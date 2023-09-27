package com.innomind.projects.aia.pages.SignIn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;

import com.innomind.driver.DriverManager;
import com.innomind.utils.LogUtils;
import com.innomind.constants.FrameworkConstants;
import com.google.protobuf.Duration;
import com.innomind.projects.aia.api.MailinatorAPI;
import com.innomind.projects.aia.pages.CommonPageAIA;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;

import static com.innomind.keywords.WebUI.*;
import static com.innomind.keywords.WebUI.getURL;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.*;
import io.qameta.allure.Step;


public class SignUpPage extends CommonPageAIA {
	
	public SignUpPage() {
		// TODO Auto-generated constructor stub
	}
	
	MailinatorAPI mailinator;
	
   public By signup = By.xpath("//a[text()='Sign up']");
   public By firstName = By.xpath("//input[@formcontrolname='firstName']");
   public By lastName = By.xpath("//input[@formcontrolname='lastName']");
   public By emailAddress = By.xpath("//input[@formcontrolname='email']");
   public By mobileCountry = By.xpath("//mat-select[@formcontrolname='mobilePhoneCountry']");
	
	
	public By mobileCountryoption = By.xpath("//span[text()=' United States of America (+1) ']");
	
	public By mobilePhoneNum =   By.xpath("//input[@formcontrolname='mobilePhone']");
	public By desirdPwd = By.xpath("//input[@formcontrolname='password']");
	public By confrmPwd = By.xpath("//input[@formcontrolname='confirmPassword']");
	public By signUpSubmitbtn = By.xpath("//span[text()='Sign Up']");
	public By captchaFrame = By.xpath("//iframe[@title='reCAPTCHA']");
	public By captchaChckbx = By.xpath("//div[@class = 'recaptcha-checkbox-border']");
	public By closebtn = By.xpath("//span[text()= 'Close']");
	public By dropdownAccount = By.xpath("//a[@id='user-dropdown']//span[2]");
	
	public By emailSucessMessage = By.xpath("//span[text(),'SUCCESS']");
	
	
	 String fName = "AutoFn";//need to use random 
	 String lName = "AutoLn";//need to use random
	 String mobNumb = String.format("%06d", new Random().nextInt(10000));
	 DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
	 Date date = new Date();
	 String date1= dateFormat.format(date);
	 String password = "Login_123";
	 public String  emailPrefix = "automation_"+RandomStringUtils.randomAlphabetic(4).toLowerCase()+date1;
	 public String emailDomain = "@architects-team.m8r.co";
	 public String emailaddressdata  = emailPrefix + emailDomain;
	 ArrayList<String> list = new ArrayList<String>();
	 
	 //Data created for new User - signup form
	public ArrayList<String> signUpData() throws Exception { 	
		 
		  list.add(0, fName);
		  System.out.println(fName); 
		  list.add(1, lName);
		  list.add(2, mobNumb);
		  System.out.println(mobNumb); 
		 
		  System.out.println(date.toString());
		 
		 
		  list.add(3, emailPrefix);
		  
		  list.add(4, emailDomain);
		  
		  list.add(5, emailaddressdata);		  
		 
		  list.add(6, password);
		  
		  return list;
		  }
	
	@Step("click on SignupLink")
	public void clickSignUplink( ) throws Exception
	{
		clickElement(signup);
		list = signUpData();
	}
	
	@Step("Enter user details and click on submit button")
	public void signUpUser( ) throws Exception
	{
	 
		getURL(com.innomind.constants.FrameworkConstants.URL_ABISignUp);
		
	/*	int timeout = 1000;
		try {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),java.time.Duration.ofSeconds(timeout)) ;
	    wait.until(ExpectedConditions.presenceOfElementLocated(signup));
	    LogUtils.info("Verify element present ");
		}catch(Exception ex) {
			LogUtils.error(ex.getMessage());
		}	*/
	    setText(firstName,fName);	    
	    setText(lastName,lName);
		
	    setText(emailAddress, emailaddressdata);
	    clickElement(mobileCountry);
	    Thread.sleep(1000);
	    clickElement(mobileCountry);
	    clickElement(mobileCountryoption);
		setText(mobilePhoneNum, mobNumb);
		setText(desirdPwd,password);
		setText(confrmPwd,password);
					/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(captchaFrame));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(captchaChckbx)).click();
		 * 
		 * Thread.sleep(10000); driver.switchTo().defaultContent();
		 */
		
		
		
		clickElement(signUpSubmitbtn);
		//Thread.sleep(100000);
		
		
	}
	
	@Step("Verify email ")
	public void verifyEmail() throws InterruptedException
	{
	 mailinator = new MailinatorAPI(DriverManager.getDriver());
	 mailinator.verifyEmailForAccountSetup(emailPrefix);
	// waitForElementClickable(emailSucessMessage, 10000);
	 //DriverManager.getDriver().close();
	}
	
	@Step("After Sign up new user - Click on close button  ")
	public void clickCloseAfterVerification() throws InterruptedException
	{
		//Thread.sleep(100000);
		clickElement(closebtn);
				
	}
	
	
}
