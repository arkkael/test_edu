package homersis;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class SearchSalesroom {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Peremennie perm = new Peremennie();

  @Before
  public void setUp() throws Exception {
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
  }

  @Test
  public void testSearchSalesroom() throws Exception {
	  driver.get(baseUrl + "/homesis/index.do");
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    driver.findElement(By.name("Login.Submit")).click();
    driver.findElement(By.xpath("//tr[3]/td[2]/table/tbody/tr/td")).click();
    driver.findElement(By.linkText("Sales administration")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//table[@id='salesroom']/tbody/tr/th[2]/a/nobr")).click();
    driver.findElement(By.linkText("Clear")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("test");
    try {
    	driver.findElement(By.linkText("Search salesroom")).click();
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 driver.findElement(By.linkText("Search salesroom")).click();
     }
    Thread.sleep(500);
    driver.findElement(By.id("partnerCode")).clear();
    driver.findElement(By.id("partnerCode")).sendKeys("0202");
    try {
    	driver.findElement(By.linkText("Search salesroom")).click();
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 driver.findElement(By.linkText("Search salesroom")).click();
     }
    driver.findElement(By.id("code")).clear();
    Thread.sleep(500);
    driver.findElement(By.id("code")).sendKeys("031");
    try {
    	driver.findElement(By.linkText("Search salesroom")).click();
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 driver.findElement(By.linkText("Search salesroom")).click();
      	 
     }
    //driver.findElement(By.linkText("Search salesroom")).click();
    try {
    	 new Select(driver.findElement(By.name("status"))).selectByVisibleText("Active");
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 new Select(driver.findElement(By.name("status"))).selectByVisibleText("Active");
  
     }
 //   new Select(driver.findElement(By.name("status"))).selectByVisibleText("Active");
    Thread.sleep(500);
 //   driver.findElement(By.cssSelector("option[value=\"ACTIV\"]")).click();
    try {
    	driver.findElement(By.linkText("Search salesroom")).click();
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 driver.findElement(By.linkText("Search salesroom")).click();
     }
    //driver.findElement(By.xpath("//tr[7]/td")).click();
    try {
    	  new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Актобе");
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	  new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Актобе");
     }
    try {
  	  new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Актобе");
   } catch (StaleElementReferenceException elementHasDisappeared) {
  	  new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Актобе");
   }
    try {
    	  new Select(driver.findElement(By.id("districtId"))).selectByVisibleText("Актобе DSA_POST");
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	  new Select(driver.findElement(By.id("districtId"))).selectByVisibleText("Актобе DSA_POST");
     }
   
    
  
   //driver.findElement(By.cssSelector("option[value=\"23\"]")).click();
    try {
    	driver.findElement(By.linkText("Search salesroom")).click();
     } catch (StaleElementReferenceException elementHasDisappeared) {
    	 driver.findElement(By.linkText("Search salesroom")).click();
     }
    driver.findElement(By.xpath(".//*[@id='sepTBody']/tr/td[2]/a/img")).click();
    Thread.sleep(4000);
  }

  /*@After
  public void tearDown() throws Exception {
	 
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
*/
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
