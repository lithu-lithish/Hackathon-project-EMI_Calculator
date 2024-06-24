package cucumber.hooks;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;

import cucumber.hooks.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
 
public class DriverSetupCucumber {
	static WebDriver driver;
	Properties properties;
	  static boolean isInitialized = false;
	  public static boolean isQuit = false;
  
	  
	@Before
	public void appSetup() throws IOException, InterruptedException {
				
		// if(!isInitialized) {
			driver = DriverInstance.initilizeBrowser();
			driver = DriverInstance.getDriver();
			properties = DriverInstance.getProperties();
			driver.get(properties.getProperty("appURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			 Thread.sleep(5000);
			 DriverInstance.getLogger().info("Web Page opens");
			isInitialized = true;	
			isQuit=true;
		// }	
	}	
	
	@After
	public void quitAplication() throws IOException {
		
	
			driver.quit();
		
	}
}