package testcases;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import driverUtility.DriverSetup;
import outputUtility.ScreenShot;
import pageObject.PageObject;
public class ValidatingCalculatorPage_Ui extends DriverSetup{

	//@When("The webElement is displayed return true, else false")
	public static boolean is_Displayed(WebElement elements[]){
		int flag = 0;
		for(WebElement element : elements ){
			if(element.isDisplayed()){
				flag = 1;
			} 
			flag=0;
		}
		if (flag==0) return false;
		else return true;
	}

	//@When("The webElement is enabled return true, else false")
	public static boolean is_Enabled(WebElement elements[]){
		int flag = 0;
		for(WebElement element : elements ){
				if(element.isEnabled()){
				flag = 1;
			}
			flag=0;
		}
		if (flag==0) return false;
		else return true;
	}

	//@When("checking year and month scale")
	public static void checkYearAndMonth(int yearInt){
			// validating year_and_month in EMI calculator
			PageObject p=new PageObject(driver);
			SoftAssert s=new SoftAssert();
			List<WebElement> list = p. getYearAndMonthSlider();
			int[] yearScale = new int[list.size()];
			int i=0;
			for(WebElement li : list) {
				yearScale[i]=Integer.parseInt(li.getText());
				i++;
			}
			//System.out.println(Arrays.toString(yearScale));

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('loanmonths').click()");
			String month=p.getYearAndMonthText();
			//System.out.println(month);
			list =p.getYearAndMonthSlider();
			int[] monthScale = new int[list.size()];
			int j=0;
			for(WebElement li : list) {
				monthScale[j]=Integer.parseInt(li.getText());
				j++;
			}
			//System.out.println(Arrays.toString(monthScale));
			for(int k=0;k<list.size();k++) {
				s.assertTrue(monthScale[k]/12==yearScale[k]);
			}
			if(month.equals(Integer.toString(yearInt*12))) {
				s.assertTrue(true);
				l.info("Year And Month verified");
			}
			else{
				s.assertTrue(false);
				l.info("Year And Month failed");
			}
	}
	
	//@And("Validating Ui of EmiCalculator_LoanAount")
	public void validatingEMIcalculator_LoanAmount(){
		l.info("valildating  EMI calculator LoanAmount");
		PageObject p=new PageObject(driver);
		SoftAssert s=new SoftAssert();
		p.dropdown();
		p.clickLoanCalculator();
		p.clickEMICalculator();
		ScreenShot.takeScreenshot(driver);

		WebElement elementsDisplayedCheck[] = {p.loanAmountTextBox(),
											  p.loanAmountslider(), 
											  p.InterestRateTextBox(),
											  p.InterestRateslider(),
											  p.LoanTenureTextBox(),
											  p.LoanTenureslider(),
											  p.FeesAndChargesTextBox(),
											  p.FeesAndChargesslider()
											};
		
        if(is_Displayed(elementsDisplayedCheck)){
        	s.assertTrue(true);
        } else{
        	s.assertFalse(false);
        }      

		String year=p.getYearAndMonthText();
		int yearInt = Integer.parseInt(year);
		checkYearAndMonth(yearInt);
		//----------
		
	}

	//@And("Validating Ui of LoanAmountCalculator_Emi")
	public void validatingLoanAmountcalculator_Emi(){
		l.info("validating LoanAmount calculator Emi");
		PageObject p=new PageObject(driver);
		SoftAssert s=new SoftAssert();
		p.dropdown();
		p.clickLoanCalculator();
		p.clickLoanAmountCalculator();
		ScreenShot.takeScreenshot(driver);
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
		
        if(is_Displayed(elementsDisplayedCheck)){
        	s.assertTrue(true);
        } else{
        	s.assertFalse(false);
        } 
		String year=p.getYearAndMonthText();
		int yearInt = Integer.parseInt(year);
		checkYearAndMonth(yearInt);     
	}
	
	//@And("Validating Ui of LoanTenureCalculator")
	public void validatingLoanTenurecalculator_FeesAndCharges()
		{
			l.info("validating LoanTenture calculator FeesAndCharges");
			PageObject p=new PageObject(driver);
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
		
        if(is_Displayed(elementsDisplayedCheck)){
        	s.assertTrue(true);
        } else{
        	s.assertFalse(false);
        }  
		}

	
}
