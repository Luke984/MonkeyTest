package com.Test;

import org.openqa.selenium.By;

import com.google.common.base.Function; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.*;
import com.galenframework.*;
//import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.common.collect.Iterables;
import org.openqa.selenium.Dimension;
import io.advantageous.boon.core.Str;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.*;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.asn1.x509.TargetInformation;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.xml.sax.InputSource;

import java.util.regex.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.mitm.RootCertificateGenerator;
import net.lightbody.bmp.proxy.*;
import net.sf.uadetector.internal.data.domain.OperatingSystem;
import scala.collection.concurrent.Debug;
import net.lightbody.*;


public class MonkeyTest {
	
	public String USERNAME;
	public String AUTOMATE_KEY;
	public String URL;
      public String lis;
	  private WebDriver driver;
	  private WebElement element;
	  public LoggingPreferences logs = new LoggingPreferences();
	  public String site;
	  private Collection siteBroken;
	// public BrowserMobProxy proxy  = new BrowserMobProxyServer();
	// public  Proxy seleniumProxy;
	 private DesiredCapabilities caps; 
	 private static Wait<WebDriver> wait;
	
@SuppressWarnings("unused")
	public void DriverSTD(String browser) throws MalformedURLException{
	 //System.setProperty("webdriver.chrome.driver", "..\\monkeytest\\chromedriver.exe");
	
	 this.setDriverPath(browser.toLowerCase());
	
}
public void DriverAPPIUM() throws IOException{
	//Process p = Runtime.getRuntime().exec("\"C:\\PROGRA~2\\Appium\\node.exe\" \"C:\\PROGRA~2\\Appium\\node_modules\\appium/bin\\Appium.js\" --no-reset --local-timezone");
	
	// Create object of  DesiredCapabilities class and specify android platform
		DesiredCapabilities capabilities=DesiredCapabilities.android();
		 
		 
		// set the capability to execute test in chrome browser
		 capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
		 
		// set the capability to execute our test in Android Platform
		   capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
		 
		// we need to define platform name
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		 
		// Set the device name as well (you can give any name)
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
		 
		 // set the android version as well 
		   capabilities.setCapability(MobileCapabilityType.VERSION,"5.0.1");
		 
		 // Create object of URL class and specify the appium server address
		 URL url= new URL("http://127.0.0.1:4723/wd/hub");
		 
		// Create object of  AndroidDriver class and pass the url and capability that we created
		this.driver = new AndroidDriver(url, capabilities);
}
private void DriverBROWSERSTACK(Object capex) throws MalformedURLException{
	 this.USERNAME = "rcsdigitalttesta1";
	 this.AUTOMATE_KEY = "6eJ64AGNzqaojLhYRFXZ";
	 this.URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	 caps = new DesiredCapabilities();
	// caps.setCapability("browser", "IE");
	// caps.setCapability("browser_version", "11");
	 caps.setCapability("browserName", "iPhone");
	 caps.setCapability("platform", "MAC");
	 caps.setCapability("device", "iPhone 6S Plus");
	/* caps.setCapability("os", "windows");
	    caps.setCapability("os_version", "7");
	    caps.setCapability("device","iPhone 6S Plus");
	    caps.setCapability("browserstack.debug", true);
	    caps.setCapability("resolution", "1680x1050");
	    caps.setCapability("project", "checkHALFPAGEMOB-1680x1050");
	    caps.setCapability("build", "checkHALFPAGEMOB-x10-corriere");*/
	    //caps.setCapability("browserstack.selenium_version", "3.0.0-beta2");
	 /*caps.setCapability("browser", BrowserType.CHROME);
		 caps.setCapability("browser_version",BrowserVersion.CHROME);
		 caps.setCapability("os", Platform.WIN8_1);
		 caps.setCapability("os_version", Platform.ANY);
		 caps.setCapability("resolution", "1024x768");*/
		
	this.driver = new RemoteWebDriver(new URL(URL), caps);
}
@SuppressWarnings("deprecation")
private void setDriverPath(String type) throws MalformedURLException{
	String prop1 = "";
	String prop2 = "";	
	DesiredCapabilities capabilities;
	switch(type){
	case "ie" :  System.out.println(this.driver);
		prop1 = "webdriver.ie.driver";
	prop2 = "..\\monkeytest\\IEDriverServer.exe"; 
	try{
		System.setProperty(prop1,prop2);}catch(Exception e){System.out.println(e);}
	capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
	capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
	capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
//	capabilities.setCapability(CapabilityType.PROXY, this.seleniumProxy);
	capabilities.setCapability(CapabilityType.LOGGING_PREFS, true);
	this.driver = new InternetExplorerDriver(capabilities); 

		break;
	case "firefox" :
		prop1 = "webdriver.gecko.driver";
		prop2 = System.getProperty("user.dir")+"\\geckodriver.exe"; 
	
		try{
			System.setProperty(prop1,prop2);}catch(Exception e){System.out.println(e);}
		capabilities = DesiredCapabilities.firefox();
		//capabilities.setBrowserName("firefox");
		//capabilities.setCapability("marionette", true);*/
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
		capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		//capabilities.setCapability(CapabilityType.PROXY, this.seleniumProxy);
		//capabilities.setCapability(CapabilityType.LOGGING_PREFS, true);
		this.driver = new FirefoxDriver(capabilities);
		 /*wait = new WebDriverWait(driver, 3000);
		//capabilities.setCapability(FirefoxDriver.MARIONETTE, true);		
*/		
		break;
	case "chrome" : System.out.println(this.driver);
		prop1 = "webdriver.chrome.driver";
					prop2 = "..\\monkeytest\\chromedriver.exe"; 
					try{
						System.setProperty(prop1,prop2);}catch(Exception e){System.out.println(e);}
					capabilities = DesiredCapabilities.chrome();
		/*			if(this.seleniumProxy!=null)
					capabilities.setCapability(CapabilityType.PROXY, this.seleniumProxy);*/
					this.driver = new ChromeDriver(capabilities);
					break;
	case "browserstack" : Object capex = new Object(); 
						this.DriverBROWSERSTACK(capex); 
						break;
	case "appium" : try {
			this.DriverAPPIUM();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			System.out.println("controllare se appium è partito");
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} break;
	
	
	default : 	prop1 = "webdriver.chrome.driver";
				prop2 = "..\\monkeytest\\chromedriver.exe"; 
				try{
					System.setProperty(prop1,prop2);}catch(Exception e){System.out.println(e);}
				capabilities = DesiredCapabilities.chrome();
				//capabilities.setCapability(CapabilityType.PROXY, this.seleniumProxy);
				this.driver = new ChromeDriver(capabilities);
				
	
	
	}

//return(new String[]{ ans1, ans2 });
}

	    
		/*public static final String USERNAME = "federicoricchi";
		  public static final String AUTOMATE_KEY = "Ltfzz8qq2zK1JEutymp5";
		  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	      */
		
		 
		 public boolean setProxy(){
			 //this.proxy = new BrowserMobProxyServer();
			 boolean res = true;
			 try{
		/*	 this.proxy.start() ;
			  this.seleniumProxy = ClientUtil.createSeleniumProxy(this.proxy);
			  this.proxy.newHar("prova");*/ 
			 }catch(Exception e){
				  res=false;
			  }
			
		     return(res);
		 }
		  //private Proxy proxy = new Proxy();
		 @Before
		  public void startup() throws Exception {
			/* System.setProperty("webdriver.chrome.driver", "..\\monkeytest\\chromedriver.exe");*/
			 //this.site = "http://www.corriere.it";
			/* DesiredCapabilities capabilities = DesiredCapabilities.chrome();*/
			 LoggingPreferences logs = new LoggingPreferences();
			 logs.enable(LogType.BROWSER, Level.ALL);
			 logs.enable(LogType.DRIVER, Level.ALL);
			 logs.enable(LogType.CLIENT, Level.ALL);
			 logs.enable(LogType.PERFORMANCE, Level.ALL);
			 logs.enable(LogType.PROFILER, Level.ALL);
			/*qua c'era proxy setup*/
				
			 
			 // this.setDriverPath(type);
			  
			/* capabilities.setCapability(CapabilityType.PROXY, this.seleniumProxy); */

			/* this.driver = new ChromeDriver(capabilities);*/
			
			System.out.println(this.site);
	this.driver.get(this.site);
	   this.monkeyDoClickForCP();
			    	
	  // this.proxy.newHar("prova");
	   this.driver.get(this.site);
	 
	   //this.proxy.waitForQuiescence(60, 60, TimeUnit.SECONDS);
			 //capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
	 

			 // proxy.setHttpProxy("localhost:8888");
			  /*DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability("browserName", "iPhone");
			  caps.setCapability("platform", "MAC");
			  caps.setCapability("device", "iPhone 6S Plus");
			
			  caps.setCapability("build", "0.1");
			  caps.setCapability("project", "MTest Plan On All Site");
			  caps.setCapability("browserstack.debug","true");
			*/
			  //caps.setCapability(CapabilityType.LOGGING_PREFS, logs); 
			  //caps.setCapability("proxy", proxy);
			 // caps.setCapability("browserstack.local", "true");
			 // caps.setCapability("browserstack.localIdentifier", "Tiesto");
			//  System.getProperties().put("http.proxyHost", "localhost");
			//  System.getProperties().put("http.proxyPort", "8888");

			  
			  
			  
			
			    //caps.setCapability("browserstack.debug", "true");
			    //caps.setCapability("resolution", "1600x1200");
			    
			    //System.getProperties().put("http.proxyHost", "10.0.2.15");
			    //System.getProperties().put("http.proxyPort", "8888");
			 
			  //driver = new RemoteWebDriver(new URL(URL), caps);
			//	System.setProperty("webdriver.chrome.logfile","H:\\documenti\\condivisa\\projects\\monkeytest\\cd.log");
				
				
			    
		  }
		
		  public void analyzeLog() {
			  //LogEntries logs = driver.manage().logs().get("browser");
		        LogEntries logEntries = driver.manage().logs().get(LogType.PROFILER);
		        for (LogEntry entry : logEntries) {
		            System.out.println( entry.getLevel() + " " + entry.getMessage());
		            //do something useful with the data
		        }
		    }
		
		  private boolean monkeyDoClick(By p)  throws Exception{
			  boolean b = false;
			  if(!driver.findElements(p).isEmpty())
			  {	  
				  element = driver.findElement(p);
			      element.click();
			      b=true;
			  }
			  return(b);
		  }
		  
		  private void monkeyDoClickForCP() throws Exception
		  {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try{if(!monkeyDoClick(By.className("iubenda-cs-close-btn")))
			{	
				if(!monkeyDoClick(By.id("AcceptButton")))
				{
					System.out.println("controllare ");
					
				}
			}}catch(Exception e){System.out.println(e);}
		  }
		 private Object monkeyJSRUN(String poi) throws Exception {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			
			 //String script = "return typeof("+poi+")=='string'?"+poi+":false";
			 Object ret = js.executeScript("return typeof("+poi+")=='string'?"+poi+":false");
			 return(ret);
		 }
		 
		 /* private Object monkeyListen(String pattern) throws Exception{
		
			 	Har provahar = this.proxy.endHar();
				Object ret = provahar ;
				provahar.writeTo(new File("provatesthar.txt"));
		  //provahar.writeTo(new OutputStreamWriter(System.out));
		  List<HarEntry> entries = provahar.getLog().getEntries();
		  //System.out.println(provahar.getLog().getPages().toString());
		    for (HarEntry entry : entries) {
		        String response = entry.getRequest().getUrl();
		        String responseTemplate = entry.getResponse().toString(); 
		        System.out.println("RESPONSE " + response);
		        System.out.println(responseTemplate);
		    }
		     
		    return(ret);
			 
		 }*/
		 
		  
		@Ignore
		  @Test
		  public String monkeyCheckSitepage() throws Exception{
			 Thread.sleep(30000);
			  //var p1 = typeof(OAS_sitepage)=='string'?console.log(OAS_sitepage):console.log('assente'); return p1;
			  //assertFalse("la variabile Sitepage non esiste in pagina", ret.toString().compareTo("assente")==0?true:false);
			  System.out.println( monkeyJSRUN("OAS_sitepage"));
			  return("la Sitepage e' "+monkeyJSRUN("OAS_sitepage"));
		  }
		  @Ignore("Im Not Ready")
		  @Test
		  public String monkeyScreeny() throws Exception{
			  String provaRest;
			  System.out.println("entrato in screeny");
			  System.out.println(driver);
			  WebDriver AugDriver = new Augmenter().augment(driver);
			  Thread.sleep(30000);
			  AugDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  String por ="presente campagna maggiore o non presente frame1";
			 // Thread.sleep(10000);
			  //if(!caps.getCapability("os_version").toString().contains("7") && caps.getCapability("browser_version").toString().contains("10"))
			 /* try{
				  if(!AugDriver.findElements(By.id("play_video_skin")).isEmpty()){
				  this.monkeyDoClick(By.id("play_video_skin"));
				  System.out.println("ho cliccato il bottone di apertura");
				  } 
				  else{
					  if
				  (!AugDriver.findElements(By.id("close_video_button_reale")).isEmpty()){
					  this.monkeyDoClick(By.id(" close_video_button_reale"));
					  System.out.println("ho cliccato il bottone di chiusura");
					  }
				}
			  }catch(Exception e){
				 				 
				  System.out.println("sono nel catch");
				  por = "non trovato il blocco playvideo";
				 // siteBroken.add(this.site);
			  }*/
			 List <WebElement> isPresent =AugDriver.findElements(By.id("oas_Bottom"));
			 // provaRest = js.executeScript("function prova(){var scripts = document.getElementsByTagName('script'); var opp = 'no'; for (i=0;i<scripts.length;i++){ if(scripts[i].src.indexOf('mjx.js') >-1){opp='presente';}}return(opp);} return(prova());").toString();
			  //System.out.println(provaRest);
			  //if(isPresent.size() != 0){
			// if(AugDriver.findElement(By.id("video_player_background")))
		
			
			 System.out.println(AugDriver.findElement(By.id("oas_Bottom")).isEnabled());
			 if(AugDriver.findElement(By.id("oas_Bottom")).isEnabled()){
			//	 AugDriver.findElement(By.id("video_player_background")).getScreenshotAs(( OutputType.BASE64));
				
						 System.out.println(AugDriver.findElement(By.id("oas_Frame1")));
			 }
			Integer reto = AugDriver.findElement(By.id("oas_Bottom")).getLocation().getX();
			 js.executeScript("window.scrollTo(0,"+reto+")");
			 js.executeScript("window.scrollTo(document.getElementById('oas_Bottom').getBoundingClientRect().right,document.getElementById('oas_Bottom').getBoundingClientRect().top)");
			   //		+ "");
			  //js.executeScript("document.body.style.zoom = 0.5;");
			  //WebElement html = driver.findElement(By.tagName("html"));
				//html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			  //Robot robot = new Robot();
			  //robot.mouseMove(30, 30);
			  //Thread.sleep(60000);
			 // AugDriver.mouse_move_to_location(element => "body", xoffset => 10, yoffset => 20);
				byte[] srcFile = ((TakesScreenshot) AugDriver).getScreenshotAs(OutputType.BASE64).getBytes();
			
			  por=por+"OK presente";
		//	}
			  AugDriver.close();
			  driver.quit();
			   //FileUtils.copyFile(srcFile, new File("/location/to/screenshot.png"));
				 return("scritto screenshot: "+por);
		  }
		  public String monkeySiteRufusXML(String fileXml){
			
			  
			  
			  return AUTOMATE_KEY;	  
		  }
		  public String monkeyScreenyTarget(String[] Target) throws Exception{
			  Integer reto = 0;
			  String por="";
			  if(Target.length<1)
				  Target[0] ="Body";
			  else{
			  System.out.println("questo e' target"+Target[1]);
			  //System.exit(0);
			  String provaRest;
			  System.out.println("entrato in screeny");
			  System.out.println(driver);
			 
			  WebDriver AugDriver = new Augmenter().augment(driver);
			  Thread.sleep(30000);
			  AugDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  por ="presente campagna maggiore o non presente frame1";
			 // Thread.sleep(10000);
			  //if(!caps.getCapability("os_version").toString().contains("7") && caps.getCapability("browser_version").toString().contains("10"))
			 /* try{
				  if(!AugDriver.findElements(By.id("play_video_skin")).isEmpty()){
				  this.monkeyDoClick(By.id("play_video_skin"));
				  System.out.println("ho cliccato il bottone di apertura");
				  } 
				  else{
					  if
				  (!AugDriver.findElements(By.id("close_video_button_reale")).isEmpty()){
					  this.monkeyDoClick(By.id(" close_video_button_reale"));
					  System.out.println("ho cliccato il bottone di chiusura");
					  }
				}
			  }catch(Exception e){
				 				 
				  System.out.println("sono nel catch");
				  por = "non trovato il blocco playvideo";
				 // siteBroken.add(this.site);
			  }*/
			  for(int i=1;i<Target.length;i++){
			  List <WebElement> isPresent =AugDriver.findElements(By.id(Target[i]));
			  if(!isPresent.isEmpty()){
			
			 // provaRest = js.executeScript("function prova(){var scripts = document.getElementsByTagName('script'); var opp = 'no'; for (i=0;i<scripts.length;i++){ if(scripts[i].src.indexOf('mjx.js') >-1){opp='presente';}}return(opp);} return(prova());").toString();
			  //System.out.println(provaRest);
			  //if(isPresent.size() != 0){
			 reto = AugDriver.findElement(By.id(Target[i])).getLocation().getX();
			
			//js.executeScript("window.scrollTo(document.getElementById('video_player_background').getBoundingClientRect().right,document.getElementById('video_player_background').getBoundingClientRect().top)");
			   //		+ "");
			  //js.executeScript("document.body.style.zoom = 0.5;");
			  //WebElement html = driver.findElement(By.tagName("html"));
				//html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			  //Robot robot = new Robot();
			  //robot.mouseMove(30, 30);
			  //Thread.sleep(60000);
			 // AugDriver.mouse_move_to_location(element => "body", xoffset => 10, yoffset => 20);
				
		//	}
			 
			   //FileUtils.copyFile(srcFile, new File("/location/to/screenshot.png"));
			  }
			  else{
				  if(!AugDriver.findElements(By.tagName(Target[i])).isEmpty()){
					  reto = AugDriver.findElement(By.tagName(Target[i])).getLocation().getX(); 
				  }
				  else{
					  if(!AugDriver.findElements(By.className(Target[i])).isEmpty()){
						  reto = AugDriver.findElement(By.className(Target[i])).getLocation().getX(); 
					  }
					  
				  }
			  }
			  js.executeScript("window.scrollTo(0,"+reto+")");
			  byte[] srcFile = ((TakesScreenshot) AugDriver).getScreenshotAs(OutputType.BASE64).getBytes();
				
			  por=por+"OK presente";
			  
			  }
			  AugDriver.close();
			  }
			  
			  driver.quit();
			  return("scritto screenshot: "+por);
			  
			  }
		
		  public String monkeyScreenyNotAug() throws Exception{
			  Actions prova = new Actions(driver);
			  
			  System.out.println("sono entrato");
			  Thread.sleep(30000);
		
			  WebElement firstElement = (WebElement) Iterables.getFirst(this.driver.findElements(By.id("test_frame1")),1);
			 System.out.println(firstElement.getLocation().y);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom=0.2");
			 //prova.moveToElement(firstElement).build().perform();
			  //prova.perform();
			  System.out.println("passati 10 sec ? ");
			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  System.out.println(scrFile);
			  
			  //FileUtils.copyFile(scrFile, new File("C:\\Users\\arthurdent\\Pictures\\prova\\screenshotsscreenshot"+Math.random()+".png"));
			  return("scritto screenshot");
		  }
		  
		  @Test
		  public String monkeyCheckListpos() throws Exception{
			  System.out.println( monkeyJSRUN("OAS_listpos"));
			  return("la Sitepage e' "+monkeyJSRUN("OAS_listpos"));
		  }
		  @Ignore("Im Not Ready")
		  @Test
		  public String monkeyCheckListposDX() throws Exception{
			  System.out.println("passa 1 minuto ?");
			  Thread.sleep(4000);
			  this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				System.out.println("passato?");
			  //System.out.println( monkeyJSRUN("listPosDx"));
			  return("la Listpos e' "+monkeyJSRUN("listPosDx"));
		  }
		  @Ignore
		  @Test
		  public void monkeyGetScode() throws Exception{}
		  @Ignore("già fatto")
		  @Test
		  public String monkeyCountOAS() throws Exception{
			  //element = driver.findElement(By.tagName("body")); 
			  int count = 0;
			  
			  String  page = driver.getPageSource();
			  System.out.println(page);
		      Pattern pattern = Pattern.compile("OAS_AD");
		      Matcher matcher = pattern.matcher(page);
		     while(matcher.find()) 
		    	  count++;
		     return("le occorrenze di OAS sono : "+count);
		      
		      //System.out.println("questo e' il page : "+page);
		     // System.out.println("questo e' il source : "+driver.getPageSource());
		  }
		  @Ignore
		  /*  @Test
		public String monkeyErrorLog() throws Exception{
			  System.out.println("ciao sono qua");
			  RootCertificateGenerator rootCertificateGenerator = RootCertificateGenerator.builder().build();
			  boolean test = false;
			   long quietPeriod = 1;
			   long timeout = 1;
			   
				while(timeout < 20) 
				{	 
					test = this.proxy.waitForQuiescence(quietPeriod, timeout, TimeUnit.SECONDS);  
					 System.out.println("ecco "+test);
					 quietPeriod++;
					 timeout = quietPeriod+6;
					 System.out.println(timeout);
					 System.out.println(quietPeriod);
				}
			  
			  
			
			 // FileOutputStream fos = new FileOutputStream(strFilePath);
			  //DesiredCapabilities caps = new DesiredCapabilities();
			 // this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			   List<String> ListaR = new ArrayList <String>();
			  //this.driver.get("http://www.corriere.it");
				Har provahar = this.proxy.endHar();
					provahar.writeTo(new File("provatesthar"+Math.random()+".txt"));
			  //provahar.writeTo(new OutputStreamWriter(System.out));
			  List<HarEntry> entries = provahar.getLog().getEntries();
			  System.out.println(provahar.getLog().getPages().toString());
			    for (HarEntry entry : entries) {
			        String response = entry.getRequest().getUrl();
			        if(response.contains("test_xaxis"))
			        { System.out.println("RESPONSE " + response);
			        	ListaR.add(response);}
			        String responseTemplate = entry.getResponse().toString(); 
			       
			        //System.out.println(responseTemplate);
			        
			    }
			    for(String el : ListaR)
			    {
			    	System.out.println("chiamata :" +el);
			    }
			 //System.out.println(provahar.getLog());
			  //System.out.println(provahar.getLog().toString());
			 //System.out.println("QUESTO : "+provahar.toString());
			  
			  
			 
			return("Letto");  
			  
			  
		  }*/
		  @Test
		  /*public void monkeyExecuteOnReal() throws Exception{
			  driver = new RemoteWebDriver();
			  
		  }*/
		  public String monkeySitemap(String url){
			  /******************************************************
			   * Da modificare con crawler interno e classe separata
			   *****************************************************/
			  WebDriver driverSMap;
			  String document = null;
			 String proper1 = "webdriver.chrome.driver";
			 String	proper2 = "..\\monkeytest\\chromedriver.exe"; 
				try{
					System.setProperty(proper1,proper2);}catch(Exception e){System.out.println(e);}
				driverSMap = new ChromeDriver(DesiredCapabilities.chrome());
				driverSMap.get("https://www.xml-sitemaps.com/");
				WebElement inputElement = driverSMap.findElement(By.name("initurl")) ;  //findElement(By.tagName("initurl"));
				inputElement.clear();
				inputElement.sendKeys(url);
				//here you have to wait for javascript to finish. E.g wait for a css Class or id to appear
				driverSMap.findElement(By.name("submit")).click();
				//WebElement DynamicElement = (new WebDriverWait(driverSMap, 10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("TextArea")));
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driverSMap)
					    .withTimeout(60, TimeUnit.MINUTES)
					    .pollingEvery(5, TimeUnit.SECONDS)
					    .ignoring(NoSuchElementException.class);
//import java.util.function.Function;
			
					WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
					{ 
					@Override
					  public WebElement apply(WebDriver driverSMap) {
					  return driverSMap.findElement(By.tagName("TextArea"));
					}
					}); 
					System.out.println(foo.getAttribute("value").toString());
				// driverSMap.close();
				  
				   return(foo.getAttribute("value").toString()); 
				//System.out.println(Document);
		  }
		  public void monkeyBho(){
			  
			  Actions prova = new Actions(driver); 
			  //String jscript = "chrome.devtools.network.onRequestFinished.addListener(function(request) {return(request.response.bodySize)";
		
		    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    prova.moveToElement(this.driver.findElement(By.id("oas_Bottom1")));
		    prova.perform();

		    System.out.println(this.driver.getTitle());
		  }
		  
		  

		  
		}




