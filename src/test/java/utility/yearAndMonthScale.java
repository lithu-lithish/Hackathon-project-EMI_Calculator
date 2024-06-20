package utility;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import cucumber.PageObjectCucumber.PageObject;
import cucumber.hooks.DriverInstance;

public class yearAndMonthScale extends DriverInstance {
    	public static void checkYearAndMonth(){
			// validating year_and_month in EMI calculator
			PageObject p=new PageObject(DriverInstance.getDriver());
			SoftAssert s=new SoftAssert();
			String year=p.getYearAndMonthText();
			int yearInt = Integer.parseInt(year);
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
				// l.info("Year And Month verified");
			}
			else{
				s.assertTrue(false);
				// l.info("Year And Month failed");
			}
	}

}
