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

public class EditSalesroom {
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
  public void testEditSalesroom() throws Exception {
	    driver.get(baseUrl + "/homesis/index.do");
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    driver.findElement(By.name("Login.Submit")).click();

    driver.findElement(By.xpath("//tr[3]/td[2]/table/tbody/tr/td")).click();
    driver.findElement(By.linkText("Sales administration")).click();
    driver.findElement(By.xpath("//table[@id='salesroom']/tbody/tr/th[2]/a/nobr")).click();
    driver.findElement(By.linkText("Clear")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("test");
    driver.findElement(By.linkText("Search salesroom")).click();
    driver.findElement(By.xpath("//tbody[@id='sepTBody']/tr/td[2]/a/img")).click();
    driver.findElement(By.cssSelector("div.detailForm")).click();
  //  driver.findElement(By.id("regionId")).click();
    new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Актобе");
   //driver.findElement(By.cssSelector("option[value=\"22\"]")).click();
    new Select(driver.findElement(By.id("districtId"))).selectByVisibleText("Актобе DSA_POST");
    //driver.findElement(By.cssSelector("option[value=\"13\"]")).click();
    new Select(driver.findElement(By.name("momentOfPayment"))).selectByVisibleText("On contract completion");
    Thread.sleep(500);
    new Select(driver.findElement(By.name("category"))).selectByVisibleText("Top");
    
    Thread.sleep(500);
    new Select(driver.findElement(By.id("processType"))).selectByVisibleText("One phase process");
    Thread.sleep(500);
    new Select(driver.findElement(By.id("businessModel"))).selectByVisibleText("AP");
    Thread.sleep(1000);
    try {
    	 driver.findElement(By.linkText("Save")).click();
      } catch (StaleElementReferenceException elementHasDisappeared) {
    	  driver.findElement(By.linkText("Save")).click();
      }
    
    new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Алматы");
    Thread.sleep(500);
   // driver.findElement(By.cssSelector("option[value=\"23\"]")).click();
    new Select(driver.findElement(By.id("districtId"))).selectByVisibleText("Алматы BRANCH");
  //  driver.findElement(By.cssSelector("#districtId > option[value=\"23\"]")).click();
    new Select(driver.findElement(By.name("momentOfPayment"))).selectByVisibleText("Manually");
    new Select(driver.findElement(By.name("category"))).selectByVisibleText("Stone");
    new Select(driver.findElement(By.id("processType"))).selectByVisibleText("Two phase process");
    new Select(driver.findElement(By.id("secondBlockFillingType"))).selectByVisibleText("Front office");
   // driver.findElement(By.xpath("//tr[16]/td[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Save")).click();
  }

  @After
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
