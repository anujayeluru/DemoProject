package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.ScreenshotException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	WebDriver driver=null;
	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException, InterruptedException {
		
		System.out.println("Inside user is on login page");
		System.setProperty("webdriver.chrome.driver", "E:/Eclipse2020/Workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		
		ChromeOptions name=new ChromeOptions();
		name.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		driver=new ChromeDriver(name);
		driver.get("https://www.mirraw.com/designers/classiques/designs/multicolor-art_silk-sarees-combo-sari--adb6722e-782f-4c5f-abc6-bdb985119f48");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		Thread.sleep(2000);
		System.out.println("ELemeent DIspalyed::"+driver.findElement(By.xpath("//*[@id='3384984']")).isEnabled());
		driver.findElement(By.xpath("//*[@id='3384984']/div")).click();
		System.out.println("Clickeddddd");
	ScrrenshotUtil.capture(driver,"E:\\Eclipse2020\\Workspace\\CucumberJava\\ScreenShots\\LandingPage.png");
	ScrrenshotUtil.ToArray("E:\\Eclipse2020\\Workspace\\CucumberJava\\ScreenShots\\LandingPage.png");
		// Write code here that turns the phrase above into concrete actions
	
		
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws InterruptedException, IOException, InvalidFormatException {
		System.out.println("Inside user enters username and password 1");
		
		LoginPage login= new LoginPage(driver);
		login.loginvaliduser(username, password);
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside user enters username and password");
		
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside user clicks login button");
		
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside user navigated to home page");
		
	}


}
