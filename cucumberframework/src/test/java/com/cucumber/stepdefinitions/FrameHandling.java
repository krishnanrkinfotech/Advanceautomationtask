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

	@Given("User navigate to the frame handling application")
	public void User_navigate_to_the_frame_handling_application() throws IOException {
		launchEdge();
		log.info("launch the browser");
		launchUrl(loadPropertyFile().getProperty("frameUrl"));
		log.info("Get the Frameurl");
	}
	
	@Then("Click on the frame")
	public void Click_on_the_frame() {
		Frame1 = new FramePage();
		SelUtils.frameHandle(Frame1.getFrame1(), Frame1.getFrame2());
		SelUtils.performClick(Frame1.getFrameClick());
		log.info("Handling the Frame");
		driver.switchTo().defaultContent();
	}

	@Then("Validate the frame")
	public void validate_the_frame() {
		
		System.out.println("Frame handled Sucessfully");
		log.info("Frame Handled successfully");

	}

	
	

}
