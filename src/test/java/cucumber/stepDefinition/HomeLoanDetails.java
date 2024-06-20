package cucumber.stepDefinition;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.PageObjectCucumber.PageObject;
import cucumber.hooks.DriverInstance;
import excelUtility.ExcelWrite;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utility.ScreenShot;

public class HomeLoanDetails extends DriverInstance{
	static List <String> li;

	WebDriver driver;
	PageObject p = new PageObject(DriverInstance.getDriver());
	@Given("home loan details")
	public void valaidateHomeLoan()
	{
		DriverInstance.getLogger().info("valildating HomeLoan");
		 p.dropdown();//clicking the dropdown
		 p.clickHomeEmiCalculator();
		 li=p.getDetailsOfTheTable();
		 ScreenShot.takeScreenshot(driver);
		 
		}
		
	@And ("writing home loan details into excel sheets")
	public void WritingHomeLoanDetails(){
		DriverInstance.getLogger().info("writing the values in the table");
		ExcelWrite ex=new ExcelWrite();
		ex.writeinTable(li);
	}
}
