package cabus_cucumber;

import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.Page;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import junit.framework.TestResult;


public class AutorizationSearch {
	Peremennie perm = new Peremennie();
	 private WebDriver driver = new FirefoxDriver();
	  private String baseUrl;
	  
		  
	/* @Before
	
	    public void setUp() throws Exception {
		 // System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver1.exe");
		//this.driver = driver;
	
	  }*/
	 @After 
	  public void tearDown(Scenario scenario) throws Exception { 
		  if (scenario.isFailed()) {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
		  }
		 
	  }
	  	  
	 
	 /* public void tearDown() throws Exception {
	    driver.quit();
	   
	  }
*/
  @Если("^Пользователь заходит на вебсервис для поиска авторизаций$")
  public void login() throws Throwable{
	 
	 // driver.manage().window().maximize();
	   // ((JavascriptExecutor) driver).executeScript("window.focus();");
	  //((JavascriptExecutor) driver).executeScript("window.focus();");
	
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver1.exe");
	  System.setProperty("webdriver.firefox.profile", "testUNIT");
	  
	  //ProfilesIni prof = new ProfilesIni();
	//  FirefoxProfile ffProfile = prof.getProfile ("javaunit");
	 //ffProfile.setAcceptUntrustedCertificates(true) ;
	 // ffProfile.setAssumeUntrustedCertificateIssuer(false);
	  System.setProperty("java.net.preferIPv4Stack" , "true");
	    DesiredCapabilities caps = DesiredCapabilities.firefox();
	    //caps.setCapability("firefox_binary","C:\\Users\\Eyumashev\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	    caps.setBrowserName("firefox");
	    caps.setPlatform(Platform.WINDOWS);
	    caps.setCapability("marionette",true);
	    
	    driver = new FirefoxDriver(caps);
	    
	    
    baseUrl = "https://cabuscms.kz63c2.kz.infra/cabus-cms";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.get("https://cabuscms.kz63c2.kz.infra/cabus-cms");
  }
  
	@Когда("^Пользователь вводит правильные данные для входа$")
  public void testAutorizationSearch() throws Throwable {
	
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    //driver.findElement(By.id("IDToken2")).sendKeys("flow");
	    driver.findElement(By.name("Login.Submit")).click();
	}
	@И("^Пользователь идет в меню поиска авторизаций$")
	public void goTObookmark() throws Throwable {
		 driver.findElement(By.cssSelector("a.fa.fa-chevron-down")).click();
		    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li/div/a/span")).click();
		    Thread.sleep(500);
	}
	
	@И("^Юзер вставляет свои значения$")
	public void SearchFilter() throws Throwable {
		 new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_authorizations']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Authorization ID");
		 Thread.sleep(500);
		    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_authorizations']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
		    Thread.sleep(500);
		    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("3232");
		
		
		    Thread.sleep(500);
	}
	@И("^Данные юзера фильтруются$")
	public void SearchFilter1() throws Throwable{
		  
		    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_authorizations']/div/form/div/div[2]/div[3]/button")).click();
		    Thread.sleep(1000);
		   // driver.close();
		    if( driver.toString().contains("null"))
			  {

			  System.out.print("All Browser windows are closed ");
			  }
			  else
			  {
				  driver.quit();
			  }
		 
		  
	}
	
		
   
   
  
  

  

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}

  