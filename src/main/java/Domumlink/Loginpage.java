/**
 * 
 */
package Domumlink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Testbase.Testbase;

/**
 * @author Jagadeeshwar
 *
 */
public class Loginpage extends Testbase {
	
	
	public void sigup() {
		
		driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        logger.info("Clicking on signin link");			


		String s = driver.findElement(By.xpath("//a[@href='/Activation']")).getText();
		logger.info("Create my account " + s);
		Boolean b1 = driver.findElement(By.xpath("//a[@href='/Activation']")).isDisplayed();

		Assert.assertTrue(b1);

		logger.info("validating display option");

	}

	public  void login(String uname, String pwd) {

		driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys(uname);

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);

		driver.findElement(By.xpath("//input[@id='RememberEmail']")).click();

		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        logger.info("sign in button");			

        String s1 = driver
				.findElement(
						By.xpath("//div[contains(text(),' The user name or password you have entered is incorrect')]"))
				.getText();

		logger.info("Error Message is --->" + s1);
	}

	
}

