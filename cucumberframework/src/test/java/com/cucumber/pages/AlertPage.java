package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class AlertPage extends BaseClass {
	public  AlertPage() {
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup	
    @FindBy(xpath="//button[@id='accept']") 
	private WebElement simple ;
	@CacheLookup	
    @FindBy(xpath="//button[@id='confirm']") 
	private WebElement confirm ;
	@CacheLookup	
    @FindBy(xpath="//button[@id='prompt']") 
	private WebElement prompt ;
	
	public WebElement getsimple() {
		return simple;
	}
	public WebElement getconfirm() {
		return confirm;
	}
	public WebElement getprompt() {
		return prompt;
	} 
}


