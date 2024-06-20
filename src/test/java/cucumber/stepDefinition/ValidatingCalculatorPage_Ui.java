package cucumber.stepDefinition;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import cucumber.PageObjectCucumber.PageObject;
import cucumber.hooks.DriverInstance;
import utility.ScreenShot;
import utility.Elements_Utils;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class ValidatingCalculatorPage_Ui extends DriverInstance{

	

	@When("Validating Ui of EmiCalculator_LoanAmount_page")
	public void validatingEMIcalculator_LoanAmount(){
		// l.info("valildating  EMI calculator LoanAmount");
		PageObject p=new PageObject(DriverInstance.getDriver());
		SoftAssert s=new SoftAssert();
		p.dropdown();
		p.clickLoanCalculator();
		p.clickEMICalculator();
		ScreenShot.takeScreenshot(DriverInstance.getDriver(),"EmiCalculator_LoanAmount_page");

		WebElement elementsDisplayedCheck[] = {
				p.loanAmountTextBox(),
				p.loanAmountslider(), 
				p.InterestRateTextBox(),
				p.InterestRateslider(),
				p.LoanTenureTextBox(),
				p.LoanTenureslider(),
				p.FeesAndChargesTextBox(),
				p.FeesAndChargesslider()
			};
		DriverInstance.getLogger().info("Checking EMI_Calculator Elements displayed or not");
		for(WebElement element : elementsDisplayedCheck){
			boolean status = false;
			Elements_Utils.highlightElement(element);
			if(element.isDisplayed()){
				status = true;
				s.assertTrue(true);
			} else{
				status = false;
				s.assertFalse(false);
			}      
			Elements_Utils.undoHighlightElement(element);
		}
		Elements_Utils.checkYearAndMonth();  
		//----------
	}

	@Then("Validating Ui of LoanAmountCalculator_Emi_page")
	public void validatingLoanAmountcalculator_Emi(){
		// l.info("validating LoanAmount calculator Emi");
		PageObject p=new PageObject(DriverInstance.getDriver());
		SoftAssert s=new SoftAssert();
		p.dropdown();
		p.clickLoanCalculator();
		p.clickLoanAmountCalculator();
		ScreenShot.takeScreenshot(DriverInstance.getDriver(),"EmiCalculator_Emi_page");
		//check the textbox is displayed or not

		WebElement elementsDisplayedCheck[] = {p.EmiTextBox(),
											  p.Emislider(), 
											  p.InterestRateTextBox(),
											  p.InterestRateslider(),
											  p.LoanTenureTextBox(),
											  p.LoanTenureslider(),
											  p.FeesAndChargesTextBox(),
											  p.FeesAndChargesslider()
											};
	  DriverInstance.getLogger().info("Checking LoanAmount Elements displayed or not");

       for(WebElement element : elementsDisplayedCheck){
			boolean status = false;
			if(element.isDisplayed()){
				Elements_Utils.highlightElement(element);
				status = true;
				s.assertTrue(true);
			} else{
				status = false;
				s.assertFalse(false);
			}      
			Elements_Utils.undoHighlightElement(element);
		}
		Elements_Utils.checkYearAndMonth();     
	}
	
	@Then("Validating Ui of LoanTenureCalculator_page")
	public void validatingLoanTenurecalculator_FeesAndCharges()
		{
			// l.info("validating LoanTenture calculator FeesAndCharges");
			PageObject p=new PageObject(DriverInstance.getDriver());
			SoftAssert s=new SoftAssert();
			p.dropdown();
			p.clickLoanCalculator();
			p.clickLoanTentureCalculator();
			ScreenShot.takeScreenshot(driver,"LoanTenure_calculator");

			WebElement elementsDisplayedCheck[] = {p.loanAmountTextBox(),
											  p.loanAmountslider(), 
											  p.EmiTextBox(),
											  p.Emislider(),
											  p.InterestRateTextBox(),
											  p.InterestRateslider(),
											  p.FeesAndChargesTextBox(),
											  p.FeesAndChargesslider()
											};
		DriverInstance.getLogger().info("Checking LoanTenure Elements displayed or not");
        for(WebElement element : elementsDisplayedCheck){
			boolean status = false;
			Elements_Utils.highlightElement(element);
			if(element.isDisplayed()){
				status = true;
				s.assertTrue(true);
			} else{
				status = false;
				s.assertFalse(false);
			}      
			Elements_Utils.undoHighlightElement(element);
		}
	}
}
