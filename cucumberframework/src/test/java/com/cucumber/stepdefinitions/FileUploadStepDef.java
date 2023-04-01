package com.cucumber.stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;

import com.cucumber.pages.FileUploadPage;
import com.cucumber.utilities.*;
import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileUploadStepDef extends BaseClass {
	public static org.apache.log4j.Logger log = Logj.getLogger(FileUploadStepDef.class);
	public static FileUploadPage fileup;

	@Given("user navigate to the fileupload application")
	public void user_navigate_to_the_fileupload_application() throws IOException {
		launchChrome();
		log.info("Launch the Chrome");
		launchUrl(loadPropertyFile().getProperty("fileuploadurl"));
		log.info("Get the Fileuploadurl");
	}

	@When("user click on the choose file and upload")
	public void user_click_on_the_choose_file_and_upload() throws AWTException, IOException {
		fileup = new FileUploadPage();

		SelUtils.sendkeys(fileup.getchoosefile(), TestDataUtils.file, 1);
		log.info("Choose the File");
		// SelUtils.performClick(fileup.getchoosefile());
		// SelUtils.staticWait();
		// SelUtils.fileUpload();
		SelUtils.staticWait();

	}

	@When("click upload button")
	public void click_upload_button() {
		fileup = new FileUploadPage();
		SelUtils.performClick(fileup.getupload());
		log.info("click on the upload button");
		SelUtils.staticWait();
	}

	@Then("File upload should be successfully")
	public void file_upload_should_be_successfully() {
		log.info("File upload is successfully");

		System.out.println("File upload is successfully");

	}
}
