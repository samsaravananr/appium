package ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;
import com.google.common.util.concurrent.Service;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base 
{
	public static AndroidDriver<MobileElement> myD;
	public static AppiumDriverLocalService service;
	public static DateFormat dateFormat;
	public static File vFile;
	
	public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\SupportingFiles\\startEmulator.bat");
		Thread.sleep(20000);
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	
	public AndroidDriver<MobileElement> basecall() throws Exception 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\SARAVANAN R\\Mobile\\E2EFramework\\src\\main\\java\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String vPacakge=prop.getProperty("PackageName");
		String vActivity=prop.getProperty("ActivityName");
		//String vDevice=prop.getProperty("EmulatorName");
		
		String vDevice=System.getProperty("cDN");
		
		//String vDevice=(String) prop.get("device");


		
		System.out.println("This is before startemulator");
		Thread.sleep(5000);
		
		startEmulator();
		
		   	DesiredCapabilities cap = new DesiredCapabilities();
	     	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, vDevice);
			
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, vPacakge);
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, vActivity);
			cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
			myD = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			
			return myD;

	}

	public static void takeScreenShot() 
	{
	 // Set folder name to store screenshots.
	  String destDir = "screenshots";
	  // Capture screenshot.
	  File scrFile = ((TakesScreenshot) myD).getScreenshotAs(OutputType.FILE);
	  // Set date format to set It as screenshot file name.
	  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	  // Create folder under project with name "screenshots" provided to destDir.
	  new File(destDir).mkdirs();
	  // Set file name using current date time.
	  String destFile = dateFormat.format(new Date()) + ".png";
	  
	  

	  try {
	   // Copy paste file at destination folder location
	   Files.copy(scrFile, new File(destDir + "/" + destFile));
	   vFile=new File("C:\\Users\\SARAVANAN R\\Mobile\\E2EFramework\\screenshots\\"+destFile);
	   System.out.println(vFile);
	  } catch (IOException e) {
	   e.printStackTrace();
	  }

	}
}
