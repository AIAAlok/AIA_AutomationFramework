package com.innomind.projects.aia.pages.SignIn;

import com.innomind.constants.FrameworkConstants;
import com.innomind.driver.DriverManager;
import com.innomind.helpers.ExcelHelpers;
import com.innomind.projects.aia.models.SignInModel;
import com.innomind.projects.aia.pages.CommonPageAIA;

import static com.innomind.keywords.WebUI.clickElement;
import static com.innomind.keywords.WebUI.openURL;
import static com.innomind.keywords.WebUI.setText;
import static com.innomind.keywords.WebUI.sleep;
import static com.innomind.keywords.WebUI.verifyElementVisible;
import static com.innomind.keywords.WebUI.waitForPageLoaded;
import static com.innomind.keywords.WebUI.clearText;
import static com.innomind.keywords.WebUI.getCurrentUrl;
import static com.innomind.keywords.WebUI.getPageTitle;
import static com.innomind.keywords.WebUI.getURL;
import static com.innomind.keywords.WebUI.setText;
import static com.innomind.keywords.WebUI.verifyContains;
import static com.innomind.keywords.WebUI.verifyEquals;
import static com.innomind.keywords.WebUI.*;

import com.innomind.utils.DecodeUtils;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Hashtable;

public class LoginPageABI extends CommonPageAIA {
	
	WebDriver driver;

	public LoginPageABI() {
		driver = DriverManager.getDriver();
	}

	private By titleLoginPage = By.xpath("//h1[normalize-space() = 'Login to your account.']");
	private By messageAccDoesNotExist = By.xpath("//span[@data-notify='message']");

	By emailAddress = By.xpath("//input[@formcontrolname= 'username']");

	By password = By.xpath("//input[@formcontrolname= 'password']");

	By submitbtn = By.xpath("//button[@type= 'submit']");

	By forgotpwd = By.xpath("//a[text()= 'Forgot password?']");

	By signUplink = By.xpath("//a[text()='Sign up']");

	By pageTitleProviderApp = By.xpath("//*[text() = 'New Provider Application']");

	By loginError = By.xpath("//span[contains(text(),'Your password is incorrect')]");
	
	By cookiesAccept = By.xpath("//button[text(),'I consent to cookies ']");

	@Step("Create New User for signup in ABI ")
	public void signInNewUser_ABI(ArrayList<String> dataList) {
		try {  
			
			driver = DriverManager.getDriver();
			driver.navigate().to(FrameworkConstants.URL_ABISignIn);
		   // driver.get();
		    System.out.print(dataList.get(0));
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			//util.waitUntilElement(driver, emailAddress);
			System.out.println("Waiting for the email text field to appear");
			System.out.println("Email Text field displayed");
			setText(emailAddress, dataList.get(5));
			setText(password, dataList.get(6));
			clickElement(submitbtn);
			waitForElementClickable(cookiesAccept);			
			clickElement(cookiesAccept);
				
		}catch(Exception ex) {
			System.out.print("Exception ex :" + ex.getMessage());
		}
	}

}
