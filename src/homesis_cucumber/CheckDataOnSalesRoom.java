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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cabus_cucumber.SearchExistContracts;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;


public class CheckDataOnSalesRoom {
  private static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String BIN;
  private String code;
  private String status;
  private String name;
  private String chanell;
  private String apt;
  private String contsigndate;
  private String PaymStatus;
  private String BusMod;
  private String reg;
  Peremennie perm = new Peremennie();
 /* @Before
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
  @Если ("^Пользователь заходит в homesis$")
  public void testCheckDataOnSalesRoom() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.profile", "testUNIT");
	  System.setProperty("java.net.preferIPv4Stack" , "true");
	    DesiredCapabilities caps = DesiredCapabilities.firefox();
	   // caps.setCapability("firefox_binary","C:\\Users\\EYUMASHEV\\Downloads\\Mozilla Firefox\\firefox.exe");
	    caps.setBrowserName("firefox");
	    caps.setPlatform(Platform.WINDOWS);
	    caps.setCapability("marionette",true);
	    
	    driver = new FirefoxDriver(caps);
	    baseUrl = "https://homesis.kz63c2.kz.infra/homesis";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
  }
	  @И ("^Пользователь вводит правильные логин и пароль$")
	  public void loginhomesis() throws Exception {
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.id("IDToken1")).clear();
    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
    driver.findElement(By.id("IDToken2")).clear();
    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
    driver.findElement(By.name("Login.Submit")).click();
    Thread.sleep(1000);
	  }
	  @Тогда ("^Пользователь заходит во вкладку salesroom$")
	  public void enter_menu() throws Exception {
    driver.findElement(By.linkText("Sales administration")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//table[@id='salesroom']/tbody/tr/th[2]/a/nobr")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Clear")).click();
	  }
	  @И ("^Пользователь вводит имя и выбирает первого попавшегося$")
	  public void enter_values() throws Exception {
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("test");
    driver.findElement(By.linkText("Search salesroom")).click();
	  
    driver.findElement(By.xpath("//tbody[@id='sepTBody']/tr/td[2]/a/img")).click();
    Thread.sleep(2000);
	  }
	  @Тогда ("^Драйвер сохраняет значения торговой точки в homesis$")
	  public void save_values() throws Exception{
    code = driver.findElement(By.name("code")).getAttribute("value");
    name = driver.findElement(By.id("name")).getAttribute("value");
    chanell = new Select(driver.findElement(By.name("category"))).getFirstSelectedOption().getText();
  //  chanell = driver.findElement(By.id("name")).getAttribute("value");
    apt = new Select(driver.findElement(By.name("allowedProcessType"))).getFirstSelectedOption().getText();
    //apt = driver.findElement(By.name("allowedProcessType")).getText();
    status =  new Select(driver.findElement(By.id("status"))).getFirstSelectedOption().getText(); 
    //status = driver.findElement(By.id("status")).getText();
    BIN = driver.findElement(By.name("dic")).getAttribute("value");
    reg = new Select(driver.findElement(By.name("regionId"))).getFirstSelectedOption().getText();
    //reg = driver.findElement(By.id("regionId")).getText();
    contsigndate = driver.findElement(By.id("contractSignedDate")).getAttribute("value");
    //PaymStatus =  new Select(driver.findElement(By.name("paymentStatus"))).getOptions().get(1).getText();
   // PaymStatus =  new Select(driver.findElement(By.xpath("//select[@name='paymentStatus']/select[@disabled]"))).getFirstSelectedOption().getText(); 

   PaymStatus = driver.findElement(By.name("paymentStatus")).getText();
    BusMod = new Select(driver.findElement(By.id("businessModel"))).getFirstSelectedOption().getText();
    //BusMod = driver.findElement(By.id("businessModel")).getText();
   
    System.out.println("name=" + name + " status=" + status + " BIN=" + BIN + " apt=" + apt + " reg=" 
    	    + reg  + " chanell=" + chanell  + " contsigndate=" + contsigndate + " PaymStatus=" 
    	    + PaymStatus + " BusMod=" + BusMod);
    
    driver.findElement(By.linkText("Save")).click();
    File scrfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrfile1, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\hsis\\CDOSR\\scr1.png"));
	   Thread.sleep(2000);}
	  @Тогда ("^Пользователь переходит на сервис bsl$")
	  public void gotobsl() throws Exception {
   // driver.findElement(By.xpath("//tr[3]/td[2]/table/tbody/tr/td")).click();
    //driver.findElement(By.id("confirmBId")).click();
    //driver.findElement(By.xpath("(//a[contains(text(),'Yes')])[5]")).click();
    driver.get("https://bsl.kz63c2.kz.infra/bsl");
	  }
	  @И ("^Пользователь переходит к поиску торговых точек$")
	  public void gotosearch() throws Exception {
    driver.findElement(By.cssSelector("#UC09_250 > img")).click();
	  }
	  @Тогда ("^Пользователь пишет значение имени и фильтрует данные$")
	  public void filter() throws Exception {
    driver.findElement(By.name("formContent:partnerName")).sendKeys("test");
    driver.findElement(By.name("buttonPanel:search")).click();
    Thread.sleep(2000);
	  }
	  @Тогда ("^Драйвер сравнивает значения торговой точки в bsl и homesis$")
	  public void save_values2() throws Exception {
    String apt2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:contract-processing-type']")).getText();
	String BIN2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:tax-identification-number']")).getText();
	String name2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:name']")).getText();
    String status2= driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:status']")).getText();
    String PaymStatus2= driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:payment-status']")).getText();
    String contsigndate2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:contract-sign-date']")).getText();
   	String chanell2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:category']")).getText();
   	String reg2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:business-area']")).getText();
   	String code2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:code']")).getText();
   	String BusMod2 = driver.findElement(By.xpath("//span[@data-uid='salesroom-detail-panel:business-model']")).getText();
	  
    		System.out.print("contsigndate= " + contsigndate2 + " ");
    	    if (contsigndate2.equals(contsigndate)) System.out.println("Дата контракта совпадает");
    	    System.out.print("BIN= " + BIN2  + " ");
    	    if (BIN2.equals(BIN)) System.out.println("BIN совпадает");
    	    System.out.print("name= " + name2 + " ");
    	    if (name2.equals(name)) System.out.println("Имя совпадает"); else System.out.println("Имя не совпадает");
    	    System.out.print("status= " + status2 + " ");
    	    if (status2.equals(status)) System.out.println("Статус совпадает"); else System.out.println("Статус не совпадает");
    	    System.out.print("PaymStatus= " + PaymStatus2 + " ") ;
    	    if (status2.equals(status)) System.out.println("Статус совпадает"); else System.out.println("Статус не совпадает");
    	    System.out.print("Chanell= " + chanell2 + " ") ;
    	    if (chanell2.equals(chanell)) System.out.println("Chanell совпадает"); else System.out.println("Chanell не совпадает");
    	    System.out.print("Region= " + reg2 + " ") ;
    	    if (reg2.equals(reg)) System.out.println("Region совпадает"); else System.out.println("Region не совпадает");
    	    System.out.print("Code= " + code2 + " ") ;
    	    if (code2.equals(code)) System.out.println("Code совпадает"); else System.out.println("Code не совпадает");
    	    System.out.print("BusinessModel= " + BusMod2 + " ") ;
    	    if (BusMod2.equals(BusMod)) System.out.println("BusinessModel совпадает"); else System.out.println("BusinessModel не совпадает");
    File scrfile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile2, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\hsis\\CDOSR\\scr2.png"));
	 if( CheckDataOnSalesRoom.driver.toString().contains("null"))
	  {

	  System.out.print("All Browser windows are closed ");
	  }
	  else
	  {
		  CheckDataOnSalesRoom.driver.quit();
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
