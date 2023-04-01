package com.cucumber.stepdefinitions;

import java.io.IOException;

import com.cucumber.pages.*;
import com.cucumber.utilities.*;
import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FrameHandling extends BaseClass {
	public static org.apache.log4j.Logger log = Logj.getLogger(FrameHandling.class);
	public static FramePage Frame1;

	@Given("user navigate to the frame handling application")
	public void user_navigate_to_the_frame_handling_application() throws IOException {
		launchedge();
		log.info("launch the browser");
		launchUrl(loadPropertyFile().getProperty("frameurl"));
		log.info("Get the Frameurl");
	}
	
	@Then("click on the frame")
	public void click_on_the_frame() {
		Frame1 = new FramePage();
		SelUtils.frameHandle(Frame1.getframe1(), Frame1.getframe2());
		SelUtils.performClick(Frame1.getframeclick());
		log.info("Handling the Frame");
		driver.switchTo().defaultContent();
	}

	@Then("Validate the frame")
	public void validate_the_frame() {
		
		System.out.println("Frame handled Sucessfully");
		log.info("Frame Handled successfully");

	}

	
	

}
