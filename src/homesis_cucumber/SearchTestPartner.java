package homesis_cucumber;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
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
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;

public class SearchTestPartner {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Peremennie perm = new Peremennie();

  /*@Before
  public void setUp() throws Exception {
	
  }*/
 @After
  public void tearDown(Scenario scenario) throws Exception { 
	  if (scenario.isFailed()) {
	      // Take a screenshot...
	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	  }
	 // this.driver.quit();
 String verificationErrorString = verificationErrors.toString();
 if (!"".equals(verificationErrorString)) {
   fail(verificationErrorString);
 }
}
  @Если ("^Пользователь хочет найти партнера$")
  public void testSearchTestPartner() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver.exe");
	  System.setProperty("java.net.preferIPv4Stack" , "true");
	  System.setProperty("webdriver.firefox.profile", "testUNIT");
	    DesiredCapabilities caps = DesiredCapabilities.firefox();
	   // caps.setCapability("firefox_binary","C:\\Users\\EYUMASHEV\\Downloads\\Mozilla Firefox\\firefox.exe");
	    caps.setBrowserName("firefox");
	    caps.setPlatform(Platform.WINDOWS);
	    caps.setCapability("marionette",true);
	    
	    driver = new FirefoxDriver(caps);
    baseUrl = "https://homesis.kz63c2.kz.infra/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.get(baseUrl + "/homesis/");
  }
  @Тогда ("^Пользователь заходит в сервис homesis со своими логином и паролем$")
  public void login() throws Exception {
    driver.findElement(By.id("IDToken1")).clear();
    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
    driver.findElement(By.id("IDToken2")).clear();
    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
    driver.findElement(By.name("Login.Submit")).click();
    Thread.sleep(1000);
  }
  @И ("^Пользователь выбирает меню поиска партнеров$")
  public void chooseMenu() throws Exception {
    driver.findElement(By.linkText("Sales administration")).click();
    driver.findElement(By.cssSelector("nobr")).click();
}
@Тогда ("^Пользователь начинает искать партнера по своим вариантам$")
public void filter() throws Exception {
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("test");
    try {
    	 driver.findElement(By.linkText("Search a partner")).click();
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 driver.findElement(By.linkText("Search a partner")).click();
     }
    Thread.sleep(1000);
    try {
    	  new Select(driver.findElement(By.name("status"))).selectByVisibleText("Active");
       } catch (StaleElementReferenceException elementHasDisappeared) {
    	   new Select(driver.findElement(By.name("status"))).selectByVisibleText("Active");
       }
    Thread.sleep(1000);
    try {
   	 driver.findElement(By.linkText("Search a partner")).click();
    } catch (StaleElementReferenceException elementHasDisappeared) {
   	 driver.findElement(By.linkText("Search a partner")).click();
    }
    Thread.sleep(1000);
    try {
    	 new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Алматы");
      } catch (StaleElementReferenceException elementHasDisappeared) {
    	  new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Алматы");
      }
    Thread.sleep(1000);
    //driver.findElement(By.cssSelector("option[value=\"23\"]")).click();
    try {
   	 driver.findElement(By.linkText("Search a partner")).click();
    } catch (StaleElementReferenceException elementHasDisappeared) {
   	 driver.findElement(By.linkText("Search a partner")).click();
    }
    Thread.sleep(1000);
    try {
    	 new Select(driver.findElement(By.name("partnerType"))).selectByVisibleText("Seller");
       } catch (StaleElementReferenceException elementHasDisappeared) {
    	   new Select(driver.findElement(By.name("partnerType"))).selectByVisibleText("Seller");
       }
    
    Thread.sleep(1000);
    try {
   	 driver.findElement(By.linkText("Search a partner")).click();
    } catch (StaleElementReferenceException elementHasDisappeared) {
   	 driver.findElement(By.linkText("Search a partner")).click();
    }
}
@И ("^После нахождения нужного партнера пользователь хочет посмотреть его данные$")
public void viewInfo() throws Exception{

    driver.findElement(By.linkText("Clear")).click();
    driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
    Thread.sleep(4000);
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
