package com.cg.evaluacionCG;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.evaluacionCG.pages.BasePage;
import com.cg.evaluacionCG.pages.ContactPage;
import com.cg.evaluacionCG.pages.HomePage;
import com.cg.evaluacionCG.reports.Reports;

@SpringBootTest
class EvaluacionCgApplicationTests {
	private final String URL = "https://www.consultoriaglobal.com.ar/cgweb/";  

	@Autowired
	BasePage basePage;
	@Autowired
	HomePage homePage;
	@Autowired
	ContactPage contactPage;

	@Test
	void navigate() throws Exception {

		basePage.navigateTo(URL);
		
		homePage.clickContactBtn();
		
		contactPage.typeName();
		
		contactPage.typeEmail();		
		
		contactPage.typeSubject();
		
		contactPage.typeMessage();	
		
		contactPage.typeCaptchaText();
		
//		contactPage.clickSendBtn(); 
		
		System.out.println("\nERROR: " + contactPage.getMessage());
		
		Reports.finish();	
	}

}
