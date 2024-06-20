package cucumber.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features/calcLoan.feature",
					"src/test/resources/Features/homeLoanDetails.feature", 
					"src/test/resources/Features/pageUi.feature"
					},
		dryRun = !true,
		glue = {"cucumber"},
		snippets=SnippetType.CAMELCASE,
		monochrome=true,
		plugin= {"pretty","html:cucumberreport/index.html"}
		)
public class Runner extends AbstractTestNGCucumberTests{
	
}
