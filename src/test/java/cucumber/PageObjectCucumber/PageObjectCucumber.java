package cucumber.PageObjectCucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Elements_Utils;

public class PageObjectCucumber {
	
	public WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public PageObjectCucumber(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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
//		loan_tensure.sendKeys(Keys.ENTER);
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
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("document.getElementById('year2024').click()", driver);
		Thread.sleep(2000);
		String[] amounts = new String[2];
		
		amounts[0]=interest_amount.getText();
		amounts[1]=principle_amount.getText();
		return amounts;
	}
	
	
}
