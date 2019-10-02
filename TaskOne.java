package seleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TaskOne {

	public static void main(String[] args) {

		String baseURL = "https://www.phptravels.net/";
		String userNamePath = "//input[@name='username']";
		String passwordPath = "//input[@name='password']";
		String logInButtonPath = "//*[@id=\"loginfrm\"]/button";

		// Set system properties to use Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/heeesh/Desktop/AutomationStuff/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 1 - Navigate to URL in Firefox Window and verify page title

		driver.manage().window();
		driver.get(baseURL);
		String homeTitle = driver.getTitle();
		Assert.assertEquals(homeTitle, "PHPTRAVELS | Travel Technology Partner");

		// Step 2 - Verify user can get to login page from home page

		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//li[@class='open']/ul[1]/li[1]/a")).click();
		String loginTitle = driver.getTitle();
		Assert.assertEquals(loginTitle, "Login");

		// Step 3 - From Login page, enter invalid credentials and verify user is not
		// logged in.
		driver.findElement(By.xpath(userNamePath)).sendKeys("Invalid UN");
		driver.findElement(By.xpath(passwordPath)).sendKeys("Invalid PW");
		driver.findElement(By.xpath(logInButtonPath)).click();
		String logInPanelText = driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[2]/div")).getText();
		Assert.assertEquals(logInPanelText, "Invalid Email or Password");

		// Step 4 - At Login page, enter valid credentials and confirm user is logged in
		// Credentials are found at https://phptravels.com/demo/
		driver.manage().window();
		driver.get(baseURL + "login");
		driver.findElement(By.xpath(userNamePath)).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath(passwordPath)).sendKeys("demouser");
		driver.findElement(By.xpath(logInButtonPath)).click();
		String loggedInIconText = driver.findElement(By.xpath("//h3[@class='RTL']")).getText();
		Assert.assertEquals(loggedInIconText, "Hi, Demo User");

		driver.close();

	}

}