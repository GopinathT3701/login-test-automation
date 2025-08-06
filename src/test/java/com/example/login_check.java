package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

    public class login_check {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            Page page = browser.newPage();

            // Go to login page
			
			  page.navigate("https://dev-pdv2.c1exchange.com/login");
			  
			  // ✅ Valid login 
			  page.fill("//input[@formcontrolname='username']",
			  "c1x_publisher@yopmail.com");
			  page.fill("//input[@formcontrolname='password']", "Test@123");
			  page.click("//button[@data-pc-name='button']");
			  
			  page.waitForSelector("//button[@icon='pi pi-plus']", new
			  Page.WaitForSelectorOptions().setTimeout(5000));
			  
			  // Check if login is successful 
			  if
			  (page.isVisible("//button[@icon='pi pi-plus']")) {
			  System.out.println("✅ Login successful with valid credentials"); } else {
			  System.out.println("❌ Login failed with valid credentials"); }
			 
            // 🔁 Optional: Try invalid login
			
			  page.navigate("https://dev-pdv2.c1exchange.com/login"); 
			  page.fill("//input[@formcontrolname='username']", "c1x_publisher@yopmail.com");
	          page.fill("//input[@formcontrolname='password']", "Test@103");
	          page.click("//button[@data-pc-name='button']");
	          
				
	          Locator toast = page.locator("//div[contains(@class, 'p-toast-detail')]");

	          try {
	              // Wait up to 5 seconds for toast to appear
	              page.waitForSelector("//div[contains(@class, 'p-toast-detail')]",
	                  new Page.WaitForSelectorOptions()
	                      .setTimeout(7000)
	                      .setState(WaitForSelectorState.VISIBLE)
	              );

	              // If found and visible
	              if (toast.count() > 0 && toast.first().isVisible()) {
	                  System.out.println("✅Toast shown: " + toast.first().textContent());
	              } else {
	                  System.out.println("❌ No toast found after wait.");
	              }

	          } catch (PlaywrightException e) {
	              // Timeout reached or toast not found
	              System.out.println("❌ Toast did not appear within timeout.");
	          }			  
			  //playwright.close();
        }
    }