package homesis_cucumber;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class SUCD {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String code;
  private String firstName;
  private String lastName;
  private String phoneNum;
  private String mainNum;
  private String status;
  private String email;
  static Peremennie perm = new Peremennie();
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

  /**
 * @throws Exception
 */
@Test
  public void testSUCD() throws Exception {
    driver.get(baseUrl + "/homesis/index.do");
    driver.findElement(By.id("IDToken1")).clear();
    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
    driver.findElement(By.id("IDToken2")).clear();
    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
    driver.findElement(By.name("Login.Submit")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("People management")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("nobr")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    driver.findElement(By.linkText("Search")).click();
    Thread.sleep(500);
    driver.findElement(By.id("firstName")).sendKeys("test");
    Thread.sleep(500);
    driver.findElement(By.linkText("Search")).click();
    Thread.sleep(500);
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    driver.findElement(By.id("surname")).sendKeys("test");
    Thread.sleep(500);
    driver.findElement(By.linkText("Search")).click();
    Thread.sleep(500);
    driver.findElement(By.id("code")).sendKeys("23423423423423");
    Thread.sleep(500);
    driver.findElement(By.linkText("Search")).click();
    Thread.sleep(500);
    Select ss = new Select(driver.findElement(By.name("status")));
    ss.selectByValue("ACTIV");
    driver.findElement(By.linkText("Search")).click();
    Thread.sleep(4000);
   // driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
   try {
    	driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
      } catch (StaleElementReferenceException elementHasDisappeared) {
    	  driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
      }
  try {
    	
    } catch (StaleElementReferenceException e) {
        System.out.println("Attempting to recover from StaleElementReferenceException ...");
        
    }
  Thread.sleep(4000);
 
    code = driver.findElement(By.id("code")).getAttribute("value");
    firstName = driver.findElement(By.id("userFirstName")).getAttribute("value");
    lastName = driver.findElement(By.id("userSurname")).getAttribute("value");
    phoneNum = driver.findElement(By.id("mainMobile")).getAttribute("value");
    mainNum = driver.findElement(By.id("mainPhone")).getAttribute("value");
    status = new Select(driver.findElement(By.id("status"))).getFirstSelectedOption().getText();
    email = driver.findElement(By.id("mainEmail")).getAttribute("value");
    System.out.println("code= " + code + " firstname= " + firstName +
    		" lastname= " + lastName + " phoneNum= " + phoneNum + " mainNum= " +
    		mainNum + " status= " + status + " email= " + email); 
    File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrfile, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\hsis\\SUCD\\scr1.png"));
    //driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
    driver.get("https://um.kz63c2.kz.infra/user-management");
    driver.findElement(By.linkText("Logout")).click();
   
    driver.findElement(By.id("IDToken1")).clear();
    driver.findElement(By.id("IDToken1")).sendKeys(perm.ulogin);
    driver.findElement(By.id("IDToken2")).clear();
    driver.findElement(By.id("IDToken2")).sendKeys(perm.upass);
    driver.findElement(By.name("Login.Submit")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div/div/input")).sendKeys(code);
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[3]/input")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Detail")).click();
    Thread.sleep(1000);
    String code2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/fieldset/div/div[1]/table/tbody/tr[1]/td[2]/span")).getText();
    String firstName2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/fieldset/div/div[1]/table/tbody/tr[2]/td[2]/span")).getText();
    String lastName2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/fieldset/div/div[1]/table/tbody/tr[3]/td[2]/span")).getText();
    String phoneNum2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/fieldset/div/div[2]/table/tbody/tr[2]/td[2]/span")).getText();
    String mainNum2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/fieldset/div/div[2]/table/tbody/tr[1]/td[2]/span")).getText();
    String status2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/fieldset/div/div[1]/table/tbody/tr[2]/td[2]/div")).getText();
    String email2 = driver.findElement(By.xpath("html/body/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/fieldset/div/div[1]/table/tbody/tr[6]/td[2]/span")).getText();
	    System.out.print("code= " + code2 + " ");
	    if (code2.equals(code)) System.out.println("Code совпадает"); else System.out.println("Код не совпадает");
	    System.out.print("firstName= " + firstName2 + " "); 
	    if (firstName2.equals(firstName)) System.out.println("firstName совпадает");else System.out.println("firstName не совпадает");
	    System.out.print("lastName= " + lastName2  + " ");
	    if (lastName2.equals(lastName)) System.out.println("lastName совпадает");else System.out.println("lastName не совпадает");
	    System.out.print("phoneNum= " + phoneNum2 + " ");
	    if (phoneNum2.equals(phoneNum)) System.out.println("phoneNum совпадает"); else System.out.println("phoneNum не совпадает");
	    System.out.print("mainNum= " + mainNum2 + " ");
	    if (mainNum2.equals(mainNum)) System.out.println("mainNum совпадает"); else System.out.println("mainNum не совпадает");
	    System.out.print("status= " + status2 + " ") ;
	    if (status2.equals(status)) System.out.println("status совпадает"); else System.out.println("status не совпадает");
	    System.out.print("email= " + email2 + " ") ;
	    if (email2.equals(email)) System.out.println("email совпадает"); else System.out.println("email не совпадает");
	    File scrfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(scrfile1, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\hsis\\SUCD\\scr2.png"));
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
