package driverUtility;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
public class DriverSetup {
	public static Logger l; 
	public static WebDriver driver;
//@BeforeClass
////@Parameter("browser")
//public static void driverSet() throws InterruptedException {
//	driver=new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://emicalculator.net/");
//	driver.manage().window().maximize();
//	Thread.sleep(5000);
//}
//@AfterClass
//public void tearDown()
//{
//	driver.quit();
//}
//----------------------------------------------------------
@BeforeClass
@Parameters({"browser"})
public void driverSetup(String browserName) throws InterruptedException{
	 l=LogManager.getLogger(getClass());

	if(browserName.equalsIgnoreCase("chrome")) {
		l.info("---> Starting chrome");
		driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("edge")){
		l.info("---> Starting edge");
		driver = new EdgeDriver();
	}else {
		l.info("Invalid Browser");
	}
	String url="";
	try {
		
		FileReader file = new FileReader("./src/test/resources/Properties.properties");
		Properties p = new Properties();
		p.load(file);
		l.info("--->getting url from properties file");
		url = p.getProperty("url");

	} catch (IOException e) {
     l.info("getting url fail"+e);
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(1000);
}

@AfterClass
public void browserClose() {
	l.info("--->closing the browser");
	System.out.println();
	driver.quit();
}


}
