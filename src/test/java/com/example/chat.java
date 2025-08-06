package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class chat {

	public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        {
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setChannel("chrome")
            );
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://qa-remedi.c1exchange.com/login");
            Thread.sleep(1000);

            page.getByRole(AriaRole.COMBOBOX).selectOption("en");
            Thread.sleep(1000);

            page.locator("//input[@placeholder='Email']").fill("lukeclinic@yopmail.com");
            Thread.sleep(2000);

            page.locator("//input[@placeholder='Password']").fill("lukeclinic");
            Thread.sleep(2000);

            page.getByRole(AriaRole.BUTTON).first().click();
            Thread.sleep(2500);

            page.locator("//button[contains(@class, \"rounded-md\")]").click();
            Thread.sleep(2000);
            
            page.locator("//div[@class='flex-1']//p[contains(text(), 'Leo')]").click();
            Thread.sleep(2000);
            
            page.locator("//div[@class=\"attachment-toggle flex flex-row gap-4 p-4 items-center relative\"]").click();
            Thread.sleep(2000);
           
            page.locator("//span[text()='Add Appointments']").click();
            Thread.sleep(2000);

        }
    }
}