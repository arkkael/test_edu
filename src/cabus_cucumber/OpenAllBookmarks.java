package cabus_cucumber;

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

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Если;
import junit.framework.TestResult;

public class OpenAllBookmarks {
  private static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Peremennie perm = new Peremennie();

  /*@Before
  public void setUp() throws Exception {
	  
	 
  }*/

  @Если("^Пользователь входит в сервис cabus для проверки всех менюшек$")
  public void testOpenAllBookmarks() throws Exception {
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
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	    ((JavascriptExecutor) driver).executeScript("window.focus();");
	 // driver.get(baseUrl);
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    driver.findElement(By.name("Login.Submit")).click();
	    Thread.sleep(2000);
  }
	    @И ("^Пользователь выбирает меню Approved Authorizations$")
  
	    public void cms_auth_field() throws Exception{
    driver.findElement(By.cssSelector("a.fa.fa-chevron-down")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_authorizations']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("PAN");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_authorizations']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("213213");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_authorizations']/div/form/div/div[2]/div[3]/button")).click();
    Thread.sleep(2000);
	    }
	    @И ("^Пользователь выбирает меню Base24 messages$")
	    public void cms_base24messages_field() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    driver.findElement(By.xpath("//button[@type='button']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[2]/div/a/span")).click();
    Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_base24messages']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("PAN");
    Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_base24messages']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("23232");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_base24messages']/div/form/div/div[2]/div[3]/button")).click();
    Thread.sleep(1000);
	    }
	    
@И ("^Пользователь выбирает меню Presentments$")
public void cms_presentments_field() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[3]/div/a/span")).click();
    Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_presentments']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Type");
    Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_presentments']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("equal");
    Thread.sleep(1000);
  //  driver.findElement(By.cssSelector("option[value=\"string:eq\"]")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("button.btn.ng-scope")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("P Presentment")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_presentments']/div/form/div/div[2]/div[3]/button")).click();
    Thread.sleep(1000);
}
@И ("^Пользователь выбирает меню Held presentments$")
public void cms_held_presentments_field() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[4]/div/a/span")).click();
    Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_held-presentments']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Type");
    Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_held-presentments']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("equal");
    Thread.sleep(1000);
  /*  driver.findElement(By.cssSelector("option[value=\"string:eq\"]")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("button.btn.ng-scope")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("div.widget-body")).click();
    Thread.sleep(1000);*/
    driver.findElement(By.cssSelector("button.btn.ng-scope")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("P Presentment")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_held-presentments']/div/form/div/div[2]/div[3]/button")).click();
    Thread.sleep(1000);
}
@И ("^Пользователь выбирает меню Chargebacks$")
public void cms_chargebacks() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[5]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_chargebacks']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Type");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_chargebacks']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("equal");
   // driver.findElement(By.cssSelector("option[value=\"string:eq\"]")).click();
    driver.findElement(By.cssSelector("button.btn.ng-scope")).click();
    driver.findElement(By.linkText("C First ChargeBack")).click();
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_chargebacks']/div/form/div/div[2]/div[3]/button")).click();
}
@И ("^Пользователь выбирает меню Fee collections$")
public void cms_fee_collections() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[6]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_fee-collections']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("PAN");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_fee-collections']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
   // driver.findElement(By.cssSelector("option[value=\"string:ne\"]")).click();
    //driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_fee-collections']/div/form/div/div[2]/div[3]/button")).click();
}
@И ("^Пользователь выбирает меню Cards$")
public void cards() throws Exception{
    driver.findElement(By.linkText("Cards")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Contract number");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("equal");
    //driver.findElement(By.cssSelector("option[value=\"string:eq\"]")).click();
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("contain");
   //driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[3]/button")).click();
    Thread.sleep(500);
}
@И ("^Пользователь выбирает меню GPE reports, а затем EVPK reports$")
public void evpk_reports() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[8]/div/a/span")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[9]/div/a/span")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[9]/div[2]/div/ul/li/div/a/span")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_evpk-reports']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Account number");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_evpk-reports']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
    //driver.findElement(By.cssSelector("option[value=\"string:ne\"]")).click();
    //driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_evpk-reports']/div/form/div/div[2]/div[3]/button")).click();
}
@И ("^Пользователь выбирает меню GPE reports, а затем EMPK reports$")
public void empk_reports() throws Exception{
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[9]/div[2]/div/ul/li[2]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_empk-reports']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Account number");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_empk-reports']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
    //driver.findElement(By.cssSelector("option[value=\"string:ne\"]")).click();
    //driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_empk-reports']/div/form/div/div[2]/div[3]/button")).click();
}
@И ("^Пользователь выбирает меню GPE reports, а затем UCTY reports$")
public void cms_ucty_reports() throws Exception{
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[9]/div[2]/div/ul/li[3]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_ucty-reports']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Year");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_ucty-reports']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
   // driver.findElement(By.cssSelector("option[value=\"string:ne\"]")).click();
   // driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("2012");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_ucty-reports']/div/form/div/div[2]/div[3]/button")).click();
}
@И ("^Пользователь выбирает меню GPE reports, а затем Requests history$")
public void cms_gpe_requests() throws Exception {
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[9]/div[2]/div/ul/li[4]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_gpe-requests']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Year");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_gpe-requests']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
   // driver.findElement(By.cssSelector("option[value=\"string:ne\"]")).click();
    //driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("2012");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_gpe-requests']/div/form/div/div[2]/div[3]/button")).click();
}
@И ("^Пользователь выбирает меню Card types$")
public void cms_card_types() throws Exception{
    driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[10]/div/a/span")).click();
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_card-types']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("ID");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_card-types']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("not equal");
    //driver.findElement(By.cssSelector("option[value=\"string:ne\"]")).click();
  //  driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_card-types']/div/form/div/div[2]/div[3]/button")).click();
    //driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
    //driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    //driver.findElement(By.cssSelector("a.fa.fa-chevron-up")).click();
    if( OpenAllBookmarks.driver.toString().contains("null"))
	  {

	  System.out.print("All Browser windows are closed ");
	  }
	  else
	  {
		  OpenAllBookmarks.driver.quit();
	  }
  }


@After 
public void tearDown(Scenario scenario) throws Exception { 
	  if (scenario.isFailed()) {
	      // Take a screenshot...
	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
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
