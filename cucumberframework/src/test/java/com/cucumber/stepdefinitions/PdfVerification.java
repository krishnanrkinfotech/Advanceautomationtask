package com.cucumber.stepdefinitions;

import java.io.IOException;

import com.cucumber.utilities.*;
import com.cucumber.base.BaseClass;
import com.cucumber.base.Logj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PdfVerification extends BaseClass {
	public static org.apache.log4j.Logger log = Logj.getLogger(PdfVerification.class);

	@Given("Validate the PDF  and assert the sucessfully")
	public void Validate_the_pdf_and_assert_the_sucessfully() throws IOException, Exception {
		SelUtils.pdfReaderTest(loadPropertyFile().getProperty("pdfurl"));
		log.info("Get the pdfurl");
	}

	@Then("Validate the  extract image from pdf")
	public void Validate_the_extract_image_from_pdf() throws IOException {
		SelUtils.imageextpdf(TestDataUtils.location, TestDataUtils.pdfloc);
		log.info("Image extracted from the PDF");
		System.out.println("Image extracted from the Pdf successfully");
	}

}
