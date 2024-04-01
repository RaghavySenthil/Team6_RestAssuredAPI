package TestRunner;

import org.junit.runner.RunWith;

import Utilities.scenarioContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html", "html:target/ExtentReports/UserAPI.html",
				"rerun:target/failedrerun.txt", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true,
						//tags = " @userROLESTATUS_PUT1 or  @userROLESTATUS_PUT2 or  @userROLESTATUS_PUT3",
						//tags ="@userLOGINSTATUS_PUT1 or userLOGINSTATUS_PUT3 or  @userLOGINSTATUS_PUT2",
				tags="@usermodule3 and not(@userLOGINSTATUS_DELETE13 and @userLOGINSTATUS_DELETE13)",
				//tags=" @userLOGINSTATUS_PUT7",
				features= {"src/test/resources/Feature/UserModule.feature"},
				glue = {"StepDefinitions"}
			
		)

public class LMSTestRunner {
	public static scenarioContext scenarioContext = new scenarioContext();
	

}

