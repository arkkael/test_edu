package stepDefinition;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.mkolisnyk.cucumber.reporting.CucumberUsageReporting;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import homersis.Peremennie;
import cucumber.api.java.After;

public class Test_Steps {
	Peremennie perm = new Peremennie();
	  private WebDriver driver;
	  private String baseUrl;
		  
	  @Before
	  public void setUp() throws Exception {
		 // System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver1.exe");
		  System.setProperty("webdriver.firefox.profile", "testUNIT");
		  System.setProperty("java.net.preferIPv4Stack" , "true");
		    DesiredCapabilities caps = DesiredCapabilities.firefox();
		   // caps.setCapability("firefox_binary","C:\\Users\\EYUMASHEV\\Downloads\\Mozilla Firefox\\firefox.exe");
		    caps.setBrowserName("firefox");
		    caps.setPlatform(Platform.WINDOWS);
		    caps.setCapability("marionette",true);
		    
		    driver = new FirefoxDriver(caps);
		    baseUrl = "https://cabuscms.kz63c2.kz.infra/cabus-cms";
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  
	  }
	  
	@Если("^Пользователь зашел на страницу$")
	public void user_is_on_Home_Page() throws Throwable {
		
		driver.get(baseUrl);
      
		}
	
	@Когда("^Пользователь вводит корректные логин и пароль$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys("homerselect");
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys("homerselect");
	    driver.findElement(By.name("Login.Submit")).click();
		}
	@Тогда("^Вход потвержден$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}

	@Тогда("^Пользователь выходит из аккаунта$")
	public void user_LogOut_from_the_Application() throws Throwable {
		/*driver.get(baseUrl);
		driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys("homerselect");
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys("homerselect");
	    driver.findElement(By.name("Login.Submit")).click();*/
		driver.findElement (By.xpath(".//*[@id='header']/div/div[4]/em-logout-button/div/a/i")).click();
	}

	@Тогда("^Выход успешен$")
	public void message_displayed_Logout_Successfully() throws Throwable {
      System.out.println("LogOut Successfully");
      CucumberUsageReporting report = new CucumberUsageReporting();
      report.setOutputDirectory("target");
      report.setJsonUsageFile("./src/test/resources/cucumber-usage.json");
      report.executeReport();
	}
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	   
	  }
}
