package com.cucumber.stepdefinitions;

import java.io.IOException;

import com.cucumber.base.BaseClass;
import com.cucumber.pages.PetstorePage;
import com.cucumber.utilities.ExcelUtils;
import com.cucumber.utilities.SelUtils;
import com.cucumber.utilities.TestDataUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PetstoreExcel extends BaseClass {
	public PetstorePage pd;
	@Given("user login to the petstore application")
	public void user_login_to_the_petstore_application() throws IOException {
		pd= new PetstorePage();
	 launchChrome();
	 launchUrl(loadPropertyFile().getProperty("peturl"));
	 SelUtils.staticWait();
	// SelUtils.performClick(pd.getsign());
	}

	@When("enter the valid  username and valid  Password through excel")
	public void enter_the_valid_username_and_valid_Password_through_excel() throws IOException {
		pd= new PetstorePage();
		//SelUtils.staticWait();
		//ExcelUtils.readData(TestDataUtils.sheetname, TestDataUtils.testid1,TestDataUtils.username);
		SelUtils.sendkeys(pd.getemail1(),ExcelUtils.readData(TestDataUtils.sheetname, TestDataUtils.testid1,TestDataUtils.username),2);
		SelUtils.staticWait();
		
		SelUtils.sendkeys(pd.getpassword1(),ExcelUtils.readData(TestDataUtils.sheetname, TestDataUtils.testid1,TestDataUtils.password), 2);
		//SelUtils.staticWait();
		SelUtils.performClick(pd.getclicklogin1());
	}

	@Then("click  Login button and navigate to homepage")
	public void click_Login_button_and_navigate_to_homepage() {
		pd= new PetstorePage();
System.out.println("Excel Page");
	}
}
