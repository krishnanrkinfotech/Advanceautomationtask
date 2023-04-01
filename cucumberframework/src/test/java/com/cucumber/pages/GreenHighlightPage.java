package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class GreenHighlightPage extends BaseClass {
	public GreenHighlightPage() {
		PageFactory.initElements(driver, this);
		}
	@CacheLookup	
	@FindBy(xpath="//input[@placeholder='Username']") 
	private WebElement username ;
	@CacheLookup	
	@FindBy(xpath="//input[@placeholder='Password']") 
	private WebElement password1 ;

	@CacheLookup	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	private WebElement login ;
	@CacheLookup	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']") 
	private WebElement green ;
	//@CacheLookup	
	//@FindBy(xpath="//a[normalize-space()='Remind Me Later']") 
	//private WebElement remind ;
	public WebElement getusername1() {
		return username;
	}
	public WebElement getpassword1() {
		return password1;
	}
	public WebElement getclicklogin() {
		return login;
	}
	public WebElement getgreen() {
		return green;
	}
	//public WebElement getremind() {
//		return remind;
	//}
	}


