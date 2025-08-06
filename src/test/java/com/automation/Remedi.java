package com.automation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Remedi {
    @SuppressWarnings("deprecation")
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
            Thread.sleep(1000);

            page.locator("//input[@placeholder='Password']").fill("lukeclinic");
            Thread.sleep(1000);

            page.getByRole(AriaRole.BUTTON).first().click();
            Thread.sleep(1500);

            page.locator("//button[contains(@class, \"rounded-md\")]").click();
            Thread.sleep(3000);

            page.locator("//a[@href=\"/clinic/doctors\"]").click();
            Thread.sleep(1500);

            page.locator("//a[@href=\"/clinic/appointments\"]").click();
            Thread.sleep(1500);

            page.locator("//button[contains(@class,'bg-white border')]").click();
            Thread.sleep(1000);

            page.locator("//span[@class='text-sm text-gray-700 ml-2' and text()='Completed']").click();
            Thread.sleep(1000);

            page.locator("//button[contains(@class, 'px-3 py-1') and contains(text(), 'Apply')]").click();
            Thread.sleep(1500);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter")).click();
            Thread.sleep(1000);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
            Thread.sleep(1500);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Patients")).click();
            Thread.sleep(1500);

            page.getByText("View Chat").first().click();
            Thread.sleep(2000);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Payments")).click();
            Thread.sleep(1500);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Refunds")).click();
            Thread.sleep(1500);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Settings")).click();
            Thread.sleep(1500);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
            Thread.sleep(1000);

            Locator address2 = page.getByPlaceholder("Address Line 1");
            address2.fill(""); // clear
            address2.type("tokyo", new Locator.TypeOptions().setDelay(100));
            Thread.sleep(1000);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();
            Thread.sleep(2000);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Settings")).click();
            Thread.sleep(1000);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Overview")).click();
            Thread.sleep(1000);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Luke clinic CLINIC")).click();
            Thread.sleep(1000);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
        }
    }
}
