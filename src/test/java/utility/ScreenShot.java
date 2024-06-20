package utility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.google.common.io.Files;
public class ScreenShot {
	
	public static void takeScreenshot(WebDriver driver, String name) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File desc = new File("./src/Output/ScreenShot/img-"+name+".png");
			Files.copy(src, desc);
			System.out.println("Snap has been taken Successfully");
		}catch(Exception e) {
			System.out.println("Snap has not taken");
		}
	}

}
