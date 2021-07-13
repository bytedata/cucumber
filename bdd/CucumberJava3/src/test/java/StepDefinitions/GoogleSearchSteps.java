package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside step-browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	}

	@And("user is on browser search page")
	public void user_is_on_browser_search_page() {
		System.out.println("Inside step-user is on google search page");
		driver.navigate().to("https://google.com");
	}

	@When("user enter a text in search box")
	public void user_enter_a_text_in_search_box() throws InterruptedException {
		System.out.println("Inside step-user enters a text in search box");
		driver.findElement(By.name("q")).sendKeys("Sirisha Bandla soared into the sky ");
		Thread.sleep(1000);

	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		System.out.println("Inside step-hits enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.manage().window().fullscreen();
		Thread.sleep(4000);

	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("Inside step-user is navigated to search results");
		driver.getPageSource().contains("cource");
		driver.close();
		driver.quit();
	}
}
