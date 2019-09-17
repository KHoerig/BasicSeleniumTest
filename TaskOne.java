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

//		//Step 1 Navigate to URL in Firefox Window
//		
//		System.setProperty("webdriver.gecko.driver","/Users/heeesh/Desktop/geckodriver");
//		
//		FirefoxDriver driver = new FirefoxDriver();
//		 
//		driver.manage().window();
//
//		driver.get("https://app.getswift.co/Account/Login");
//		
//		//Step 2 - Enter email address
//		
//		driver.findElement(By.xpath("//*[@id=\"Email\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("seleniumtest@gs.com");
//		
//		//Step 3 - Enter PW and click complete sign in 
//		
//		driver.findElement(By.xpath("//*[@id=\"Password\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("test.123");
//		driver.findElement(By.xpath("//*[@id=\"form-account-login\"]/button")).click();
//		
//		/**
//		
//		//Step 4 - Click on the hamburger menu
//		driver.findElement(By.xpath("//*[@id=\"nav-burger\"]")).click();
//		
//		//Step 5 - Click on Drivers Link
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/ul[2]/li[3]/a")).click();
//		
//		//Step 6 - Click on Add Drivers Link
//		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/button[2]")).click();
//		
//		//Step 7 - Type Full Name, Phone and Email
//		
//		driver.findElement(By.xpath("//*[@id=\"FullName\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"FullName\"]")).sendKeys(driversName);
//		
//		driver.findElement(By.xpath("//*[@id=\"Email\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("FakeEmail@Fake.com");
//		
//		driver.findElement(By.xpath("//*[@id=\"Phone\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"Phone\"]")).sendKeys("303-555-1234");
//		
//		//Step 8 - Type and Confirm Password
//		driver.findElement(By.xpath("//*[@id=\"Password\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("FakePassword");
//		
//		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("FakePassword");
//		
//		//Step 9 - Choose “Uber” under What mode of transport will you be using?
//		driver.findElement(By.xpath("//*[@id=\"ModeOfTransport\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/form/div[3]/div/div[1]/div/div/select/option[5]")).click();
//		
//		
//		//Step 10 - Click SUBMIT button
//		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/form/div[4]/button")).click();
//		*/
//		
//		//Step 11 - Confirm driver has been added
//				driver.get("https://app.getswift.co");
//				driver.findElement(By.xpath("//*[@id=\"nav-burger\"]")).click();
//				driver.findElement(By.xpath("/html/body/div[2]/div/div/ul[2]/li[3]/a")).click();
//				String lastRow =  driver.findElement(By.xpath("(//*[@id=\"handlersTable\"])[last()]")).getText();
//				assert lastRow.contains("Test 1");
//	}		
//}
//		
//		
//		
//		
