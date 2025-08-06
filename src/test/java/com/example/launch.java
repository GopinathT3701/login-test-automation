package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class launch {
	
	public static void main(String args[] ) {
		Playwright playwright = Playwright.create();
		
		Browser browser=playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
				);
		
		
		Page page=browser.newPage();
		
		page.navigate("https://dev-pdv2.c1exchange.com/login");
		
		//page.locator("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		

		
		page.locator("//input[@formcontrolname='username']").fill("c1x_publisher@yopmail.com");
		
		page.locator("//input[@formcontrolname='password']").fill("Test@123");
		
		page.locator("//button[@data-pc-name='button']").click();
		
		page.locator("//a[.//span[text()='Inventory']]").hover();
		
		page.click("//span[text()='Ad Units']");
		
		page.click("// button[@label='Add a New Adunits']");
		
		
		
		page.locator("#name").fill("Advertiser");
		
		page.locator("#extName").fill("c1x");
		
		page.click("//span[@aria-label='Select Network' ]");
		
		page.click("//li[@aria-posinset='1'  and  @role=\"option\" ]");
		
		page.click("//span[@role='combobox' and @aria-label='Select Site' ]");
		
		page.click("//li[@aria-label='DTest']");
		
		page.click("//span[@aria-label='Select Type']");
		
		page.click("#adUnitType_1");
		
		page.fill("#size", "govindha");
		
		page.fill("#externalId", "987654");
		
		page.click("//button[@data-pc-section='root']");
		
		//page.locator("//li[@id='pn_id_1078_0']").click();
		
		String title =page.title();
		
		
		System.out.println("Page title:" + title);
		//System.out.println("Page Url:" + uri);
		
		
		/*
		 * page.close();
		 * 
		 * browser.close();
		 */
		 //playwright.close();
		 
	
	
	}

}
