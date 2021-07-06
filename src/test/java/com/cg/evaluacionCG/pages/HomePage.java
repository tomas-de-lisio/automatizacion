package com.cg.evaluacionCG.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage{
	/******Locators/Elements of the home page******/
	private By contactBtn = By.xpath("//a[@href=\"https://www.consultoriaglobal.com.ar/cgweb/?page_id=370\"]"); 
	
	public void clickContactBtn() throws Exception {
		if(this.isDisplayed(contactBtn)) {
			this.click(contactBtn);
			System.out.println("\nThe " + this.getText(contactBtn) + " button has been clicked.");
			Thread.sleep(100);
		}
	}
	
}
