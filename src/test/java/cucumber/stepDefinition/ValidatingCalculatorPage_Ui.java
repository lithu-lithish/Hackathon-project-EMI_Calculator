package cucumber.stepDefinition;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import cucumber.PageObjectCucumber.PageObject;
import cucumber.hooks.DriverInstance;
import cucumber.utility.ScreenShot;
import cucumber.utility.yearAndMonthScale;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class ValidatingCalculatorPage_Ui extends DriverInstance{

	

	@When("Validating Ui of EmiCalculator_LoanAount_page")
	public void validatingEMIcalculator_LoanAmount(){
		// l.info("valildating  EMI calculator LoanAmount");
		PageObject p=new PageObject(DriverInstance.getDriver());
		SoftAssert s=new SoftAssert();
		p.dropdown();
		p.clickLoanCalculator();
		p.clickEMICalculator();
		ScreenShot.takeScreenshot(DriverInstance.getDriver());

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
			
		for(WebElement element : elementsDisplayedCheck){
			boolean status = false;
			if(element.isDisplayed()){
				status = true;
				s.assertTrue(true);
			} else{
				status = false;
				s.assertFalse(false);
			}      
		}
		yearAndMonthScale.checkYearAndMonth();  
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
		ScreenShot.takeScreenshot(DriverInstance.getDriver());
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
		
       for(WebElement element : elementsDisplayedCheck){
			boolean status = false;
			if(element.isDisplayed()){
				status = true;
				s.assertTrue(true);
			} else{
				status = false;
				s.assertFalse(false);
			}      
		}
		yearAndMonthScale.checkYearAndMonth();     
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
			ScreenShot.takeScreenshot(driver);

			WebElement elementsDisplayedCheck[] = {p.loanAmountTextBox(),
											  p.loanAmountslider(), 
											  p.EmiTextBox(),
											  p.Emislider(),
											  p.InterestRateTextBox(),
											  p.InterestRateslider(),
											  p.FeesAndChargesTextBox(),
											  p.FeesAndChargesslider()
											};
		
        for(WebElement element : elementsDisplayedCheck){
			boolean status = false;
			if(element.isDisplayed()){
				status = true;
				s.assertTrue(true);
			} else{
				status = false;
				s.assertFalse(false);
			}      
		} 
		}
}
