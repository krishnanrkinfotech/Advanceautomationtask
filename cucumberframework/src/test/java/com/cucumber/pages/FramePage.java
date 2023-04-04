package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class FramePage extends BaseClass {
	public FramePage() {
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup	
	@FindBy(xpath="//iframe[@src='page.xhtml']") 
	private WebElement frame1 ;
	@CacheLookup	
	@FindBy(xpath="//iframe[@id='frame2']") 
	private WebElement frame2 ;
	@CacheLookup	
	@FindBy(xpath="//button[@id='Click']") 
	private WebElement click ;

	public WebElement getFrame1() {
		return frame1;
	}
	public WebElement getFrame2() {
		return frame2;
	}
	public WebElement getFrameClick() {
		return click;
	}
}
