package cucumbertest;
 
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import homersis.Peremennie;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "feature",
		glue={"stepDefinition"}
	
		
		)
 
public class TestRunner {
	
}