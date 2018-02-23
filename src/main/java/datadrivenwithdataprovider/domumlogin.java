package datadrivenwithdataprovider;
/**
 * @author Jagadeeshwar
 *
 */

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testbase.Testbase;

public class domumlogin extends Testbase {

	@BeforeMethod()
	public void browser() {

		init();
		Screenshot.screenshottaken(driver, "domum-loginpage");
	}

	@Test(dataProvider = "testdata")
	public void logintoword(String uname, String paswd) throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();

		driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys(uname);

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(paswd);

		driver.findElement(By.xpath("//input[@id='RememberEmail']")).click();

		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		System.out.println(driver.getTitle());

		String s1 = driver
				.findElement(
						By.xpath("//div[contains(text(),' The user name or password you have entered is incorrect')]"))
				.getText();

		logger.info("Error Message is --->" + s1);
		Screenshot.screenshottaken(driver, "domum-login unsuccessfull");

		Thread.sleep(5000);

	}

	@DataProvider(name = "testdata")

	public Object[][] testdata1() {

		Object[][] data = new Object[3][2];

		data[0][0] = "adminnn";
		data[0][1] = "demo";

		data[1][0] = "admin";
		data[1][1] = "demo123";

		data[2][0] = "adminnn";
		data[2][1] = "demo1";

		return data;
	}

	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(3000);
		driver.close();

	}

}
