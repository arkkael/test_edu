package cabus_cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Если;

public class SearchExistContracts {
	 private static WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  Peremennie perm = new Peremennie();

	/*  @Before
	  public void setUp() throws Exception {
		  
		 
	  }*/
  @Если ("^Пользователь заходит на вебсервис cabus для поиска контрактов$")
  public void testSearchExistContracts() throws Exception {
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
	  driver.get(baseUrl);
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    driver.findElement(By.name("Login.Submit")).click();
  }
  @И ("^Пользователь заходит в меню карт$")
  public void cards_menu() throws Exception{
    driver.findElement(By.cssSelector("a.fa.fa-chevron-down")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[7]/div/a/span")).click();
  }
  @И ("^Пользователь выбирает свои параметры для фильтрации$")
  public void setParms() throws Exception{
	  
    new Select(driver.findElement(By.xpath("(.//*[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[1]/div/select)"))).selectByVisibleText("Contract number");
    new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div/div[2]/select"))).selectByVisibleText("contain");
   // driver.findElement(By.cssSelector("option[value=\"string:ct\"]")).click();
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
  }
  @И ("^Происходит фильтрация данных$")
  public void filter() throws Exception{
	  
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[3]/button")).click();
  //  driver.findElement(By.cssSelector("div.bar._table-action > button.ng-binding.ng-scope")).click();
   // driver.findElement(By.xpath("//button[@type='button']")).click();
    //driver.findElement(By.xpath("//em-table[@id='em-EM-TABLE_cms_cards']/div/div[2]/div[2]/div/table/tbody[2]/tr/td[17]/div/button")).click();
    //driver.findElement(By.xpath("//button[@type='button']")).click();
  }
@И ("^Пользователь выбирает контракт$")
public void filterchoose() throws Exception{
	driver.findElement(By.xpath(".//*[@id='em-EM-TABLE_cms_cards']/div/div[2]/div[2]/div/table/tbody[1]/tr/td[17]/div/button")).click();
	  if( SearchExistContracts.driver.toString().contains("null"))
	  {

	  System.out.print("All Browser windows are closed ");
	  }
	  else
	  {
		  SearchExistContracts.driver.quit();
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
