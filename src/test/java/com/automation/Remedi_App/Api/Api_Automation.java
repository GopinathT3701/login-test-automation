package com.automation.Remedi_App.Api;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class Api_Automation {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      // Create API request context
      APIRequestContext api = playwright.request().newContext();

      // Send POST request
      APIResponse response = api.post("http://34.83.188.128:4000/auth/login",
        RequestOptions.create()
          .setHeader("Content-Type", "application/json")
          .setData("{ \"email\": \"denjiclinic@yopmail.com\", \"password\": \"denjiclinic\" }")
      );

      // Check response status
      if (response.status() == 201) {
        System.out.println("✅ Login Passed");
      } else {
        System.out.println("❌ Login Failed. Status: " + response.status());
      }

      // Print response body
      System.out.println("Response: " + response.text());
    }
  }
}
