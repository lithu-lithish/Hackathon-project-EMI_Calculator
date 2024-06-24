package cucumber.PageObjectCucumber;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Elements_Utils;
public class PageObject {
	
	public WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*************TestCase1
	@FindBy(xpath="//a[text()='Car Loan']")
	WebElement car_loan;

	public void clickCarLoan() {
		Elements_Utils.highlightElement(car_loan);
		car_loan.click();
		Elements_Utils.undoHighlightElement(car_loan);
	}
	
	@FindBy(id="loanamount")
	WebElement loan_amount;
	public void loanAmount(Integer loanamount){
		Elements_Utils.highlightElement(loan_amount);
		loan_amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(loanamount));
		Elements_Utils.undoHighlightElement(loan_amount);
	}
	
	@FindBy(id="loaninterest")
	WebElement interest_rate;
	public void interestRate(Double interestRate) {
		Elements_Utils.highlightElement(interest_rate);
		interest_rate.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(interestRate));
		Elements_Utils.undoHighlightElement(interest_rate);
	}
	
	@FindBy(id="loanterm")
	WebElement loan_tenure;
	public void loanTenure(Integer loanTenure) {
		Elements_Utils.highlightElement(loan_tenure);
		loan_tenure.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(loanTenure));
		Elements_Utils.undoHighlightElement(loan_tenure);
	}
	
	public void pressEnter() {
		loan_tenure.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id="year2024")
	WebElement cur_yr;
	
	@FindBy(xpath="//div[@class='monthlypaymentcontainer']//td[3]")
	WebElement interest_amount;
	
	@FindBy(xpath="//div[@class='monthlypaymentcontainer']//td[2]")
	WebElement principle_amount;
	
	public String[] getAmounts() throws Exception {
		Elements_Utils.highlightElement(cur_yr);
		cur_yr.click();
		Elements_Utils.undoHighlightElement(cur_yr);
		Thread.sleep(2000);
		String[] amounts = new String[2];
		
		amounts[0]=interest_amount.getText();
		amounts[1]=principle_amount.getText();
		return amounts;
	}
	//*********** testcase 2
	//HomeLone EMI calculator
	@FindBy(xpath="//a[@id='menu-item-dropdown-2696']")//click dropdown 
	WebElement dropdowntab;
	public void dropdown() 
	{
		Elements_Utils.highlightElement(dropdowntab);
		dropdowntab.click();
		Elements_Utils.undoHighlightElement(dropdowntab);
	}
	@FindBy(xpath="//a[@title='Home Loan EMI Calculator']")//click dropdown 
	WebElement txt_HomeEmiCalculator;
	public void clickHomeEmiCalculator() 
	{
		Elements_Utils.highlightElement(txt_HomeEmiCalculator);
		txt_HomeEmiCalculator.click();
		Elements_Utils.highlightElement(txt_HomeEmiCalculator);
	}

	@FindBy(xpath="//table[@class='noextras']/tbody/tr[contains(@class,'yearlypaymentdetails')]//td")//getting the rows in the table element
	List <WebElement> txt_tablerow;
	
	@FindBy(xpath="//div[@id='paymentschedule']/table/tbody/tr/th")//getting the cells in the  table element
	List <WebElement> txt_headings;
	
	@FindBy(xpath="//*[@id='paymentschedule']/table")
	WebElement table;

	public List<String> getDetailsOfTheTable() 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(table);
		actions.perform();
		List <String> l=new ArrayList <String>();
		for(int i=0; i<txt_headings.size();i++) {
			 Elements_Utils.highlightElement(table);
			 
			 if(!(txt_headings.get(i).getText().isBlank() || txt_headings.get(i).getText().isEmpty())) {
				 l.add(txt_headings.get(i).getText());
				}
			}
			for(int i=0;i<txt_tablerow.size();i++) {
				l.add (txt_tablerow.get(i).getText());
			}
			Elements_Utils.undoHighlightElement(table);
		return l;
	}
	
	//dropdown webElement
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]/a")
    WebElement txt_loanCalculator;

	public void clickLoanCalculator(){
		Elements_Utils.highlightElement(txt_loanCalculator);
		txt_loanCalculator.click();
		Elements_Utils.undoHighlightElement(txt_loanCalculator);
	}

	//click the emi calculator tab
	@FindBy(xpath="//*[@class='hidden-ts']")
    WebElement txt_EMICalculator;
	public void clickEMICalculator(){
		Elements_Utils.highlightElement(txt_EMICalculator);
		txt_EMICalculator.click();
		Elements_Utils.undoHighlightElement(txt_EMICalculator);
	}
	
	//UI testing emi calculator loan amount
	@FindBy(xpath="//*[@id='loanamount']")//loan amount text box
     WebElement txtbox_loanAmount;

	@FindBy(xpath="//*[@id='loanamountslider']")//loan amount slider
    WebElement txtbox_loanAmountslider;

	public WebElement loanAmountTextBox(){
		return txtbox_loanAmount;
	}
	public WebElement loanAmountslider(){
		return txtbox_loanAmountslider;
	}
	
	//UI testing emi calculator interest rate
	@FindBy(xpath="//*[@id='loaninterest']")//loan amount text box
    WebElement txtbox_InterestRate;
	@FindBy(xpath="//*[@id='loaninterestslider']")//loan amount slider
    WebElement txtbox_InterestRateslider;

	public WebElement InterestRateTextBox(){
		return txtbox_InterestRate;
	}
	public WebElement InterestRateslider(){
		return txtbox_InterestRateslider;
	}
	
	@FindBy(xpath="//*[@id='loanterm']")//LoanTenure text box
    WebElement txtbox_LoanTenure;
	@FindBy(xpath="//*[@id='loantermslider']")// LoanTenure slider
   WebElement txtbox_LoanTenureslider;
	public WebElement LoanTenureTextBox(){
		return txtbox_LoanTenure;
	}
	public WebElement LoanTenureslider(){
		return txtbox_LoanTenureslider;
	}
	
	@FindBy(xpath="//*[@id='loanfees']")//FeesAndCharges text box
    WebElement txtbox_FeesAndCharges;

	@FindBy(xpath="//*[@id='loanfeesslider']")//FeesAndCharges slider
    WebElement txtbox_FeesAndChargesslider;

	public WebElement FeesAndChargesTextBox(){
		return txtbox_FeesAndCharges;	
	}
	public WebElement FeesAndChargesslider(){
		return txtbox_FeesAndChargesslider;	
	}
	
	//click the loan amount calculator tab
	@FindBy(xpath="//*[@id='loan-amount-calc']")
    WebElement txt_LoanAmountCalculator;

	public void clickLoanAmountCalculator(){
		Elements_Utils.highlightElement(interest_rate);
		txt_LoanAmountCalculator.click();
		Elements_Utils.undoHighlightElement(interest_rate);
	}
	
	@FindBy(xpath="//*[@id='loanemi']")//EMI text box
    WebElement txtbox_Emi;

	@FindBy(xpath="//*[@id='loanemislider']")//EMI FeesAndCharges slider
    WebElement txtbox_Emislider;
	public WebElement EmiTextBox(){
		return txtbox_Emi;
	}
	public WebElement Emislider(){
		return txtbox_Emislider;
	}
	
	//click the loan amount calculator tab
		@FindBy(xpath="//*[@id='loan-tenure-calc']")
	    WebElement txt_LoanTentureCalculator;
		public void clickLoanTentureCalculator(){
			Elements_Utils.highlightElement(interest_rate);
			txt_LoanTentureCalculator.click();
			Elements_Utils.undoHighlightElement(interest_rate);
		}
		

		@FindBy(xpath="//*[@id='loanterm']")
		WebElement txt_YearAndMonth;
		public String getYearAndMonthText(){
			 return txt_YearAndMonth.getAttribute("value");
		}

		@FindBy(xpath="//div[@id='loantermsteps']//span[@class='marker']")
		List <WebElement> txt_YearAndMonthSlider;
		public List <WebElement> getYearAndMonthSlider(){
			 return txt_YearAndMonthSlider;
		}

}
