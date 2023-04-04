package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class RedHighlightPage extends BaseClass{
	public RedHighlightPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup	
	@FindBy(xpath="//input[@id='username']") 
	private WebElement username ;
	@CacheLookup	
	@FindBy(xpath="//input[@id='password']") 
	private WebElement password ;

	@CacheLookup	
	@FindBy(xpath="//input[@id='Login']") 
	private WebElement login ;
	@CacheLookup	
	@FindBy(xpath="(//div[@id='error'])[1]") 
	private WebElement error ;

	public WebElement getUsername1() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getClickLogin() {
		return login;
	}
	public WebElement getErr() {
		return error;
	}
}
