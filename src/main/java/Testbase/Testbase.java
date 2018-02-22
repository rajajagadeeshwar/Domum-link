package Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {
	
	public static WebDriver driver;
	String browser="chrome";
	public static Logger logger= Logger.getLogger("Testbase.class"); // always logger define at class level
	
	public static Properties prop;

	
	
	public void init()
	{
		selectbrowser(browser);
		geturl();
        logger1();
			
		
	}

	public void selectbrowser(String browser)
	{
     if(browser.equalsIgnoreCase("chrome"))
     {		
		System.setProperty("webdriver.chrome.driver","G:\\selenium\\webdriver\\browser drivers\\chromedriver2.33.exe");
		 driver= new ChromeDriver();
		
   	}
     }
	
	public void geturl(){
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      // driver.get("http://automationpractice.com/index.php");
        driver.get("http://domum.website/");
		
		logger.info("launch the url");
	}
	
	
	public void logger1(){
		PropertyConfigurator.configure("log.properties");

	}
	
}
