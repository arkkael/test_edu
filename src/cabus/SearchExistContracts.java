package cabus;

import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import junit.framework.TestResult;

public class SearchExistContracts {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  Peremennie perm = new Peremennie();

	  @Before
	  public void setUp() throws Exception {
		  
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver.exe");
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
	  }
  @Test
  public void testSearchExistContracts() throws Exception {
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	    ((JavascriptExecutor) driver).executeScript("window.focus();");
	  driver.get(baseUrl);
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    driver.findElement(By.name("Login.Submit")).click();
    driver.findElement(By.cssSelector("a.fa.fa-chevron-down")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[7]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Contract number");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("contain");
   // driver.findElement(By.cssSelector("option[value=\"string:ct\"]")).click();
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[3]/button")).click();
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
   // driver.findElement(By.xpath("//button[@type='button']")).click();
    //driver.findElement(By.xpath("//em-table[@id='em-EM-TABLE_cms_cards']/div/div[2]/div[2]/div/table/tbody[2]/tr/td[17]/div/button")).click();
    //driver.findElement(By.xpath("//button[@type='button']")).click();
  }

  @After
  public void takeScreenShotOnFailure() throws IOException {
	  TestResult testResult = new TestResult();
		if (testResult.wasSuccessful() == true) {
			System.out.println(testResult.errors());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Eyumashev\\Desktop\\TestCases\\cabus\\failures\\SearchExistContracts.png"));
	   }        
	}
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
