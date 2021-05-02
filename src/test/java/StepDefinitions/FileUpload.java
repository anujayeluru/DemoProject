package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:/Eclipse2020/Workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");

		ChromeOptions name=new ChromeOptions();
		name.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		driver=new ChromeDriver(name);
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
System.out.println("Test1");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));//*[@id="uploadfile_0"]
		System.out.println("button present="+element.isDisplayed());
		element.sendKeys("C:\\Users\\ANUJA\\Desktop");
		/*Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Bef Click");
		uploadFile("C:\\Users\\ANUJA\\Desktop");
		Thread.sleep(2000);*/
	}
	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	public static void setClipboardData(String string) {
		System.out.println("Test3");
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			System.out.println("Test2");
			//Setting clipboard with file location
			setClipboardData(fileLocation);
			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}





}
