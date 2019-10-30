package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "pretty", "html:target", "json:target/cucumber.json",
"junit:test/cucumber.xml" }, features = "src/test/resources/features", 
tags = "@UAT",
glue = "stepDefinations",
dryRun = false, 
monochrome = true, 
strict = true

)
public class Runner extends AbstractTestNGCucumberTests{

}
