package com.cucumber.stepdefinitions;

import java.io.IOException;
import java.sql.ResultSet;

//import org.openqa.selenium.By;

import com.cucumber.base.BaseClass;
import com.cucumber.pages.DatabasePage;
import com.cucumber.utilities.DatabaseUtils;
import com.cucumber.utilities.SelUtils;
//import com.cucumber.utilities.TestDataUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DatabaseVerification extends BaseClass {
	public DatabasePage db;
	@Given("Launch the url")
	public void launch_the_url() throws IOException, InterruptedException {
		 launchChrome();
		   launchUrl(loadPropertyFile().getProperty("dburl"));
		  Thread.sleep(2000);
	}
	
	    
	@Then("Validate the database functionality")
	public void validate_the_database_functionality() throws IOException, InterruptedException {
		db=new DatabasePage();
	   
	   DatabaseUtils testdb = new DatabaseUtils();
	   try
       {   
           @SuppressWarnings("static-access")
		ResultSet testData =testdb.data("","");

        
                        
               String email = testData.getString("email");
               String password = testData.getString("password");           

               System.out.println(email);
               System.out.println(password);
               //driver.findElement(By.xpath("(//a[normalize-space()='Log in'])[1]")).click();
               SelUtils.performClick(db.getLogin());
              // driver.findElement(By.xpath(TestDataUtils.emailxpath)).sendKeys(email);
               SelUtils.sendkeys(db.getEmail(), email, 2);
               SelUtils.sendkeys(db.getPassword(), password, 2);
               Thread.sleep(2000);
               SelUtils.performClick(db.getClick());
           }
              // driver.findElement(By.id("u_0_e")).clear();
              // driver.findElement(By.id("u_0_e")).sendKeys(firstName);
              // driver.findElement(By.id("u_0_g")).clear();
              // driver.findElement(By.id("u_0_g")).sendKeys(lastName);
           
       
       catch (Exception e)
       {
           e.printStackTrace();
       }
	}

       }
	
