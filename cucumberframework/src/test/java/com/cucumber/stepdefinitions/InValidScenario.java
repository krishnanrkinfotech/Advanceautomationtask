package com.cucumber.stepdefinitions;

import java.io.IOException;


import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;
import com.cucumber.pages.*;
import com.cucumber.utilities.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class InValidScenario extends BaseClass{
	public static org.apache.log4j.Logger log = Logj.getLogger(InValidScenario.class);
	public static RedHighlightPage red;
	 @Given("user navigate to the salesforce application")
	public void user_navigate_to_the_salesforce_application() throws IOException {
	    launchChrome();
	    log.info("Launch the Chrome");
	    launchUrl(loadPropertyFile().getProperty("saleurl"));
	}

	@When("enter the username and Password")
	public void enter_the_username_and_password() throws IOException {
	  red= new RedHighlightPage();
	  SelUtils.sendkeys(red.getusername1(), loadPropertyFile().getProperty("username"),1);
	  SelUtils.sendkeys(red.getpassword(),loadPropertyFile().getProperty("Password"),2);
	  SelUtils.staticWait();
	  log.info("Pass the username and Password");
	}

	@Then("click on the Login Button")
	public void click_on_the_login_button() {
	   SelUtils.performClick(red.getclicklogin());
	   log.info("Click on the Login Button");
	   SelUtils.staticWait();
	   SelUtils.redHighLight(red.geterr());
	   log.info("Pointed out the error successfully in red color");
	   System.out.println("Pointed out the error successfully");
	}
	
	@Then("Highlight the error Message")
	public void highlight_the_error_Message() {
		 SelUtils.redHighLight(red.geterr());
		   log.info("Pointed out the error successfully in red color");
		   System.out.println("Pointed out the error successfully");
	}



}
