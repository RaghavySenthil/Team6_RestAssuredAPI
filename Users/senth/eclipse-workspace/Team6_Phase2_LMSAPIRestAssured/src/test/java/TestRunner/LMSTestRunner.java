package TestRunner;

import org.junit.runner.RunWith;

import Utilities.ScenarioContext;
//import Utilities.ScenarioContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html", "html:target/ExtentReports/LMSAPI.html",
				"rerun:target/failedrerun.txt", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true,
						tags = "",//@ProgramModule",//"@Login or @Batchmodule or @BatchExistingValue",
				/*tags = "@tag1-getalluser or @tag2-getinvalidendpoint or @tag3-post or @tag4-getbyuserid or
						@tag5-getbyusername or @tag7-deletebyuserid"*/
				//tags="@tag3-post or @tag5-getbyusername",
				features= {"src/test/resources/Feature"},
				glue = {"StepDefinition"}
			
		)



public class LMSTestRunner {
	public static ScenarioContext scenarioContext = new ScenarioContext();
}

