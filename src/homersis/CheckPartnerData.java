package homersis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPartnerData {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String BIN;
  private String status;
  private String name;
  private String type;
  private String BusArea;
  private String man;
  private String valfrom;
  private String code;
  private String contsigndate;
  private String PaymStatus;
  private String BusMod;
  private String BenCode;
  private String reg;
  Peremennie perm = new Peremennie();
  
  
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Eyumashev\\Documents\\ECLproj\\proj111\\geckodriver1.exe");

	  System.setProperty("webdriver.firefox.profile", "testUNIT");
	
	
	
	
    DesiredCapabilities caps = DesiredCapabilities.firefox();
    caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
   //caps.setCapability("firefox_binary","C:\\Users\\Eyumashev\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    caps.setBrowserName("firefox");
   
    caps.setPlatform(Platform.WINDOWS);
    caps.setCapability("marionette",true);
    
    driver = new FirefoxDriver(caps);
    
    baseUrl = "https://homesis.kz63c2.kz.infra/homesis";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  
  }

  @Test
  public void testCheckPartnerData() throws InterruptedException, IOException {
    driver.get(baseUrl);// + "/index.do");
    driver.findElement(By.id("IDToken1")).clear();
    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
    driver.findElement(By.id("IDToken2")).clear();
    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
    driver.findElement(By.name("Login.Submit")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[3]/table/tbody/tr/td[1]/table/tbody/tr/th[2]/a")).click();
    Thread.sleep(2000);
   	driver.findElement(By.cssSelector("nobr")).click();
   	WebDriverWait wait = new WebDriverWait(driver, 5);// 1 minute 
   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Clear")));
    driver.findElement(By.linkText("Clear")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("test");
    driver.findElement(By.linkText("Search a partner")).click();

    Thread.sleep(4000);
    try {
    	driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
      } catch (StaleElementReferenceException elementHasDisappeared) {
    	  driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).click();
      }
 
      try {
    	
    } catch (StaleElementReferenceException e) {
        System.out.println("Attempting to recover from StaleElementReferenceException ...");
        
    }
   // String b;
   // Scanner s = new Scanner(System.in);
    //s.nextLine();
    //System.out.println(s);
     Thread.sleep(3000);
    name = driver.findElement(By.id("name")).getAttribute("value");
    status = driver.findElement(By.id("status")).getAttribute("value");
    BIN = driver.findElement(By.name("dic")).getAttribute("value");
    type = driver.findElement(By.id("type")).getAttribute("value");
    BusArea = new Select(driver.findElement(By.id("districtId"))).getFirstSelectedOption().getText();
    man = driver.findElement(By.id("partnerManagerId")).getAttribute("value");
    valfrom = driver.findElement(By.id("activityStart")).getAttribute("value");
    code = driver.findElement(By.id("code")).getAttribute("value");
    contsigndate = driver.findElement(By.id("contractSignedDate")).getAttribute("value");
    PaymStatus =  new Select(driver.findElement(By.id("paymentStatus"))).getFirstSelectedOption().getText(); 
    BusMod = driver.findElement(By.id("businessModel")).getAttribute("value");
    BenCode = driver.findElement(By.name("legalFormCode")).getAttribute("value");
    System.out.println("name=" + name + " status=" + status + " BIN=" + BIN + " type=" + type + " BusArea=" 
    + BusArea + " Manager=" + man + " valfrom=" + valfrom + " code=" + code + " contsigndate=" + contsigndate + " PaymStatus=" 
    + PaymStatus + " BusMod=" + BusMod + " BenCode=" + BenCode);
   // driver.findElement(By.linkText("Save")).click();
    //driver.findElement(By.id("confirmBId")).click();
    //driver.findElement(By.xpath("(//a[contains(text(),'Yes')])[4]")).click();
    File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrfile, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\hsis\\CPD\\scr1.png"));
    driver.get("https://bsl.kz63c2.kz.infra/bsl");
    driver.findElement(By.cssSelector("#UC09_050 > img")).click();
    driver.findElement(By.name("formContent:name")).clear();
    driver.findElement(By.name("formContent:name")).sendKeys("test");
    driver.findElement(By.name("buttonPanel:search")).click(); 
    /*if (code.equals(driver.findElement(By.xpath("//tbody[@id='selTBody']/tr/td[2]/a/img")).getText()))
    		{
    	System.out.println("Коды совпадают");
    		}*/
   
	   System.out.println("Сравниваем данные: ");
	   String contsigndate2 = driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:contract-sign-date']")).getText();
	   String BIN2 = driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:tax-identification-number']")).getText();
	   String name2 = driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:name']")).getText();
       String status2= driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:status']")).getText();
       String PaymStatus2= driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:payment-status']")).getText();
       String BusArea2= driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:business-area-code']")).getText();
       String code2 = driver.findElement(By.xpath("//span[@data-uid='partner-detail-panel:code']")).getText();
    System.out.print("code= " + code2 + " ");
    if (code2.equals(code)) System.out.println("Code совпадает"); else System.out.println("Код не совпадает");
    System.out.print("contsigndate= " + contsigndate2 + " "); 
    if (contsigndate2.equals(contsigndate)) System.out.println("Дата контракта совпадает");else System.out.println("Дата контракта не совпадает");
    System.out.print("BIN= " + BIN2  + " ");
    if (BIN2.equals(BIN)) System.out.println("BIN совпадает");else System.out.println("РНН не совпадает");
    System.out.print("name= " + name2 + " ");
    if (name2.equals(name)) System.out.println("Имя совпадает"); else System.out.println("Имя не совпадает");
    System.out.print("status= " + status2 + " ");
    if (status2.equals(status)) System.out.println("Статус совпадает"); else System.out.println("Статус не совпадает");
    System.out.print("PaymStatus= " + PaymStatus2 + " ") ;
    if (PaymStatus2.equals(PaymStatus)) System.out.println("Платежный статус совпадает"); else System.out.println("Платежный статус не совпадает");
    System.out.print("Region= " + BusArea2 + " ") ;
    if (BusArea2.equals(BusArea)) System.out.println("Region совпадает"); else System.out.println("Region не совпадает");
    File scrfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrfile1, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\hsis\\CPD\\scr2.png"));
    //System.out.print(driver.findElement(By.xpath(".//*[@id='id14']/div[1]/div[1]/div/ul/li[11]/span[2]")).getText() + " ") ;
  }

  
  
  
  @After
  public void tearDown() throws Exception {
   driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
/*
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
https://homesis.kz63c2.kz.infra/homesis
https://sso.kz63c2.kz.infra/opensso/UI/
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
*/