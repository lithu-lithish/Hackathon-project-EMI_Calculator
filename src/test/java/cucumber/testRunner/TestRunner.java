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
		plugin= {"pretty","html:cucumberreport/index.html"}
		)
public class TestRunner {
	
}
