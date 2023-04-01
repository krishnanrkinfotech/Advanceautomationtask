package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class PetstorePage extends BaseClass{
	public PetstorePage() {
		PageFactory.initElements(driver, this);
		}

@CacheLookup	
@FindBy(xpath="(//a[normalize-space()='Sign In'])[1]") 
private WebElement signin ;
@CacheLookup	
@FindBy(xpath="(//label[normalize-space()='Username:'])[1]") 
private WebElement email1 ;
@CacheLookup	
@FindBy(xpath="(//input[@name='password'])[1]") 
private WebElement password1 ;

@CacheLookup	
@FindBy(xpath="(//button[normalize-space()='Login'])[1]") 
private WebElement login1 ;

public WebElement getsign() {
	return signin;
}

public WebElement getemail1() {
	return email1;
}
public WebElement getpassword1() {
	return password1;
}
public WebElement getclicklogin1() {
	return login1;
}
}