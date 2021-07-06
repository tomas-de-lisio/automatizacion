package com.cg.evaluacionCG.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ContactPage extends BasePage{
/******Locators/Elements of the contact page******/
private By emailTextBox = By.xpath("//input[@type=\"email\"]"); 
private By sendBtn = By.xpath("//input[@type=\"submit\"]");
private By invalidMsg = By.xpath("//span[@role=\"alert\"]");
private By nameTextBox = By.xpath("//input[@type=\"text\"][@name=\"your-name\"]");
private By subjectTextBox = By.xpath("//input[@type=\"text\"][@name=\"your-subject\"]");
private By messageTextBox = By.xpath("//textarea[@name=\"your-message\"]");
private By captcha = By.xpath("//img[@class=\"wpcf7-form-control wpcf7-captchac wpcf7-captcha-captcha-636\"]");
private By captchaTextBox = By.xpath("//input[@name=\"captcha-636\"]");

/******Necessary variables******/
private final String INVALID_EMAIL = "helloWorld";
private final String NAME = "Tomas Augusto";
private final String SUBJECT = "hola";
private final String ADDITIONAL_MESSAGE = "hola";
private File src;

	public void typeName() throws Exception {
		if(this.isDisplayed(this.nameTextBox)) {
			this.type(NAME, nameTextBox);
			System.out.println("\nThe " + this.getText(nameTextBox) + " text box has been filled with " + NAME);
			Thread.sleep(1000);
		}
	}
	
	public void typeEmail() throws Exception {
		if(this.isDisplayed(this.emailTextBox)) {
			this.type(INVALID_EMAIL, emailTextBox);
			System.out.println("\nThe " + this.getText(emailTextBox) + " text box has been filled with " + INVALID_EMAIL);
			Thread.sleep(1000);
		}
	}
	
	public void typeSubject() throws Exception {
		if(this.isDisplayed(this.subjectTextBox)) {
			this.type(SUBJECT, subjectTextBox);
			System.out.println("\nThe " + this.getText(subjectTextBox) + " text box has been filled with " + SUBJECT);
			Thread.sleep(1000);
		}
	}
	
	public void typeMessage() throws Exception {
		if(this.isDisplayed(this.messageTextBox)) {
			this.type(ADDITIONAL_MESSAGE, messageTextBox);
			System.out.println("\nThe " + this.getText(messageTextBox) + " text box has been filled with " + ADDITIONAL_MESSAGE);
			Thread.sleep(1000);
		}
	}
	
	public void typeCaptchaText() throws Exception {
		if(this.isDisplayed(this.captcha)) {
			var inputCaptcha = this.getCaptchaText(src, captcha);
			this.type(inputCaptcha, captchaTextBox);
			System.out.println("\nThe " + this.getText(captchaTextBox) + " text box has been filled with " + inputCaptcha);
			Thread.sleep(1000);
		}
	}
	
	public void clickSendBtn() throws Exception {
		if(this.isDisplayed(this.sendBtn)) {
			//this.scrollToElement(sendBtn);
			this.click(sendBtn);
			System.out.println("\nThe " + this.getText(sendBtn) + " button has been clicked.");
			Thread.sleep(10000);
		}
	}
	
	public String getMessage() {
		if(this.isDisplayed(this.invalidMsg)) {
			var outPut = this.findElement(invalidMsg);
			return this.getText(outPut);
		}else {
			return null;
		}
	}

}
