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
	@Given("User login to the orange application")
	public void User_login_to_the_orange_application() throws IOException {
	    launchChrome();
	    log.info("Launch the Chrome");
	    launchUrl(loadPropertyFile().getProperty("orangeurl"));
	}
	@When("Enter the valid  username and valid  Password")
	public void Enter_the_valid_username_and_valid_password() throws IOException, ParseException {
	  green = new GreenHighlightPage();
	  SelUtils.staticWait();
	  //SelUtils.sendkeys(green.getusername1(), loadPropertyFile().getProperty("username1"),1);
	 // SelUtils.sendkeys(green.getpassword1(), loadPropertyFile().getProperty("password1"),1);
	  SelUtils.sendkeys(green.getUsername1(), SelUtils.readJsonData("userName"),1);
	  SelUtils.sendkeys(green.getPassword1(), SelUtils.readJsonData("password"),1);
	  SelUtils.staticWait();
	  log.info("Pass the username and Password");
	}

	@Then("Click on the Login button and navigate to homepage")
	public void Click_on_the_login_button_and_navigate_to_homepage() {
		 green = new GreenHighlightPage();
		SelUtils.performClick(green.getClickLogin());
		SelUtils.staticWait();
		//SelUtils.performClick(green.getremind());
	
	}
	@Then("Highlight the success message in the name of dashboard")
	public void highlight_the_success_message_in_the_name_of_dashboard() {
		SelUtils.staticWait();
		SelUtils.greenHighLight(green.getGreen());
		System.out.println("Green highlighted successfully in the Dashboard");
		   log.info("Pointed out the Green highlighted successfully ingreencolor");

	}

}
