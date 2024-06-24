package cucumber.hooks;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
 
public class DriverSetupCucumber {
	static WebDriver driver;
	Properties properties;  
	  
	@Before
	public void appSetup() throws IOException, InterruptedException {
			driver = DriverInstance.initilizeBrowser();
			driver = DriverInstance.getDriver();
			properties = DriverInstance.getProperties();
			driver.get(properties.getProperty("appURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			 Thread.sleep(5000);
			 DriverInstance.getLogger().info("Web Page opens");
	   }	
	
	@After
	public void quitAplication() throws IOException {
			driver.quit();
	    }
}