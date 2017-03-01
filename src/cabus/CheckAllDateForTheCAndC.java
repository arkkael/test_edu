package cabus;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import junit.framework.TestResult;



public class CheckAllDateForTheCAndC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String name, name2;
  private String lastName, lastName2;
  private String midName, midName2;
  private String IIN, IIN2;
  private String birth, birth2;
  private String houseNum, houseNum2;
  private String street, street2;
  private String flatNum, flatNum2;
  private String dist, dist2;
  private String town, town2;
  private String post, post2;
  
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
  public void testCheckAllDateForTheCAndC() throws Exception {
	  driver.manage().window().maximize();
	    ((JavascriptExecutor) driver).executeScript("window.focus();");
	  driver.get(baseUrl);
	  driver.findElement(By.id("IDToken1")).clear();
	    driver.findElement(By.id("IDToken1")).sendKeys(perm.login);
	    driver.findElement(By.id("IDToken2")).clear();
	    driver.findElement(By.id("IDToken2")).sendKeys(perm.pass);
	    driver.findElement(By.name("Login.Submit")).click();
	    Thread.sleep(2000);
    driver.findElement(By.cssSelector("a.fa.fa-chevron-down")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[7]/div/a/span")).click();
    driver.findElement(By.xpath("//header[@id='header']/div/div[3]/em-main-menu/div/div/div/div/ul/li/div[2]/div/ul/li[7]/div/a/span")).click();
    new Select(driver.findElement(By.name("leftside"))).selectByVisibleText("Contract number");
    Thread.sleep(1000);
    
    Select e = new Select(driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div/div[2]/select")));
    e.selectByVisibleText("contain");
     
    Thread.sleep(3000);
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).clear();
    driver.findElement(By.id("emMetawidgetNgModelRoperand")).sendKeys("36002");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//em-advanced-filter[@id='em-EM-ADVANCED-FILTER_cms_cards']/div/form/div/div[2]/div[3]/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//em-table[@id='em-EM-TABLE_cms_cards']/div/div[2]/div[2]/div/table/tbody[2]/tr/td[17]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("a > output.text-output.ng-binding")).click();
    Thread.sleep(1000);
    File scrfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrfile1, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\cabus\\CADFTCAC\\scr1.png"));
	   name = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelHolderName']/output")).getText();
	   lastName = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelName2']/output")).getText();
	   midName = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelNameMid']/output")).getText();
	   IIN = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelIndividualIdentificationNumber']/output")).getText();
	   birth = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelHolderBirthdate']/output")).getText();
	   houseNum = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelAddress.house']/output")).getText();
	   street = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelAddress.street']/output")).getText();
	   flatNum = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelAddress.flat']/output")).getText();
	   dist = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelAddress.district']/output")).getText();
	   town = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelAddress.town']/output")).getText();
	   post = driver.findElement(By.xpath(".//*[@id='emMetawidgetNgModelAddress.zip']/output")).getText();
	   //driver.switchTo().window("https://cifconsole.kz63c2.kz.infra/cif-console/adminPage/cuid/129/lang?0");
    System.out.println("name= " + name + " lastName= " + lastName + " midName= " + midName + " IIN=" + 
	   " birth" + birth + " address=" + town + dist + street + houseNum + flatNum + " post= " + post);
	   Set<String> sid=driver.getWindowHandles();
	   Iterator<String> it=sid.iterator();
	   String parentId=it.next();
	 //  System.out.println(parentId);
	   String childId=it.next();
	  // System.out.println(childId);
	   driver.switchTo().window(childId);
	   Thread.sleep(4000);
	   name2 = driver.findElement(By.xpath(".//*[@id='component1b']")).getAttribute("value");
	   lastName2 = driver.findElement(By.xpath(".//*[@id='component1a']")).getAttribute("value");
	   midName2 = driver.findElement(By.xpath(".//*[@id='component1c']")).getAttribute("value");
	   IIN2 = driver.findElement(By.xpath(".//*[@id='component23']")).getAttribute("value");
	   birth2 = driver.findElement(By.xpath(".//*[@id='component3']")).getAttribute("value");
	   driver.findElement(By.xpath(".//*[@id='linkc']/span")).click();
	   houseNum2 = driver.findElement(By.xpath(".//*[@id='id145']/td[2]/div")).getText();
	   street2 = driver.findElement(By.xpath(".//*[@id='id145']/td[7]/div")).getText();
	   flatNum2 = driver.findElement(By.xpath(".//*[@id='id145']/td[3]/div")).getText();
	   dist2 = driver.findElement(By.xpath(".//*[@id='id145']/td[4]/div")).getText();
	   town2 = driver.findElement(By.xpath(".//*[@id='id145']/td[8]/div")).getText();
	   post2 = driver.findElement(By.xpath(".//*[@id='id145']/td[9]/div")).getText();
	   System.out.print("name= " + name2 + " ");
	    if (name2.equals(name)) System.out.println("name совпадает"); else System.out.println("name не совпадает");
	    System.out.print("lastName2=" + lastName2 + " ");
	    if (lastName2.equals(lastName)) System.out.println("lastName совпадает"); else System.out.println("lastName не совпадает");
	    System.out.print("midName2= " + midName2 + " ");
	    if (midName2.equals(midName)) System.out.println("midName2 совпадает"); else System.out.println("midName2 не совпадает");
	    System.out.print("IIN2=" + IIN2 + " ");
	    if (IIN2.equals(IIN)) System.out.println("IIN2 совпадает"); else System.out.println("IIN2 не совпадает");
	    System.out.print("birth2= " + birth2 + " ");
	    if (birth2.equals(birth)) System.out.println("birth2 совпадает"); else System.out.println("birth2 не совпадает");
	    System.out.print("Address: House= " + houseNum2 + " street= " + street2 + " flat= " + 
	    		flatNum2 + " dist= " + dist2 + " town= " + town2);
	    if (houseNum2.equals(houseNum) && street2.equals(street) && flatNum2.equals(flatNum) && dist2.equals(dist)
	    		 && town2.equals(town))
	    	System.out.println("Address совпадает"); else System.out.println("Address не совпадает");
	    System.out.print("post2= " + post2 + " ");
	    if (post2.equals(post)) System.out.println("post совпадает"); else System.out.println("post не совпадает");
	 

	 
	   File scrfile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrfile2, new File("C:\\Users\\EYUMASHEV\\Desktop\\TestCases\\cabus\\CADFTCAC\\scr2.png"));
  }

  @After
  public void takeScreenShotOnFailure() throws IOException {
	  TestResult testResult = new TestResult();
		if (testResult.wasSuccessful() == true) {
			System.out.println(testResult.errors());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Eyumashev\\Desktop\\TestCases\\cabus\\failures\\CheckDate.png"));
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
