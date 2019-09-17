package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskOne {

	public static void main(String[] args) {

		String baseURL = "https://www.phptravels.net/";

		// Step 1 Navigate to URL in Firefox Window and verify page title

		System.setProperty("webdriver.gecko.driver", "/Users/heeesh/Desktop/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window();
		driver.get(baseURL);
		if (driver.getTitle().contains("PHPTRAVELS | Travel Technology Partner")) {
			System.out.println("Homepage test PASS");

		} else {

			System.out.println("Homepage test FAIL");
		}

		// Step 2 - Verify user can get to login page from home page

		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[1]/a")).click();
		if (driver.getTitle().contains("Login")) {
			System.out.println("Login page test PASS");

		} else {

			System.out.println("Login page test FAIL");
		}

		// Step 3 - From Login page, enter invalid credentials and verify user is not
		// logged in.
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[1]/input"))
				.sendKeys("Invalid UN");
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[2]/input"))
				.sendKeys("Invalid PW");
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/button")).click();
		String logInPanelText = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[1]"))
				.getText();

		if (logInPanelText.contains("LOGIN")) {
			System.out.println("Invalid Login Test PASS");
		} else {
			System.out.println("Invalid Login Test FAIL");
		}

		// Step 4 - From Login page, enter valid credentials and confirm user is logged
		// in
		// Credentials are found at https://phptravels.com/demo/
		driver.manage().window();
		driver.get(baseURL + "login");
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[1]/input"))
				.sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[5]/div/div[2]/input"))
				.sendKeys("demouser");
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/form/button")).click();
		String loggedInIconText = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).getText();
		System.out.println("welcomeBannerText = " + loggedInIconText);

		if (loggedInIconText.contains("MY ACCOUNT")) {
			System.out.println("Valid Login Test PASS");
		} else {
			System.out.println("Valid Login Test FAIL");
		}

		driver.close();

	}

}