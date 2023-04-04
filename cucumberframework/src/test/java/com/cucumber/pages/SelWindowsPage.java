package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class SelWindowsPage extends BaseClass{
	public  SelWindowsPage() {
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup	
    @FindBy(xpath="(//button[text()='Open Home Page'])[1]") 
	private WebElement open ;
	@CacheLookup	
    @FindBy(xpath="//a[normalize-space()='Click']") 
	private WebElement click ;
	
	//a[normalize-space()='Click']
	public WebElement getOpen() {
		return open;
	}
	public WebElement getClick() {
		return click;
	}
}

