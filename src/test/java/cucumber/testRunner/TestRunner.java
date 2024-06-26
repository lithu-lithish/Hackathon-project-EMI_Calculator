package cucumber.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
					"src/test/resources/Features/calcLoan.feature",
					"src/test/resources/Features/homeLoanDetails.feature", 
					"src/test/resources/Features/pageUi.feature"
					},
		dryRun = false,
		glue = {"cucumber"},
		monochrome=true,
		plugin= {"pretty","html:cucumberReport/index.html",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,
				}
		)
public class TestRunner {
	
}
