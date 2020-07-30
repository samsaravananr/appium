package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
	public LoginPage(AndroidDriver<MobileElement> myD) 
	{
	
		PageFactory.initElements(new AppiumFieldDecorator(myD), this);
	}
	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	public WebElement loginname;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement countryList;
		
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement female;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Australia']")
	public WebElement countryData;
	
	
	public WebElement SignIn()
	{
		return LetsShop;
	}

}
