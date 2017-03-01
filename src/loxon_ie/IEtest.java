package loxon_ie;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xerces.impl.Constants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestResult;




 
public class IEtest {
	 	private static InternetExplorerDriver driver;
	 	WebElement element;
	 	private static DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	 	private boolean acceptNextAlert = true;
	 	private StringBuffer verificationErrors = new StringBuffer();
	 	Peremennie perm = new Peremennie();
	 
	 	protected boolean isAlertPresent() {
	        try {
	          driver.switchTo().alert();
	          return true;
	        } catch (NoAlertPresentException e) {
	          return false;
	        }
	      }
	 	
	 @BeforeClass
     public static void openBrowser(){
		 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	     //System.setProperty("webdriver.ie.profile", "default");
		 capabilities.setCapability("internetexplorer_binary","C:\\Program Files\\Internet Explorer\\iexplore.exe");
		 File file = new File("C:\\Users\\Eyumashev\\Documents\\ECLproj\\proj111\\IEDriverServer.exe");
		 System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		 capabilities.setCapability("open", true);
         capabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
       
         capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
         capabilities.setCapability("requireWindowFocus", true);
         driver = new InternetExplorerDriver(capabilities);
         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         driver.manage().window().maximize();
       

		} 
 
	 @Test
	 public void Search_exist_contracts() throws IOException, InterruptedException, AWTException
	 {
		 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.get("https://loxon.kz63c2.kz.infra/Collection");
	  
	   // driver.executeScript("document.getElementByName('j_username').setAttribute('homerselect', 'new value for element')");
	   // driver.executeScript("document.getElementByName('j_password').setAttribute('homerselect', 'new value for element')");
	    driver.findElement(By.name("j_username")).sendKeys(perm.login);
	    driver.findElement(By.name("j_password")).sendKeys(perm.pass);
	    driver.findElement(By.xpath(".//*[@id='sButton']")).click();
	  
	   // WebElement link = driver.findElement(By.xpath("//xpath of the element"));
	    //Actions newTab = new Actions(driver);
		//newTab.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  
	 //   driver.get("https://loxon.kz63c2.kz.infra/Collection/FramesetProd.html");
		 Thread.sleep(10000);
	 	    Set<String> allHandles = driver.getWindowHandles();
	 	    System.out.println("Count of windows:" + allHandles.size());
	 	    String currentWindowHandle = allHandles.iterator().next();
	 	    System.out.println("currentWindow Handle" +currentWindowHandle);
	 	    allHandles.remove(allHandles.iterator().next());
	 	    String lastHandle = allHandles.iterator().next();
	         System.out.println("last window handle"+lastHandle);
	         driver.switchTo().window(lastHandle);
	         System.out.println(driver.getTitle());
	    try{
	    
		//element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
		 }catch (UnhandledAlertException e){
			 Alert a = driver.switchTo().alert();
			 a.accept();
			  String alertMessage=driver.switchTo().alert().getText();	
			    System.out.println(alertMessage);
			   
			    driver.switchTo().alert().accept();
		 }
	 }
	    /*
	     *
	     */
	 

/*
	 

	    WebDriverWait wait = new WebDriverWait(driver, 120);
	   
        
	    //driver.switchTo().frame(0);
	  
    	
	    //driver.switchTo().frame("https://loxon.kz63c2.kz.infra/Collection/FramesetProd.html");
	   // driver.switchTo().frame(driver.findElement(By.id("ResizeableFrameSet")));
		  
	 
            //exception handling
		
	    // Assert.assertNotNull(element); 
	    ///String winHandleBefore = driver.getWindowHandle();
	 /*   for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	   }
	    if(isAlertPresent())
	    {
            System.out.println(isAlertPresent());
            driver.switchTo().alert().accept();
            driver.close();
        }
	      	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		    //driver.switchTo().frame(0);
	      		      	*/
	 /* 
	  
        driver.findElement(By.linkText("Поиск")).click();}
	    */
	   
	    
		 

/*public void checkAlert() throws IOException {
	      
	        }
	   
	   public void switchWindow() throws IOException {
		 

	   }
       public void findElement(){
//Switch back to original browser (first window)

		     driver.findElement(By.xpath("//span[contains(text(), 'Поиск']")).click();
			 System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	        // No alert found on page, proceed with test.
	    }
	 
	 
	    
	 
	 
	/* @Test
     public void Log_IN(){
 
		 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.get("https://loxon.kz63c2.kz.infra/Collection");
	    // driver.executeScript("document.getElementByName('j_username').setAttribute('homerselect', 'new value for element')");
	     // driver.executeScript("document.getElementByName('j_password').setAttribute('homerselect', 'new value for element')");
	     driver.findElement(By.name("j_username")).sendKeys("homerselect");
	     driver.findElement(By.name("j_password")).sendKeys("homerselect");
	     driver.findElement(By.id("sButton")).click();
	     try{
			 element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
		 }catch (Exception e){
			}
	    // Assert.assertNotNull(element);
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     //System.out.println(driver.switchTo().frame(1).getTitle());
	     
	     driver.close();
	     //driver.switchTo().frame(1);
     }
	 
	
 */
	 /*@Test
     public void inValid_UserCredential()
     {
		 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.get("http://www.store.demoqa.com");	
	     driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	     driver.findElement(By.id("log")).sendKeys("testuser");
	     driver.findElement(By.id("pwd")).sendKeys("Test@123");
	     driver.findElement(By.id("login")).click();
	     try{
			element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
	     }catch (Exception e){
			}
	     Assert.assertNotNull(element);
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
     }
 */
	 
	 @After
	 public void takeScreenShotOnFailure() throws IOException {
		  TestResult testResult = new TestResult();
			if (testResult.wasSuccessful() == true) {
				System.out.println(testResult.errors());
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C:\\Users\\Eyumashev\\Desktop\\TestCases\\loxon\\failures\\AuthorizationSearch.png"));
			}
	 }
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}
	