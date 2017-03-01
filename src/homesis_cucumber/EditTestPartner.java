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

public class EditTestPartner {
  private static WebDriver driver;
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
  @Если ("^Пользователь хочет поменять данные партнера$")
  public void testEditTestPartner() throws Exception {
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
	    driver.get(baseUrl + "homesis");
  }
  @Тогда ("^Пользователь переходит в сервис homesis и заходит с правильными логином и паролем$")
  public void login() throws Exception {
		  driver.findElement(By.id("IDToken1")).clear();
		    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
		    driver.findElement(By.id("IDToken2")).clear();
		    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
		    driver.findElement(By.name("Login.Submit")).click();
  }
  @И ("^Пользователь переходит во вкладку с партнерами$")
  public void partnerMenu() throws Exception {
    driver.findElement(By.xpath("//tr[2]/td[2]")).click();
    driver.findElement(By.linkText("Sales administration")).click();
    driver.findElement(By.cssSelector("nobr")).click();
    driver.findElement(By.linkText("Clear")).click();
  }
  @Тогда ("^Пользователь вводит имя партнера для поиска$")
  public void filtername() throws Exception {
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("test");
    driver.findElement(By.linkText("Search a partner")).click();
  }
  @И ("^После фильтрации пользователь выбирает нужного партнера и заходит во вкладку с данными$")
  public void choosePart() throws Exception {
    driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
    //driver.findElement(By.id("type")).click();
  }
  @Тогда ("^Пользователь меняет нужные ему данные$")
  public void changeSMTH() throws Exception {
    new Select(driver.findElement(By.id("type"))).selectByVisibleText("Insurance");
    new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Актобе");
   // driver.findElement(By.cssSelector("option[value=\"22\"]")).click();
    new Select(driver.findElement(By.id("districtId"))).selectByVisibleText("Актобе DSA_POST");
    new Select(driver.findElement(By.name("legalFormCode"))).selectByVisibleText("Limited liability partnership");
  }
  @И ("^Пользователь передумывает и меняет все обратно$")
  public void returnSMTH() throws Exception {
   // driver.findElement(By.linkText("Save")).click();
    new Select(driver.findElement(By.id("businessModel"))).selectByVisibleText("AP");
    new Select(driver.findElement(By.name("legalFormCode"))).selectByVisibleText("Joint-stock company Kazpost");
    new Select(driver.findElement(By.id("regionId"))).selectByVisibleText("Алматы");
  //  driver.findElement(By.cssSelector("option[value=\"23\"]")).click();
    new Select(driver.findElement(By.id("districtId"))).selectByVisibleText("Алматы DSA_POST");
   // driver.findElement(By.cssSelector("#districtId > option[value=\"24\"]")).click();
    driver.findElement(By.xpath("//form[@id='storePartnerForm']/table/tbody/tr[3]/td/table")).click();
    new Select(driver.findElement(By.id("type"))).selectByVisibleText("Seller");
    driver.findElement(By.linkText("Save")).click();
    if( EditTestPartner.driver.toString().contains("null"))
	  {

	  System.out.print("All Browser windows are closed ");
	  }
	  else
	  {
		  EditTestPartner.driver.quit();
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
