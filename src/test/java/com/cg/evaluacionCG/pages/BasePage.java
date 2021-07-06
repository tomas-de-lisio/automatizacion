package com.cg.evaluacionCG.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.evaluacionCG.reports.Reports;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Component
public class BasePage {
	@Autowired
	private WebDriver driver;
	
	public void navigateTo(String url) throws Exception{
		try {
			Reports.log("Test de navegacion");
			driver.get(url);
			Thread.sleep(1000);
			Reports.logPass();
		}catch(Exception e) {
			Reports.logFail();
			throw new Exception("Navigation to " + url + " failed.");			
		}
	}
	
	public WebElement findElement(By element) {
		return driver.findElement(element);
	}
	
	public List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By element) {
		return driver.findElement(element).getText();
	}
	
	public void type(String inputText, By element) throws Exception {
		try {
			Reports.log("Test de escritura");
			driver.findElement(element).sendKeys(inputText);
			Reports.logPass();
		}catch(Exception e) {
			Reports.logFail();
			throw new Exception("The t could not be filled on: " + element + " with " + inputText);
		}
	}
	
	public void click(By element) throws Exception {
		try {
			Reports.log("Test de click");
			driver.findElement(element).click();
			Reports.logPass();
		}catch(Exception e) {
			Reports.logFail();
			throw new Exception("The button could not be clicked on: " + getText(element));
		}
	}
	
	public Boolean isDisplayed(By element) {
		try {
			return driver.findElement(element).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
		}
	}
	
	public void scrollToElement(By elemento) {
		WebElement element = driver.findElement(elemento);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public String getCaptchaText(File src, By element) throws IOException, TesseractException {
		src = driver.findElement(element).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/captcha.png";
		
		FileHandler.copy(src, new File(path));
		
		ITesseract image = new Tesseract();
		
		String imageText = image.doOCR(new File(path));
		
		return imageText;
	}	
}


