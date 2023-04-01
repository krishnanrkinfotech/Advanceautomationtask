package com.cucumber.stepdefinitions;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;
import com.cucumber.pages.*;
import com.cucumber.utilities.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ValidScenario extends BaseClass{
	public static org.apache.log4j.Logger log = Logj.getLogger(ValidScenario.class);
	public static GreenHighlightPage green;
	@Given("user login to the orange application")
	public void user_login_to_the_orange_application() throws IOException {
	    launchChrome();
	    log.info("Launch the Chrome");
	    launchUrl(loadPropertyFile().getProperty("orangeurl"));
	}
	@When("enter the valid  username and valid  Password")
	public void enter_the_valid_username_and_valid_password() throws IOException, ParseException {
	  green = new GreenHighlightPage();
	  SelUtils.staticWait();
	  //SelUtils.sendkeys(green.getusername1(), loadPropertyFile().getProperty("username1"),1);
	 // SelUtils.sendkeys(green.getpassword1(), loadPropertyFile().getProperty("password1"),1);
	  SelUtils.sendkeys(green.getusername1(), SelUtils.readJsonData("username"),1);
	  SelUtils.sendkeys(green.getpassword1(), SelUtils.readJsonData("password"),1);
	  SelUtils.staticWait();
	  log.info("Pass the username and Password");
	}

	@Then("click on the Login button and navigate to homepage")
	public void click_on_the_login_button_and_navigate_to_homepage() {
		 green = new GreenHighlightPage();
		SelUtils.performClick(green.getclicklogin());
		SelUtils.staticWait();
		//SelUtils.performClick(green.getremind());
	
	}
	@Then("Highlight the success message in the name of dashboard")
	public void highlight_the_success_message_in_the_name_of_dashboard() {
		SelUtils.staticWait();
		SelUtils.greenHighLight(green.getgreen());
		System.out.println("Green highlighted successfully in the Dashboard");
		   log.info("Pointed out the Green highlighted successfully ingreencolor");

	}

}
