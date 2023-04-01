package com.cucumber.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	// public static Properties properties;

	@Before
	public static WebDriver launchChrome() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		// option.addArguments("--headless=new");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		return driver;

	}

	public static WebDriver launchedge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	public Properties loadPropertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				"src\\test\\resources\\PropertiesFile\\config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}
	@After

	public void tearDown(Scenario scenario) {

		try {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			if (scenario.isFailed()) {
				//scenario.log("this is my failure message");
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenshotName);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

	

	public static void closeBrowser() {
		driver.quit();
	}

}
