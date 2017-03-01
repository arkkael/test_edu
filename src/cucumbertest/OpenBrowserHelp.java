package cucumbertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenBrowserHelp {
private WebDriver driver;
private static OpenBrowserHelp browserHelp;

private OpenBrowserHelp() {
	 System.setProperty("webdriver.gecko.driver","C:\\Users\\EYUMASHEV\\Documents\\ECLproj\\proj111\\geckodriver1.exe");
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
	    	    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    this.driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
}

public static OpenBrowserHelp getOpenBrowserHelp() {
    if (null == browserHelp) {
        browserHelp = new OpenBrowserHelp();
    }
    return browserHelp;
}

public WebDriver getDriver() {
    return driver;
}

void setDriver(WebDriver driver) {
    this.driver = driver;
}

public void printSingleton() {
    System.out.println("Inside print Singleton");
}
}