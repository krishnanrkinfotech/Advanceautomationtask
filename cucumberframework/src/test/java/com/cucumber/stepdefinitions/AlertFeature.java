package com.cucumber.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
//import org.slf4j.Logger;

import com.cucumber.pages.AlertPage;
import com.cucumber.utilities.SelUtils;
import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AlertFeature extends BaseClass {

	public static org.apache.log4j.Logger log = Logj.getLogger(AlertFeature.class);

	public static AlertPage alerts1;

	@Given("User should be navigated to letcode alerts")
	public void User_should_be_navigated_to_letcode_alerts() throws IOException {

		launchChrome();
		log.info("Launching chrome");
		launchUrl(loadPropertyFile().getProperty("alertUrl"));
	}

	@When("I Click simple alert and handle it")
	public void i_Click_simple_alert_and_handle_it() {
		alerts1 = new AlertPage();

		// driver.findElement(By.xpath("//button[@id='accept']")).click();
		SelUtils.performClick(alerts1.getSimple());
		// SelUtils.click(alerts1.getsimple());

		SelUtils.staticWait();
		SelUtils.alertaccept();
		System.out.println("System is in simple  Alert");
		log.info("simple alert");
	}

	@When("I Click the confirm and dismiss it")
	public void i_Click_the_confirm_and_dismiss_it() {
		alerts1 = new AlertPage();
		SelUtils.performClick(alerts1.getConfirm());

		SelUtils.staticWait();
		SelUtils.alertdismiss();
		SelUtils.staticWait();
		System.out.println("System is in Dismiss the alert");
		log.info("confirm  alert");
	}

	@When("I Click the prompt alert")
	public void i_Click_the_prompt_alert() {
		alerts1 = new AlertPage();
		SelUtils.performClick(alerts1.getPrompt());
		// SelUtils.staticWait();
		SelUtils.alertgettext("rk");
		SelUtils.alertaccept();
		SelUtils.staticWait();
		String name = driver.findElement(By.id("myName")).getText();
		System.out.println("Prompt alert" + name);
		log.info("Prompt alert");

		// driver.findElement(By.xpath("//p[@id='myName']")

	}

}
