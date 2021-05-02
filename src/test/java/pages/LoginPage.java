package pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.ScrrenshotUtil;


public class LoginPage {

	WebDriver driver;
	By txt_username_login= By.id("email");
	By txt_password_login= By.id("pass");
	By btn_loginbtn=By.id("login-btn");
	By link_login=By.linkText("Login");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginvaliduser(String username, String password) throws InterruptedException, IOException, InvalidFormatException
	{
		driver.findElement(link_login).click();
		System.out.println("After Opening Login Page");
		ScrrenshotUtil.capture(driver,"E:\\Eclipse2020\\Workspace\\CucumberJava\\ScreenShots\\LoginPage.png");
		ScrrenshotUtil.ToArray("E:\\Eclipse2020\\Workspace\\CucumberJava\\ScreenShots\\LoginPage.png");
		System.out.println("Title Screen"+driver.getTitle());
		System.out.println("Element Present= "+driver.findElement(txt_username_login).isDisplayed());
		/*RemoteWebDriver r=(RemoteWebDriver) driver;
		String s1="document.getElementById('email').value="+username;
		System.out.println("String S1"+s1);
		r.executeScript(s1);*/
		
		/*WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_username_login)));
		
		*/
		ScrrenshotUtil.createWord("Login");
		driver.findElement(txt_username_login).sendKeys(username);
		
		
		driver.findElement(txt_password_login).sendKeys(password);
		driver.findElement(btn_loginbtn).click();
		
		
		
	}
}
