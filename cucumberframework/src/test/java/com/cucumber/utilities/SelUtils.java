package com.cucumber.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
//import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.base.BaseClass;

import com.testautomationguru.utility.PDFUtil;

public class SelUtils extends BaseClass {

	public static void sendkeys(WebElement a, String value, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(a));
		// until(ExpectedConditions.visibilityOf(e));
		a.sendKeys(value);
	}

//	public static void click(WebElement m) {
//		
//		m.click();
//	}
	public static void performClick(WebElement b) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", b);

//		JavascriptExecutor js = (JavascriptExecutor) sdriver; 
//		js.executeScript("arguments[0].click()", b); 

	}

	public static void staticWait() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void fileUpload() throws AWTException {

		Robot robot = new Robot();

		StringSelection fileCopy = new StringSelection(TestDataUtils.file);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileCopy, null);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public Properties loadPropertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				"src\\test\\resources\\PropertiesFile\\config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

	public static void alertaccept() {
		Alert acceptalert = driver.switchTo().alert();
		String text = acceptalert.getText();
		System.out.println("System is in alertaccept" + text);
		acceptalert.accept();

	}

	public static void alertdismiss() {
		Alert dismissalert = driver.switchTo().alert();
		String text1 = dismissalert.getText();
		System.out.println("System is in alertdismiss" + text1);
		dismissalert.dismiss();

	}

	public static void alertgettext(String value) {
		Alert promptalert = driver.switchTo().alert();
		promptalert.sendKeys(value);

	}

	public static void frameHandle(WebElement d, WebElement e) {
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		int framecount = iframe.size();
		System.out.println("Framecount" + framecount);
		driver.switchTo().frame(d);
		driver.switchTo().frame(e);
	}

	public static void redHighLight(WebElement highlight) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:red;border:2px black');", highlight);
	}

	public static void greenHighLight(WebElement highlight) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:green;border:2px black');", highlight);
	}

	public static void pdfReaderTest(String file) throws Exception {

		URL pdfUrl = new URL(file);
		URLConnection urlConnection = pdfUrl.openConnection();
		urlConnection.addRequestProperty("User-Agent", "Mozilla");

		InputStream ip = urlConnection.getInputStream();
		BufferedInputStream bf = new BufferedInputStream(ip);
		PDDocument pdDocument = PDDocument.load(bf);

		// page count:
		int pageCount = pdDocument.getNumberOfPages();
		System.out.println("pdf page: " + pageCount);
		Assert.assertEquals(pageCount, 17);

		System.out.println("========================pdf content===============");
		// full pdf page content/text:
		PDFTextStripper pdfStiper = new PDFTextStripper();
		String pdfText = pdfStiper.getText(pdDocument);
		System.out.println(pdfText);
		Assert.assertTrue(pdfText.contains("SoapUI CI/CD "));
		Assert.assertTrue(pdfText.contains("API Testing using POSTMAN"));

	}

	public static void imageextpdf(String location, String pdfloc) throws IOException {
		// String location="F:\\images";
		// String
		// pdfloc="F:\\Rk_Latest\\Downloads\\Salesforce_Municipal_Lightning_User_Guide_v2.pdf";
		PDFUtil pdfutil = new PDFUtil();
		pdfutil.setImageDestinationPath(location);
		pdfutil.extractImages(pdfloc);

	}

	public static void windows(String parentwindow) {
		Set<String> allwin = driver.getWindowHandles();
		System.out.println(allwin);
		for (String handles : allwin) {
			if (!parentwindow.equals(allwin)) {
				driver.switchTo().window(handles);
				System.out.println("inside childwindow");
			}
		}

	}

	public static String readJsonData(Object users) throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(new FileReader(TestDataUtils.jsonpath));
		String users1 = (String) jsonObj.get(users);
		return users1;

	}

}
