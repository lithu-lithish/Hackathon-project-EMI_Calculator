package utility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.google.common.io.Files;

import cucumber.hooks.AttachScreenshot;
public class ScreenShot {
	public static int count=1;
	public static void takeScreenshot(WebDriver driver, String name) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File desc = new File("./src/Output/ScreenShot/img-"+count+"_"+name+".png");
			Files.copy(src, desc);
			AttachScreenshot.attachScreenshotToReport(desc);
			System.out.println("Snap has been taken Successfully");
			count++;
		}catch(Exception e) {
			System.out.println("Snap has not taken");
		}
	}

}
