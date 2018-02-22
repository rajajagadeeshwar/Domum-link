/**
 * 
 */
package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Domumlink.Loginpage;
import Testbase.Testbase;

/**
 * @author Jagadeeshwar
 *
 */
public class TestLogin extends Testbase {

	@BeforeClass
	public void initialization() {

		init();
	}

	@Test(priority = 1)

	public void testlogin() {

		Loginpage loginpage = new Loginpage();
		loginpage.sigup();
		loginpage.login("raja", " raja1");

	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
