package Runners;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
	features="Features",
    glue= {"StepDefiniitions"}//,
    )

	public class TestRunner{
	
}