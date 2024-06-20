package cucumber.PageObjectCucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		car_loan.click();
	}
	
	@FindBy(id="loanamount")
	WebElement loan_amount;
	public void loanAmount(Integer loanamount){
		loan_amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(loanamount));
	}
	
	@FindBy(id="loaninterest")
	WebElement interest_rate;
	public void interestRate(Double interestRate) {
		interest_rate.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(interestRate));
	}
	
	@FindBy(id="loanterm")
	WebElement loan_tensure;
	public void loanTensure(Integer loanTensure) {
		loan_tensure.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(loanTensure));
//		loan_tensure.sendKeys(Keys.ENTER);
	}
	
	public void pressEnter() {
		loan_tensure.sendKeys(Keys.ENTER);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("document.getElementById('loanyears').click()", driver);
	}
	
	@FindBy(id="year2024")
	WebElement cur_yr;
	
	@FindBy(xpath="//div[@class='monthlypaymentcontainer']//td[3]")
	WebElement interest_amount;
	
	@FindBy(xpath="//div[@class='monthlypaymentcontainer']//td[2]")
	WebElement principle_amount;
	
	public String[] getAmounts() throws Exception {
		cur_yr.click();
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("document.getElementById('year2024').click()", driver);
		Thread.sleep(2000);
		String[] amounts = new String[2];
		amounts[0]=interest_amount.getText();
		amounts[1]=principle_amount.getText();
		return amounts;
	}
	
	
}
