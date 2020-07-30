package ObjectRepository;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class basedemo2 {


	
	public AndroidDriver<MobileElement> myD;
    public static AppiumDriverLocalService service;
	
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

	public static AndroidDriver<MobileElement> baseapidemos() throws MalformedURLException 
	{
	

		

		 AndroidDriver<MobileElement> myD;
		 
		 File appDir = new File("src");
	     File app = new File(appDir, "ApiDemos-debug.apk");
	     
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SharonEmulator");
	     
	     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	     myD = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	     
	     return myD;

	}

}
