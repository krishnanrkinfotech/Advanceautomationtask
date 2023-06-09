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
	@FindBy(xpath="(//input[@placeholder='Username'])[1]") 
	private WebElement username ;
	@CacheLookup	
	@FindBy(xpath="(//input[@placeholder='Password'])[1]") 
	private WebElement password1 ;

	@CacheLookup	
	@FindBy(xpath="(//button[normalize-space()='Login'])[1]") 
	private WebElement login ;
	@CacheLookup	
	@FindBy(xpath="(//span[@class='oxd-userdropdown-tab'])[1]") 
	private WebElement green ;
	//@CacheLookup	
	//@FindBy(xpath="//a[normalize-space()='Remind Me Later']") 
	//private WebElement remind ;
	public WebElement getUsername1() {
		return username;
	}
	public WebElement getPassword1() {
		return password1;
	}
	public WebElement getClickLogin() {
		return login;
	}
	public WebElement getGreen() {
		return green;
	}
	//public WebElement getremind() {
//		return remind;
	//}
	}


