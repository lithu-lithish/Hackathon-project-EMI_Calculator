package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PageObject {
	
	public WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*************TestCase1
	//for car tab
	@FindBy(xpath="//*[@id=\"car-loan\"]")
	WebElement cartab;
	public void clickCarTab() {
		cartab.click();
	}
	//for enter the input fields
	
	@FindBy(xpath="//*[@id='loanamount']")//amount
	WebElement txt_amount;
	
	@FindBy(xpath="//*[@id='loaninterest']")//interest percent
	WebElement txt_interest;
	
	@FindBy(xpath="//*[@id='loanterm']")//tenture year
	WebElement txt_year;
	public void enterAmountValues()
	{
		txt_amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1500000");
		txt_interest.sendKeys(Keys.chord(Keys.CONTROL, "a"), "9.5");
		txt_year.sendKeys(Keys.chord(Keys.CONTROL,"a"),"1");
		txt_year.sendKeys(Keys.ENTER);
	}
	
	//getting the values in the carLoan 
	@FindBy(xpath="//div[@id='emiamount']/p/span")//loan emi
	WebElement txt_Loanemi;
	public String LoanEmi()
	{
		return txt_Loanemi.getText();
		
	}
	
	@FindBy(xpath="//*[@id='emitotalinterest']/p/span")//Totalinterestpayable
	WebElement txt_Totalinterestpayable;
	public String Totalinterestpayable()
	{
		return txt_Totalinterestpayable.getText();
		
	}
	
	@FindBy(xpath="//*[@id='emitotalamount']/p/span")//Totalamount
	WebElement txt_Totalamount;
	public String Totalamount()
	{
		return txt_Totalamount.getText();
		
	}
	//*********** testcase 2
	//HomeLone EMI calculator
	@FindBy(xpath="//a[@id='menu-item-dropdown-2696']")//click dropdown 
	WebElement dropdowntab;
	public void dropdown() 
	{
		dropdowntab.click();
	}
	@FindBy(xpath="//a[@title='Home Loan EMI Calculator']")//click dropdown 
	WebElement txt_HomeEmiCalculator;
	public void clickHomeEmiCalculator() 
	{
		txt_HomeEmiCalculator.click();
	}

	@FindBy(xpath="//table[@class='noextras']/tbody/tr[contains(@class,'yearlypaymentdetails')]//td")//getting the rows in the table element
	List <WebElement> txt_tablerow;
	@FindBy(xpath="//div[@id='paymentschedule']/table/tbody/tr/th")//getting the cells in the  table element
	List <WebElement> txt_headings;
	
	public List<String>  getDetailsOfTheTable() 
	{
		List <String> l=new ArrayList <String>();
		 for(int i=0; i<txt_headings.size();i++) {
			 if(!(txt_headings.get(i).getText().isBlank() || txt_headings.get(i).getText().isEmpty())) {
				 l.add(txt_headings.get(i).getText());
			 }
		 }
		 for(int i=0;i<txt_tablerow.size();i++) {
			 l.add (txt_tablerow.get(i).getText());
		 }
		return l;
	}
	
	//dropdown for ui check
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]/a")
    WebElement txt_loanCalculator;
	public void clickLoanCalculator()
	{
		txt_loanCalculator.click();
	}
	//click the emi calculator tab
	@FindBy(xpath="//*[@class='hidden-ts']")
    WebElement txt_EMICalculator;
	public void clickEMICalculator()
	{
		txt_EMICalculator.click();
	}
	
	//UI testing emi calculator loan amount
	@FindBy(xpath="//*[@id='loanamount']")//loan amount text box
     WebElement txtbox_loanAmount;
	@FindBy(xpath="//*[@id='loanamountslider']")//loan amount slider
    WebElement txtbox_loanAmountslider;
	public WebElement loanAmountTextBox()
	{
		return txtbox_loanAmount;
		
	}
	public WebElement loanAmountslider()
	{
		return txtbox_loanAmountslider;
		
	}
	
	//UI testing emi calculator interest rate
	@FindBy(xpath="//*[@id='loaninterest']")//loan amount text box
    WebElement txtbox_InterestRate;
	@FindBy(xpath="//*[@id='loaninterestslider']")//loan amount slider
   WebElement txtbox_InterestRateslider;
	public WebElement InterestRateTextBox()
	{
		return txtbox_InterestRate;
		
	}
	public WebElement InterestRateslider()
	{
		return txtbox_InterestRateslider;
		
	}
	
	@FindBy(xpath="//*[@id='loanterm']")//LoanTenure text box
    WebElement txtbox_LoanTenure;
	@FindBy(xpath="//*[@id='loantermslider']")// LoanTenure slider
   WebElement txtbox_LoanTenureslider;
	public WebElement LoanTenureTextBox()
	{
		return txtbox_LoanTenure;
		
	}
	public WebElement LoanTenureslider()
	{
		return txtbox_LoanTenureslider;
		
	}
	
	@FindBy(xpath="//*[@id='loanfees']")//FeesAndCharges text box
    WebElement txtbox_FeesAndCharges;
	@FindBy(xpath="//*[@id='loanfeesslider']")//FeesAndCharges slider
   WebElement txtbox_FeesAndChargesslider;
	public WebElement FeesAndChargesTextBox()
	{
		return txtbox_FeesAndCharges;
		
	}
	public WebElement FeesAndChargesslider()
	{
		return txtbox_FeesAndChargesslider;
		
	}
	
	//click the loan amount calculator tab
	@FindBy(xpath="//*[@id='loan-amount-calc']")
    WebElement txt_LoanAmountCalculator;
	public void clickLoanAmountCalculator()
	{
		txt_LoanAmountCalculator.click();
	}
	
	@FindBy(xpath="//*[@id='loanemi']")//EMI text box
    WebElement txtbox_Emi;
	@FindBy(xpath="//*[@id='loanemislider']")//EMI FeesAndCharges slider
   WebElement txtbox_Emislider;
	public WebElement EmiTextBox()
	{
		return txtbox_Emi;
		
	}
	public WebElement Emislider()
	{
		return txtbox_Emislider;
		
	}
	
	//click the loan amount calculator tab
		@FindBy(xpath="//*[@id='loan-tenure-calc']")
	    WebElement txt_LoanTentureCalculator;
		public void clickLoanTentureCalculator()
		{
			txt_LoanTentureCalculator.click();
		}
		
   //checking the year and month
//		@FindBy(xpath="//*[@class='btn btn-secondary active']")//click year tab
//		WebElement button_Year;
//		public void clickYearButton()
//		{
//			js.executeScript("button_Year.click();");
//		}
		
		
//		@FindBy(xpath="//*[@class='btn btn-secondary']")//click month tab
//		WebElement button_Month;
//		public void clickMonthButton()
//		{
//			js.executeScript("button_Month.click();");
//		}
		@FindBy(xpath="//*[@id='loanterm']")
		WebElement txt_YearAndMonth;
		public String getYearAndMonthText()
		{
			 return txt_YearAndMonth.getAttribute("value");
		}
		@FindBy(xpath="//div[@id='loantermsteps']//span[@class='marker']")
		List <WebElement> txt_YearAndMonthSlider;
		public List <WebElement> getYearAndMonthSlider()
		{
			 return txt_YearAndMonthSlider;
		}

}
