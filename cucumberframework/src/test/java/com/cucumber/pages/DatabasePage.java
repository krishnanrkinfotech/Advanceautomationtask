package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class DatabasePage extends BaseClass {
	public  DatabasePage() {
		PageFactory.initElements(driver, this);
		
	}
	 @CacheLookup
	    @FindBy(xpath="(//a[normalize-space()='Log in'])[1]")
	     private WebElement login;
	    
	    @CacheLookup
	    @FindBy(xpath="(//input[@id='Email'])[1]")
	    private WebElement email;
	    @CacheLookup
	    @FindBy(xpath="(//input[@id='Password'])[1]")
	    private WebElement password;
	    @CacheLookup
	    @FindBy(xpath="(//button[normalize-space()='Log in'])[1]")
	    private WebElement click;
	    
	    public  WebElement getLogin() {
	    	return login;
	    }
	    public WebElement getEmail() {
	    	return email;
	    }
	    public WebElement getPassword() {
	    	return password;
	    }
	    public WebElement getClick() {
	    	return click;
	    }
}
