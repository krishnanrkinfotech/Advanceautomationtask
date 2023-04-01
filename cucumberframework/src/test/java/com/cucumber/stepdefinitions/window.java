package com.cucumber.stepdefinitions;

import java.io.IOException;

import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;
import com.cucumber.pages.*;
import com.cucumber.utilities.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class window extends BaseClass {
	public static org.apache.log4j.Logger log = Logj.getLogger(window.class);
	public static SelWindowsPage win;

	@Given("user should be navigated to letcode windows handling application.")
	public void user_should_be_navigated_to_letcode_windows_handling_application() throws IOException {
		launchChrome();
		log.info("Launch the Chrome");
		launchUrl(loadPropertyFile().getProperty("winurl"));
	}

	@Then("validate the windows Functionality")

	public void validate_the_windows_functionality() {
		win = new SelWindowsPage();
		String parentwin = driver.getWindowHandle();
		SelUtils.performClick(win.getopen());
		log.info("window open");
		SelUtils.windows(parentwin);
		log.info("Parentwindow");
		SelUtils.performClick(win.getclick());
		driver.switchTo().window(parentwin);
		log.info("Windows Validated Successfully");
		System.out.println("windows validated successfully");

	}
}
