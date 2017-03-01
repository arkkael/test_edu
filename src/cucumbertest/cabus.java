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



 
@RunWith(Cucumber.class)

@CucumberOptions(
		features = "cabus_feat",
		glue= {"cabus_cucumber", "homesis_cucumber"},
		monochrome = true,
		format={"pretty", "html:target/cabus.html", "json:target/cabus.json"}
		//tags = "@cabus"
		
	
		
		)

public class cabus {

}
