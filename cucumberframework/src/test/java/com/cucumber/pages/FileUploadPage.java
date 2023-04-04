package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.base.BaseClass;

public class FileUploadPage extends BaseClass {
	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}
	 @CacheLookup
	    @FindBy(xpath="//input[@id='file-upload']")
	     private WebElement choosefile;
	    
	    @CacheLookup
	    @FindBy(xpath="//input[@id='file-submit']")
	    private WebElement upload;
	    public  WebElement getChooseFile() {
	    	return choosefile;
	    }
	    public WebElement getUpload() {
	    	return upload;
	    }
}
