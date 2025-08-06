package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class brows {
  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false).setChannel("chrome"));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://dev-pdv2.c1exchange.com/login");
      page.getByPlaceholder("Username").fill("c1x_publisher@yopmail.com");
     
      page.getByPlaceholder("Password").fill("Test@123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
      page.locator("//a[.//span[text()='Inventory']]").hover();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Sites")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add a New Site")).click();
      page.locator("input[name=\"name\"]").click();
      page.locator("input[name=\"name\"]").fill("facebook");
      page.locator("input[name=\"domain\"]").click();
      page.locator("input[name=\"domain\"]").fill("https://www.google.com");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Categories")).click();
      page.getByLabel("Science", new Page.GetByLabelOptions().setExact(true)).locator("div").nth(2).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Done")).click();
      page.locator("textarea[name=\"description\"]").click();
      page.locator("textarea[name=\"description\"]").fill("desc");
      page.locator("input[name=\"dmaOrZipCode\"]").click();
      page.locator("input[name=\"dmaOrZipCode\"]").fill("987654");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
      
      
    }
  }

