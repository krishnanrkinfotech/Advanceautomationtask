package com.cucumber.stepdefinitions;

import java.io.IOException;

import com.cucumber.base.BaseClass;
import com.cucumber.pages.PetStorePage;

import com.cucumber.utilities.ExcelUtils;
import com.cucumber.utilities.SelUtils;
import com.cucumber.utilities.TestDataUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PetstoreExcel extends BaseClass {
	public PetStorePage pd;
	@Given("User login to the petstore application")
	public void User_login_to_the_petstore_application() throws IOException {
		pd= new PetStorePage();
	 launchChrome();
	 launchUrl(loadPropertyFile().getProperty("peturl"));
	 SelUtils.staticWait();
	// SelUtils.performClick(pd.getsign());
	}

	@When("Enter the valid  username and valid  Password through excel")
	public void Enter_the_valid_username_and_valid_Password_through_excel() throws IOException {
		pd= new PetStorePage();
		//SelUtils.staticWait();
		//ExcelUtils.readData(TestDataUtils.sheetname, TestDataUtils.testid1,TestDataUtils.username);
		SelUtils.sendkeys(pd.getEmail1(),ExcelUtils.readData(TestDataUtils.sheetname, TestDataUtils.testid1,TestDataUtils.username),2);
		SelUtils.staticWait();
		
		SelUtils.sendkeys(pd.getPassword1(),ExcelUtils.readData(TestDataUtils.sheetname, TestDataUtils.testid1,TestDataUtils.password), 2);
		//SelUtils.staticWait();
		SelUtils.performClick(pd.getClickLogin1());
	}

	@Then("Click  Login button and navigate to homepage")
	public void Click_Login_button_and_navigate_to_homepage() {
		pd= new PetStorePage();
System.out.println("Excel Page");
	}
}
