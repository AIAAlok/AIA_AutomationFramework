package com.innomind.projects.aia.pages;

import com.innomind.projects.aia.pages.SignIn.LoginPageABI;
import com.innomind.projects.aia.pages.SignIn.SignUpPage;

public class CommonPageAIA {

	
	
	  private LoginPageABI loginPageABI;
	  private SignUpPage signUpPage;
	  
	  
	  public LoginPageABI getLoginPageABI() {
	        if (loginPageABI == null) {
	        	loginPageABI = new LoginPageABI();
	        }
	        return loginPageABI;
	    }
	  
	  public SignUpPage getSignUpPage() {
		  
		  
		  if(signUpPage == null) {
			  signUpPage = new SignUpPage();
		  }
		  return signUpPage;
	  }
	  
	  
	  //Will Have all common methods for each page 
	  
}
