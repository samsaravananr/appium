

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.Preferences;
import ObjectRepository.basedemo2;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainTCApiDemos extends basedemo2{

	@Test(dataProvider = "InputData", dataProviderClass = TestData.class)
	public void apidemosfun(String vName) throws Exception
	{
		service=startServer();
		
		AndroidDriver<MobileElement> myD=baseapidemos();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
		HomePage home=new HomePage(myD);
		Preferences pref=new Preferences(myD);
		
		home.Preferences.click();
		
		
		myD.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

		//myD.findElementByXPath("//android.widget.CheckBox[@index='0']").click();
		
		myD.findElementById("android:id/checkbox").click();
		
		myD.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		myD.findElementById("android:id/edit").sendKeys(vName);
		Thread.sleep(4000);
		
		pref.buttons.get(1).click();
		
		
		Thread.sleep(5000);
		myD.closeApp();

		service.stop();
	}

}
