package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePageFactory {

	WebDriver driver;

	public HomepagePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logout")
	WebElement btn_logout;

	public void checkLogOutIsDisplayed() {
		btn_logout.isDisplayed();
	}

}
