package com.cucumber.stepdefinitions;

import com.cucumber.base.BaseClass;
import com.cucumber.utilities.EmailUtils;

import io.cucumber.java.en.Given;

public class EmailSending extends BaseClass{
	
	@Given("Verify that the email send to the recipient or not")
	public void Verify_that_the_email_send_to_the_recipient_or_not() {
		EmailUtils.SendMail();
		System.out.println("Email sending sucessfully");
	}

}
