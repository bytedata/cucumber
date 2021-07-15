package com.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {
	WebDriver driver = null;
	LoginPage login;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("=====Inside login POM project=====");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		/*
		 * driver.findElement(By.id("name")).sendKeys(username);
		 * driver.findElement(By.id(password)).sendKeys(password);
		 */
		Thread.sleep(1000);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		login.clickLogin();
		// driver.findElement(By.id("login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		login.checkLogoutIsDisplayed();
		// driver.findElement(By.id("logout")).isDisplayed();

		driver.close();
		driver.quit();

	}

}
