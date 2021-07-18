package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pagefactory.HomepagePageFactory;
import com.pagefactory.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;
	LoginPage login;

	HomepagePageFactory factory;

	@Given("browser is open")
	public void browserIsOpen() {
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@And("user is on login page")
	public void userOnLoginPage() {
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void userEntersUsernameAndPassword(String username, String password) throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		Thread.sleep(1000);
	}

	@And("user clicks on login")
	public void userClicksOnLogin() {
		login.clickOnLogin();
	}

	@Then("user is navigated to the home page")
	public void userIsNavigatedToTheHomePage() {
		factory = new HomepagePageFactory(driver);
		factory.checkLogOutIsDisplayed();
		driver.close();
		driver.quit();
	}

}
