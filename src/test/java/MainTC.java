import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.Base;
import ObjectRepository.LoginPage;
import ObjectRepository.VerifyCartPage;
import SupportingFiles.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainTC extends Base {
	
	@Test 
	public void sam() throws Exception
	{
		service=startServer();
		
		
		
		
		AndroidDriver<MobileElement> myD=basecall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage LP=new LoginPage(myD);
		LP.countryList.click();
		
		Utilities uti=new Utilities(myD);
		uti.scrollToText("Australia");
		Thread.sleep(4000);
		LP.countryData.click();
		LP.female.click();
		LP.loginname.sendKeys("Sharon");
		myD.hideKeyboard();
		LP.LetsShop.click();
		Thread.sleep(3000);
		AddToCart ac=new AddToCart(myD);
		Thread.sleep(3000);
		VerifyCartPage vp=new VerifyCartPage(myD);
		String vPrice1=vp.ProductPrice.get(0).getText();
		String vPrice2=vp.ProductPrice.get(1).getText();
		String vTotal=vp.TotalAmount.getText();
		
		System.out.println("Price 1  "+vPrice1);
		System.out.println("Price 2  "+vPrice2);
		System.out.println("Total    "+vTotal);
		
		myD.closeApp();
		
		service.stop();
			
	}
	
	@BeforeTest
	public void killprocess() throws Exception
	{
		System.out.println("All TASK KILLED");
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
}
